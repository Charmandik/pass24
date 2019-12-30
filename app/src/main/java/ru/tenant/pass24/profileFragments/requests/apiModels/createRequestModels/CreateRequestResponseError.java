package ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.profileFragments.requests.newConfidance.apiModels.NewConfidanceErrorDetails;

class CreateRequestResponseError {

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("details")
    @Expose
    private NewConfidanceErrorDetails details;

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

    public NewConfidanceErrorDetails getDetails() {
        return details;
    }

    public void setDetails(NewConfidanceErrorDetails details) {
        this.details = details;
    }
}
