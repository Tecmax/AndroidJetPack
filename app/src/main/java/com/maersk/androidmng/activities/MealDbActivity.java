package com.maersk.androidmng.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.maersk.androidmng.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealDbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_db);

        Button sd = findViewById(R.id.getCollections);

        sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callCollec();
            }
        });
    }

    private void callCollec() {
        NetworkCalls sdsad = ClientClas.getRetrObj().create(NetworkCalls.class);
        Call<CollectionResponse> asdas = sdsad.getCollections(4);
        asdas.enqueue(new Callback<CollectionResponse>() {
            @Override
            public void onResponse(Call<CollectionResponse> call, Response<CollectionResponse> response) {
                if (response.isSuccessful()) {
                    CollectionResponse xsd = response.body();
                    int size = 0;
                    if (xsd.getCollections() != null)
                        size = xsd.getCollections().size();

                    Toast.makeText(MealDbActivity.this, "Successfull " + size, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MealDbActivity.this, "UnsuccessFull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CollectionResponse> call, Throwable t) {
                Toast.makeText(MealDbActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
