package com.hotstar.aftabbatch.resrt.meals;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hotstar.aftabbatch.R;
import com.hotstar.aftabbatch.resrt.model.MealDetails;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MealDetailAdapter extends RecyclerView.Adapter {
    List<MealDetails> mCategoryList;

    public MealDetailAdapter(List<MealDetails> categoryList) {
        mCategoryList = categoryList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View cv = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_category, viewGroup, false);
        return new CatVh(cv);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        CatVh sdf = (CatVh) viewHolder;
        MealDetails ca = mCategoryList.get(i);
        Picasso.with(sdf.catIm.getContext())
                .load(ca.getStrMealThumb())
                .placeholder(R.drawable.bangalore)
                .error(R.drawable.bangalore)
                .into(sdf.catIm);
        sdf.catName.setText(ca.getStrMeal());
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    class CatVh extends RecyclerView.ViewHolder {
        AppCompatImageView catIm;
        TextView catName;

        public CatVh(@NonNull final View itemView) {
            super(itemView);
            catIm = itemView.findViewById(R.id.catImage);
            catName = itemView.findViewById(R.id.catTitle);

            catIm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MealDetails sd = mCategoryList.get(getAdapterPosition());
                    String catName = sd.getIdMeal();
                    Toast.makeText(itemView.getContext(), catName, Toast.LENGTH_SHORT).show();
//                    Intent sdf = new Intent(itemView.getContext(), MealDescriptionActivity.class);
//                    sdf.putExtra("mealName", catName);
//                    itemView.getContext().startActivity(sdf);
                }
            });
        }


    }
}
