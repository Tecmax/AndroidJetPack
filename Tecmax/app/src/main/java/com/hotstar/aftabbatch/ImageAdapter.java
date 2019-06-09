package com.hotstar.aftabbatch;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends PagerAdapter {
    Context context;
    BannerDetail[] GalImages;

    LayoutInflater mLayoutInflater;

    ImageAdapter(Context context, BannerDetail[] images) {
        this.context = context;
        GalImages = images;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return GalImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        TextView header1 = itemView.findViewById(R.id.head1);
        TextView header2 = itemView.findViewById(R.id.head12);
        Picasso.with(itemView.getContext())
                .load(GalImages[position].getOnlineBanner())
                .placeholder(GalImages[position].getDrawable())
                .error(GalImages[position].getDrawable())
                .into(imageView);
        header1.setText(GalImages[position].getHeadline1());
        header2.setText(GalImages[position].getHeadline2());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
