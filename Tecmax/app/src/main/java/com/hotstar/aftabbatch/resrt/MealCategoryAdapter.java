package com.hotstar.aftabbatch.resrt;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotstar.aftabbatch.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MealCategoryAdapter extends RecyclerView.Adapter {
    List<Category> mCategoryList;

    public MealCategoryAdapter(List<Category> categoryList) {
        mCategoryList = categoryList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View cv = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_category,viewGroup,false);
        return new CatVh(cv);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        CatVh sdf = (CatVh) viewHolder;
        Category ca = mCategoryList.get(i);
        Picasso.with(sdf.catIm.getContext())
                .load(ca.getStrCategoryThumb())
                .placeholder(R.drawable.bangalore)
                .error(R.drawable.bangalore)
                .into(sdf.catIm);
        sdf.catName.setText(ca.getStrCategory());
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    class CatVh extends RecyclerView.ViewHolder {
        AppCompatImageView catIm;
        TextView catName;

        public CatVh(@NonNull View itemView) {
            super(itemView);
            catIm = itemView.findViewById(R.id.catImage);
            catName = itemView.findViewById(R.id.catTitle);
        }
    }
}
