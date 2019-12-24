package ru.tenant.pass24.AuthorizationFragments.Registration.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorRegistryCheckResponse {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("details")
    @Expose
    private ErrorDetailsResponse details;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorDetailsResponse getDetails() {
        return details;
    }

    public void setDetails(ErrorDetailsResponse details) {
        this.details = details;
    }
}
