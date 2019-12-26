package ru.tenant.pass24.ProfileFragments.feed.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeedCollectionData {
    @SerializedName("passId")
    @Expose
    private int passId;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("prevStatus")
    @Expose
    private int prevStatus;

    @SerializedName("fromConfidant")
    @Expose
    private boolean fromConfidant;

    @SerializedName("happenedAt")
    @Expose
    private String happenedAt;

    public int getPassId() {
        return passId;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrevStatus() {
        return prevStatus;
    }

    public void setPrevStatus(int prevStatus) {
        this.prevStatus = prevStatus;
    }

    public boolean isFromConfidant() {
        return fromConfidant;
    }

    public void setFromConfidant(boolean fromConfidant) {
        this.fromConfidant = fromConfidant;
    }

    public String getHappenedAt() {
        return happenedAt;
    }

    public void setHappenedAt(String happenedAt) {
        this.happenedAt = happenedAt;
    }

}
