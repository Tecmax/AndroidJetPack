package com.hotstar.aftabbatch;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView addA, addB, remA, remB, repA, repB, showA, hideA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.a).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.d).setOnClickListener(this);
        findViewById(R.id.rA).setOnClickListener(this);
        findViewById(R.id.rB).setOnClickListener(this);
        findViewById(R.id.rC).setOnClickListener(this);
        findViewById(R.id.rD).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        FragmentManager avs = getSupportFragmentManager();
        switch (v.getId()) {
            case R.id.a:
//                FragmentTransaction asd = avs.beginTransaction();
//                asd.add(R.id.frame, new BlankFragment(), "a");
//                asd.commit();
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
                break;
            case R.id.b:
                FragmentTransaction sd = avs.beginTransaction();
                sd.add(R.id.frame, new SignupFragment(), "b");
                sd.commit();
                break;
            case R.id.c:
                Fragment sdds = avs.findFragmentByTag("a");
                FragmentTransaction eafds = avs.beginTransaction();
                eafds.remove(sdds);
                eafds.commit();

                break;
            case R.id.d:
                Fragment der = avs.findFragmentByTag("b");
                FragmentTransaction ef = avs.beginTransaction();
                ef.remove(der);
                ef.commit();
                break;
            case R.id.rA:
                FragmentTransaction sds = avs.beginTransaction();
                sds.replace(R.id.frame, new BlankFragment(), "a");
                sds.commit();
                break;
            case R.id.rB:
                FragmentTransaction saf = avs.beginTransaction();
                saf.replace(R.id.frame, new SignupFragment(), "b");
                saf.commit();
                break;
            case R.id.rC:
                Fragment jh = avs.findFragmentByTag("b");
                FragmentTransaction ffd = avs.beginTransaction();
                ffd.show(jh);
                ffd.commit();
                break;
            case R.id.rD:
                Fragment fdsg = avs.findFragmentByTag("b");
                if (fdsg != null) {
                    FragmentTransaction wasd = avs.beginTransaction();
                    wasd.hide(fdsg);
                    wasd.commit();
                } else {
                    Toast.makeText(this, "No Instance Found", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}
