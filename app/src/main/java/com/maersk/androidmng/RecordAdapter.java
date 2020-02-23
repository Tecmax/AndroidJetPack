package com.maersk.androidmng;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Movie> movieArrayList;
    private static int TYPE_MOVIE = 1;
    private static int TYPE_ADS = 2;


    public RecordAdapter(ArrayList<Movie> movies) {
        movieArrayList = movies;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if (viewType == TYPE_MOVIE) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_item, parent, false);
            return new MovieHolder(v);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ads, parent, false);
            return new AdsHolder(v);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (movieArrayList.get(position).getType().equals("Movie")) {
            return TYPE_MOVIE;
        } else {
            return TYPE_ADS;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MovieHolder) {
            MovieHolder fs = (MovieHolder) holder;
            fs.language.setText(movieArrayList.get(position).getLanguage());
            fs.name.setText(movieArrayList.get(position).getName());
            Picasso.with(fs.movieImage.getContext())
                    .load(movieArrayList.get(position).getImage())
                    .into(fs.movieImage);
            fs.language.startAnimation(fs.anim);
        } else if (holder instanceof AdsHolder) {
            AdsHolder fss = (AdsHolder) holder;

            Picasso.with(fss.adsImage.getContext())
                    .load(movieArrayList.get(position).getImage())
                    .into(fss.adsImage);
        }
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        TextView name;
        TextView language;
        Button book;
        Animation anim;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.movieImage);
            name = itemView.findViewById(R.id.movieName);
            language = itemView.findViewById(R.id.movieLanguage);
            book = itemView.findViewById(R.id.bookMovie);
            anim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.anim_resa);
            movieImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(movieImage.getContext(), movieArrayList.get(getAdapterPosition()).getName() +
                            " Image was cikced", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    class AdsHolder extends RecyclerView.ViewHolder {
        ImageView adsImage;

        public AdsHolder(@NonNull View itemView) {
            super(itemView);
            adsImage = itemView.findViewById(R.id.adsImage);
        }
    }
}
