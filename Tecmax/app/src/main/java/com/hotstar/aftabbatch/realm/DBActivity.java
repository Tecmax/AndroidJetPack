package com.hotstar.aftabbatch.realm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hotstar.aftabbatch.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class DBActivity extends AppCompatActivity {
    EditText name, password;
    Button save, retrive;
    Realm realm;
    private RealmResults<User> userRealmResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        name = findViewById(R.id.usne);
        password = findViewById(R.id.pass);
        save = findViewById(R.id.save);
        retrive = findViewById(R.id.retrieve);

        realm = Realm.getDefaultInstance();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().trim().isEmpty()
                        &&
                        !password.getText().toString().trim().isEmpty()) {
                    saveDeilas(name.getText().toString(), password.getText().toString());
                } else {
                    String message = name.getText().toString().trim().isEmpty() ? "Username" : "Password";
                    Toast.makeText(DBActivity.this, message + " Cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsers();
            }
        });
    }

    private void getUsers() {
        userRealmResults = realm.where(User.class).findAll();
        for (User use : userRealmResults) {
            String messg = use.getName() + " " + use.getPassword();
            Log.e("Mesafe", messg);
        }
        Toast.makeText(this, "Size is " + userRealmResults.size(), Toast.LENGTH_SHORT).show();

    }

    private void saveDeilas(final String name, final String password) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number currentIdNum = realm.where(User.class).max("id");
                long nextId;
                if (currentIdNum == null) {
                    nextId = 1;
                } else {
                    nextId = currentIdNum.longValue() + 1;
                }
                User acv = new User();
                acv.setId(nextId);
                acv.setName(name);
                acv.setPassword(password);
                realm.insertOrUpdate(acv);
            }
        });
    }
}
