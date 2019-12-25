package ru.tenant.pass24.ProfileFragments.feed.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

class FeedCollection {
    @SerializedName("happenedAt")
    @Expose
    private String happenedAt;

    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("data")
    @Expose
    private FeedCollectionData data;

    public String getHappenedAt() {
        return happenedAt;
    }

    public void setHappenedAt(String happenedAt) {
        this.happenedAt = happenedAt;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public FeedCollectionData getData() {
        return data;
    }

    public void setData(FeedCollectionData data) {
        this.data = data;
    }
}
