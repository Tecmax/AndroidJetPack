package com.hotstar.aftabbatch.resrt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hotstar.aftabbatch.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealActivity extends AppCompatActivity {
    RecyclerView ced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        ced = findViewById(R.id.rv);
//        ced.setLayoutManager(new GridLayoutManager(this, 3));
//        ced.setLayoutManager(new LinearLayoutManager(this));
        ced.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        NetworkAPI service = BaseClient.getRetrofitInstance().create(NetworkAPI.class);
        Call<CatergoryResponse> call = service.getAllCategories();

        call.enqueue(new Callback<CatergoryResponse>() {
            @Override
            public void onResponse(Call<CatergoryResponse> call, Response<CatergoryResponse> response) {
                if (response.isSuccessful()) {
                    CatergoryResponse dd = response.body();
                    MealCategoryAdapter sadf = new MealCategoryAdapter(dd.getCategories());
                    ced.setAdapter(sadf);
                    Toast.makeText(MealActivity.this, "successFull", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MealActivity.this, "UnsuccessFull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CatergoryResponse> call, Throwable t) {
                Toast.makeText(MealActivity.this, "UnsuccessFull", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
