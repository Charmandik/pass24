package ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateRequestResponse {

    @SerializedName("body")
    @Expose
    private CreateRequestResponseBody body;

    @SerializedName("error")
    @Expose
    private CreateRequestResponseError error;

    public CreateRequestResponseBody getBody() {
        return body;
    }

    public void setBody(CreateRequestResponseBody body) {
        this.body = body;
    }

    public CreateRequestResponseError getError() {
        return error;
    }

    public void setError(CreateRequestResponseError error) {
        this.error = error;
    }
}
