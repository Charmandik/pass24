package ru.tenant.pass24.profileFragments.feed.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class FeedCollectionEventData {

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
