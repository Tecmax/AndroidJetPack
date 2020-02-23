package com.maersk.androidmng.activities;

import com.google.gson.annotations.SerializedName;

public class Collection {
    @SerializedName("collection")
    private CollectionDetails collectionDetails;

    public CollectionDetails getCollectionDetails() {
        return collectionDetails;
    }

    public void setCollectionDetails(CollectionDetails collectionDetails) {
        this.collectionDetails = collectionDetails;
    }
}
