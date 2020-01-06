package ru.tenant.pass24.profileFragments.feed.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class FeedResponseError {
    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("message")
    @Expose
    private String message;
}
