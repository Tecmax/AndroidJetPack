package com.maersk.androidmng.activities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CollectionResponse {
    @SerializedName("display_text")
    private String brandName;
    @SerializedName("has_more")
    private int has_more;
    @SerializedName("has_total")
    private int has_total;
    @SerializedName("share_url")
    private String share_url;

    @SerializedName("collections")
    private ArrayList<Collection> collections;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getHas_more() {
        return has_more;
    }

    public void setHas_more(int has_more) {
        this.has_more = has_more;
    }

    public int getHas_total() {
        return has_total;
    }

    public void setHas_total(int has_total) {
        this.has_total = has_total;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public ArrayList<Collection> getCollections() {
        return collections;
    }

    public void setCollections(ArrayList<Collection> collections) {
        this.collections = collections;
    }
}
