package com.maersk.jyotsanaapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_widgest_sample.*
import kotlinx.android.synthetic.main.content_widgest_sample.*

class WidgestSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widgest_sample)
        setSupportActionBar(customTol)

        val circSchedules =
            arrayListOf<String>(
                "Jan 14, TueIndia vs Australia, 1st ODI 1:30 PM",
                "Jan 17, FriIndia vs Australia, 2nd ODI 3:30 PM",
                "Jan 19, TueIndia vs Australia, 3st ODI 7:30 PM"
            )

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        calend.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                DatePickerDialog(
                    this@WidgestSampleActivity,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        selectedTv.text = "$dayOfMonth/${month + 1}/$year"
                    },
                    1993,
                    3,
                    4
                ).show()
            }

        }

        timePi.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                TimePickerDialog(
                    this@WidgestSampleActivity,
                    TimePickerDialog.OnTimeSetListener { view, hour, min ->
                        selectedTv.text = "${hour}:$min"
                    },
                    3,
                    3,
                    true
                ).show()
            }
        }

        val adapter = ArrayAdapter<String>(
            this@WidgestSampleActivity,
            android.R.layout.simple_list_item_1,
            circSchedules
        )
        selectMatch.adapter = adapter



        selectBudget.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.e("seekbar", "progress track ${progress}")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.e("seekbar", "Start track ${seekBar?.progress}")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.e("seekbar", "Stop track ${seekBar?.progress}")
            }
        })

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

        selectedTv.setOnClickListener(object : View.OnClickListener {

            internal var isPlaying = false

            override fun onClick(v: View) {
                if (!isPlaying) {
                    temp.start()
                    isPlaying = true
                } else {
                    temp.stop()
                    isPlaying = false
                }

                selectedTv.text = if (isPlaying) "start" else "stop"
                Toast.makeText(this@WidgestSampleActivity, getString(if (isPlaying) R.string.playing else R.string.stopped), Toast.LENGTH_SHORT).show()
            }
        })

    }

}
