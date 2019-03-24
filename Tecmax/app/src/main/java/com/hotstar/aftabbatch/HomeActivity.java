package com.hotstar.aftabbatch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    AppCompatEditText etName;
    AppCompatButton btClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SeekBar acc = findViewById(R.id.seekTime);
        etName = findViewById(R.id.etName);
        btClick = findViewById(R.id.ck);

        acc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progresl;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresl = progress;
                Log.e("pro", progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(HomeActivity.this, "StRTED EDITING", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(HomeActivity.this, "statues is " + progresl, Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        AppCompatSpinner dsd = findViewById(R.id.spinn);

        String[] cont = {"India", "Pakistan", "England", "Germany"};

        ArrayAdapter<String> ads = new ArrayAdapter<String>(HomeActivity.this,
                android.R.layout.simple_spinner_item
                , cont);

        dsd.setAdapter(ads);


        dsd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){

                }
                Toast.makeText(HomeActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String asd = etName.getText().toString();
                Toast.makeText(HomeActivity.this, asd, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
