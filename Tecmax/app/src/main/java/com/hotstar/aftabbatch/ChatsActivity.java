package com.hotstar.aftabbatch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ChatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ViewPager vpc = findViewById(R.id.vp);
        TabLayout sss = findViewById(R.id.chatTabs);

        sss.setupWithViewPager(vpc);

        VpAdapter sdsd = new VpAdapter(getSupportFragmentManager());
        sdsd.addDetails(new BlankFragment(), "Chats");
        sdsd.addDetails(new SignupFragment(), "Status");
        sdsd.addDetails(new BlankFragment(), "Calls");

        vpc.setAdapter(sdsd);

    }


    class VpAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> fragList;
        ArrayList<String> fragTitle;

        public VpAdapter(FragmentManager fm) {
            super(fm);
            fragList = new ArrayList<>();
            fragTitle = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int i) {
            return fragList.get(i);
        }

        @Override
        public int getCount() {
            return fragList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragTitle.get(position);
        }

        void addDetails(Fragment fg, String tabTitle) {
            fragList.add(fg);
            fragTitle.add(tabTitle);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof BlankFragment)
                    fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }
}
