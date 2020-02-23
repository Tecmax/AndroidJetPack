package com.maersk.androidmng.activities;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.maersk.androidmng.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TelskaActivity extends AppCompatActivity {
    Button losd;
    ImageView cVie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telska);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        losd = findViewById(R.id.btLodo);
        cVie = findViewById(R.id.Cimage);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        losd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder acsd = new AlertDialog.Builder(TelskaActivity.this);
                acsd.setTitle("Dint Like");
                acsd.setMessage("How is android");
                acsd.setCancelable(false);
                acsd.setPositiveButton("Good", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TelskaActivity.this, "Thanks For Feedback",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                acsd.setNegativeButton("Bad", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TelskaActivity.this, "We will try to Improve",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = acsd.create();
                alertDialog.show();
            }
        });


        String imagePath = "https://i.pinimg.com/originals/51/e3/d2/51e3d2c4051bbc410dd19a756d455110.jpg";

        Picasso.with(this).load(imagePath).error(R.drawable.sha2)
                .placeholder(R.drawable.sha1).into(cVie);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_komesh, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.set) {
            Toast.makeText(this, "Srikanth", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.bet) {
            Toast.makeText(this, "Vignesh", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
