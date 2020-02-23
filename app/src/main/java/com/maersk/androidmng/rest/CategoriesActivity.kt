package com.maersk.androidmng.rest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.maersk.androidmng.LLActivity
import com.maersk.androidmng.R
import com.maersk.androidmng.rest.api.BasePaths
import com.maersk.androidmng.rest.api.RestClient
import com.maersk.androidmng.rest.model.categoryresponse.CategoriesResponse
import com.maersk.androidmng.rest.model.citis.CityResponse
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.content_categories.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoriesActivity : AppCompatActivity() {
    private lateinit var database1: DatabaseReference
    private lateinit var myRef: DatabaseReference
    val TAG = CategoriesActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setSupportActionBar(toolbar)

        // Write a message to the database
        // Write a message to the database
//        val database = FirebaseDatabase.getInstance()
//        myRef = database.getReference("message")
//        database1 = FirebaseDatabase.getInstance().reference
//        myRef.setValue("Hello, World!")


        getCities.setOnClickListener { doValidCity() }
        getCat.setOnClickListener { doCategoryApi() }

        fab.setOnClickListener { view ->
            startActivity(Intent(this@CategoriesActivity, LLActivity::class.java))
        }
    }

    private fun doValidCity() {

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) { // This method is called once with the initial value and again
// whenever data at this location is updated.
                val value =
                    dataSnapshot.getValue(String::class.java)!!
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        if (citiSearch.text.toString().isEmpty()) {

            Toast.makeText(
                citiSearch.context,
                "Enter The City Name",
                Toast.LENGTH_LONG
            )
                .show()
        } else {
            var firebaseAnalytics = FirebaseAnalytics.getInstance(this)
            val bundle = Bundle()
            bundle.putString(FirebaseAnalytics.Param.METHOD, "doValidCity")
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, bundle)
            doCityApi(citiSearch.text.toString())
        }
    }

    private fun doCityApi(cityName: String) {
        val retro: BasePaths = RestClient.getRetroFitObj().create(BasePaths::class.java)

        val callCityApi = retro.getCities(cityName)

        callCityApi.enqueue(object : Callback<CityResponse> {
            override fun onFailure(call: Call<CityResponse>, t: Throwable) {
                Toast.makeText(
                    this@CategoriesActivity,
                    "UnsuccessFull", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<CityResponse>, response: Response<CityResponse>) {
                if (response.isSuccessful) {
                    val mCityResponse = response.body()
                    mCityResponse?.let {
                        if (mCityResponse.location_suggestions != null &&
                            mCityResponse.location_suggestions.size > 0
                        )
                            categories.text = mCityResponse.location_suggestions.get(0).name
                    } ?: run {
                        Toast.makeText(
                            this@CategoriesActivity,
                            "No Values", Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }
        })
    }

    private fun doCategoryApi() {
        val retro: BasePaths = RestClient.getRetroFitObj().create(BasePaths::class.java)

        val catResponse: Call<CategoriesResponse> = retro.getCategoriesRes()

        catResponse.enqueue(object : Callback<CategoriesResponse> {
            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                Toast.makeText(
                    this@CategoriesActivity,
                    "UnsuccessFull", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(
                call: Call<CategoriesResponse>,
                response: Response<CategoriesResponse>
            ) {
                if (response.isSuccessful) {
                    val mCityResponse = response.body()
                    mCityResponse?.let {
                        if (mCityResponse.categories != null &&
                            mCityResponse.categories.size > 0
                        )
                            categories.text = mCityResponse.categories.size.toString()
                    } ?: run {
                        Toast.makeText(
                            this@CategoriesActivity,
                            "No Values", Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }
        })
    }

}
