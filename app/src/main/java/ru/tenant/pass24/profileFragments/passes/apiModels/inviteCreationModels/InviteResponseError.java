package ru.tenant.pass24.profileFragments.passes.apiModels.inviteCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InviteResponseError {

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("details")
    @Expose
    private InviteErrorDetails details;

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

    public InviteErrorDetails getDetails() {
        return details;
    }

    public void setDetails(InviteErrorDetails details) {
        this.details = details;
    }
}
