package com.maersk.jyotsanaapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cd.setOnClickListener { v ->
            val url = "http://www.tecmax.in"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }


//        dwe.webViewClient = MyBrowser()


        asa.setOnClickListener {
            //            dwe.settings.loadsImagesAutomatically = true
//            dwe.settings.javaScriptEnabled = true
//            dwe.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
//            dwe.loadUrl("https://www.tecmax.com/")

            val sdj = Intent(this@MainActivity, WidgestSampleActivity::class.java)
            startActivity(sdj)
        }



        SMSReceiver.listenMessage(ReceiveMSG { message ->
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
        })
    }


    private class MyBrowser : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView,
            url: String
        ): Boolean {
            view.loadUrl(url)
            return true
        }
    }
}
