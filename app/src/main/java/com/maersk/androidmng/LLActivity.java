package com.maersk.androidmng;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LLActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_ll);
//        mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-entirecloud.firebaseio.com/users/users");
        mDatabase = FirebaseDatabase.getInstance().getReference("Riders");
        final EditText fName = findViewById(R.id.firstNameET);
        final EditText LName = findViewById(R.id.lastNameEt);
        Button cond = findViewById(R.id.continueBT);
        TextView wat = findViewById(R.id.authoruzedTV);

        cond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = mDatabase.push().getKey();
                writeNewUser(id, fName.getText().toString(), LName.getText().toString());
//                Intent safd = new Intent(LLActivity.this, SamsungActivity.class);
//                startActivity(safd);
            }
        });

        wat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                            Log.e("userDetailsjkhgf", "" + dataSnapshot2.getValue());
                            if (dataSnapshot2.getValue() instanceof User) {
                                User user = dataSnapshot2.getValue(User.class);
                                Log.e("userDetails", user.getUsername() + "    " + user.getEmail());
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }


    private void writeNewUser(String userId, String name, String email) {
        User user = new User(name, email);
        mDatabase.child(userId).setValue(user);
    }
}
