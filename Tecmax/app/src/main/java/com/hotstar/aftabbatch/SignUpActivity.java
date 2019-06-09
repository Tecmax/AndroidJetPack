package com.hotstar.aftabbatch;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SignUpActivity extends AppCompatActivity {

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;
    int[] GalImages;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        GalImages = new int[]{
                R.drawable.bangalore,
                R.drawable.bangalore,
                R.drawable.bangalore
        };
        viewPager = findViewById(R.id.banner);
        BannerDetail ad = new BannerDetail(GalImages[0], "buy 1 Get 1 Free", "Exclusive For T Shirts", "https://smedia2.intoday.in/btmt/images/stories/bharat_660x450_042219042510.jpg");


        BannerDetail ad1 = new BannerDetail();
        ad1.setDrawable(GalImages[1]);
        ad1.setHeadline1("buy 2 Get 2 Free");
        ad1.setHeadline2("Exclusive For Dothi");
        ad1.setOnlineBanner("https://images.in.com/uploads/2019/04/tara4.jpg");

        BannerDetail ad3 = new BannerDetail(GalImages[2], "Flat 69% Off", "Exclusive For Jeans", "https://s01.sgp1.cdn.digitaloceanspaces.com/article/115327-vkjgezdcuh-1552657284.jpeg");


        BannerDetail[] bannerDetails = {ad, ad1, ad3};

        ImageAdapter adapter = new ImageAdapter(this, bannerDetails);
        viewPager.setAdapter(adapter);
//        viewPager.setCurrentItem(adapter.getCount() - 16);



        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == GalImages.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);


    }
}
