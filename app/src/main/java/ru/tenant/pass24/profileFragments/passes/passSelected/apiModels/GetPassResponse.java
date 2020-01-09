package ru.tenant.pass24.profileFragments.passes.passSelected.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.profileFragments.passes.apiModels.PassesCollection;
import ru.tenant.pass24.profileFragments.passes.apiModels.PassesResponseError;

public class GetPassResponse {
    @SerializedName("body")
    @Expose
    private PassesCollection body;

    @SerializedName("error")
    @Expose
    private PassesResponseError error;

    public PassesCollection getBody() {
        return body;
    }

    public void setBody(PassesCollection body) {
        this.body = body;
    }

    public PassesResponseError getError() {
        return error;
    }

    public void setError(PassesResponseError error) {
        this.error = error;
    }
}
