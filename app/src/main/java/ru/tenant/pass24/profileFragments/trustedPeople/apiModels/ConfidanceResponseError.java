package ru.tenant.pass24.profileFragments.trustedPeople.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfidanceResponseError {
    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("message")
    @Expose
    private String message;

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
}
