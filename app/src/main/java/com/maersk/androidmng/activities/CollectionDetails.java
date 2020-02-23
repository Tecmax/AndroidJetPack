package com.maersk.androidmng.activities;

import com.google.gson.annotations.SerializedName;

public class CollectionDetails {
    @SerializedName("collection_id")
    private int collection_id;
    @SerializedName("description")
    private String description;
    @SerializedName("image_url")
    private String image_url;
    @SerializedName("res_count")
    private int res_count;
    @SerializedName("share_url")
    private String share_url;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;

    public int getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getRes_count() {
        return res_count;
    }

    public void setRes_count(int res_count) {
        this.res_count = res_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
