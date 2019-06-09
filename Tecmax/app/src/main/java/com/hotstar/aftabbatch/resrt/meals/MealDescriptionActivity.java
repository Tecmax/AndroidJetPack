package com.hotstar.aftabbatch.resrt.meals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hotstar.aftabbatch.R;
import com.hotstar.aftabbatch.resrt.BaseClient;
import com.hotstar.aftabbatch.resrt.NetworkAPI;
import com.hotstar.aftabbatch.resrt.model.CategoryDetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealDescriptionActivity extends AppCompatActivity {
    RecyclerView ced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        ced = findViewById(R.id.rv);
        ced.setLayoutManager(new GridLayoutManager(this, 3));
//        ced.setLayoutManager(new LinearLayoutManager(this));
//        ced.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        String name = getIntent().getStringExtra("mealName");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        NetworkAPI service = BaseClient.getRetrofitInstance().create(NetworkAPI.class);
        Call<CategoryDetailResponse> call = service.getCategoriesDetails(name);

        call.enqueue(new Callback<CategoryDetailResponse>() {
            @Override
            public void onResponse(Call<CategoryDetailResponse> call, Response<CategoryDetailResponse> response) {
                if (response.isSuccessful()) {
                    CategoryDetailResponse dd = response.body();
                    MealDetailAdapter sadf = new MealDetailAdapter(dd.getMeals());
                    ced.setAdapter(sadf);
                    Toast.makeText(MealDescriptionActivity.this, "successFull", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MealDescriptionActivity.this, "UnsuccessFull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CategoryDetailResponse> call, Throwable t) {
                Toast.makeText(MealDescriptionActivity.this, "UnsuccessFull", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
