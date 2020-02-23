package com.maersk.androidmng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_proof.*

class ProofActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proof)

        val asd = intent.getSerializableExtra("userObj") as User


        name.text = asd.email
        email.text = asd.username


    }
}
