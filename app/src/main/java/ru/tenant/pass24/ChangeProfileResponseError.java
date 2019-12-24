package ru.tenant.pass24;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ChangeProfileResponseError {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("code")
    @Expose
    private ChangeProfileResponseErrorDetails details;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ChangeProfileResponseErrorDetails getDetails() {
        return details;
    }

    public void setDetails(ChangeProfileResponseErrorDetails details) {
        this.details = details;
    }
}
