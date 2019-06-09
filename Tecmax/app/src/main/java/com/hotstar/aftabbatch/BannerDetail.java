package com.hotstar.aftabbatch;

public class BannerDetail {

    private int drawable;
    private String onlineBanner;
    private String headline1;
    private String headline2;

    public BannerDetail(int drawable, String headline1, String headline2,String onlineBanner) {
        this.drawable = drawable;
        this.headline1 = headline1;
        this.headline2 = headline2;
        this.onlineBanner = onlineBanner;
    }

    BannerDetail() {

    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getHeadline1() {
        return headline1;
    }

    public void setHeadline1(String headline1) {
        this.headline1 = headline1;
    }

    public String getHeadline2() {
        return headline2;
    }

    public void setHeadline2(String headline2) {
        this.headline2 = headline2;
    }

    public String getOnlineBanner() {
        return onlineBanner;
    }

    public void setOnlineBanner(String onlineBanner) {
        this.onlineBanner = onlineBanner;
    }
}
