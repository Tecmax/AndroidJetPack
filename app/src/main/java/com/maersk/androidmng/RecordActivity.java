package com.maersk.androidmng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        RecyclerView df = findViewById(R.id.rec);

        ArrayList<Movie> movieArrayList = new ArrayList<>();

        Movie asfd = new Movie();
        asfd.setName("Kai");
        asfd.setLanguage("Hindi");
        asfd.setImage("https://www.behindwoods.com/tamil-movies/kaithi/images/kaithi-review-banner.jpg");
        asfd.setType("Movie");

        Movie asdsd = new Movie();
        asdsd.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4TgegXih1PX3X62mhw-wEw8z0PnW-bbESW7ogE9ZVyLHT0IUmNA&s");
        asdsd.setType("ADS");

        Movie asd = new Movie();
        asd.setName("War");
        asd.setLanguage("Tamil");
        asd.setImage("https://imgk.timesnownews.com/story/War_Movie_Review.jpg?tr=w-600,h-450");
        asd.setType("Movie");

        Movie sd = new Movie();
        sd.setImage("https://www.techprevue.com/wp-content/uploads/2018/08/mobile-ad-template-optimization.jpg");
        sd.setType("ADS");

        movieArrayList.add(asfd);
        movieArrayList.add(asdsd);
        movieArrayList.add(asfd);
        movieArrayList.add(asd);
        movieArrayList.add(sd);
        movieArrayList.add(asd);
        movieArrayList.add(sd);
        movieArrayList.add(asd);

        RecordAdapter ac = new RecordAdapter(movieArrayList);


//        df.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
//        df.setLayoutManager(new GridLayoutManager(this,3));
        df.setLayoutManager(new StaggeredGridLayoutManager(1, 1));

        df.setAdapter(ac);

        Constraints constraints = new Constraints.Builder()
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .build();

        OneTimeWorkRequest uploadWorkRequest =
                new OneTimeWorkRequest.Builder(UploadPic.class)
                        .setBackoffCriteria(
                                BackoffPolicy.LINEAR,
                                OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                                TimeUnit.MILLISECONDS)
                        .build();
        WorkManager.getInstance(this).enqueue(uploadWorkRequest);

    }
}
