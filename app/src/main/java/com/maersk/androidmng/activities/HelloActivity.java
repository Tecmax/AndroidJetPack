package com.maersk.androidmng.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.maersk.androidmng.R;

public class HelloActivity extends AppCompatActivity {

    AppCompatButton validate;
    AppCompatCheckBox tc;
    AppCompatRadioButton male, female;
    AppCompatSeekBar volume;
    AppCompatSpinner countries;
    SwitchCompat wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        validate = findViewById(R.id.doValidations);
        tc = findViewById(R.id.acceptMe);
        male = findViewById(R.id.rbMale);
        female = findViewById(R.id.rbFemale);
        volume = findViewById(R.id.volume);
        countries = findViewById(R.id.countr);
        wifi = findViewById(R.id.turnOnWifi);


        String[] countriesList = {"India", "WI", "ENG", "SL", "IRE", "AUS"};

        ArrayAdapter<String> lisfad = new ArrayAdapter<>(HelloActivity.this,
                android.R.layout.simple_list_item_1, countriesList);

        countries.setAdapter(lisfad);


        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pszs = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pszs = progress;
                Log.e("onProgressChanged", pszs + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("onStartTrackingTouch", pszs + "");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("onStopTrackingTouch", pszs + "");
            }
        });

        tc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String message = "";
                if (isChecked) {
                    message = "Terms & Conditions Accepted";
                } else {
                    message = "Terms & Conditions Cancelled";
                }
                Toast.makeText(HelloActivity.this,
                        message, Toast.LENGTH_SHORT).show();
            }
        });

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";
//                if (!tc.isChecked()) {
//                    message = "Please Accept T & C";
//                } else if (!male.isChecked() && !female.isChecked()) {
//                    message = "Please Select Gender";
//                } else if (!wifi.isChecked()) {
//                    message = "Please turn On WIFI";
//                }

                startActivity(new Intent(HelloActivity.this, TelskaActivity.class));
                if (!message.isEmpty())
                    Toast.makeText(HelloActivity.this,
                            message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
