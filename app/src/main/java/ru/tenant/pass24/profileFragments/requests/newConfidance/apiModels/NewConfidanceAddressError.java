package ru.tenant.pass24.profileFragments.requests.newConfidance.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class NewConfidanceAddressError {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("details")
    @Expose
    private NewConfidanceErrorDetails details;
}
