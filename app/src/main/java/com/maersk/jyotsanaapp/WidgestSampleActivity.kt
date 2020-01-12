package com.maersk.jyotsanaapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_widgest_sample.*
import kotlinx.android.synthetic.main.content_widgest_sample.*

class WidgestSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widgest_sample)
        setSupportActionBar(customTol)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        alertdil.setOnClickListener {
            val asd = AlertDialog.Builder(this@WidgestSampleActivity)
            asd.setMessage("Hello Rahul")
            asd.setTitle("Android welcomes you")
            asd.setPositiveButton("Thanks") { dialog, which ->
                Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
            }
            asd.setNegativeButton("Rate Later") { sad, sadd ->
                Toast.makeText(applicationContext, "Rate LAter", Toast.LENGTH_LONG).show()
            }

            val asdd = asd.create()
            asdd.show()

        }
    }

}