package ru.tenant.pass24.profileFragments.passes.apiModels.inviteCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateInviteResponse {
    @SerializedName("body")
    @Expose
    private InviteResponseBody body;

    @SerializedName("error")
    @Expose
    private InviteResponseError error;

    public InviteResponseBody getBody() {
        return body;
    }

    public void setBody(InviteResponseBody body) {
        this.body = body;
    }

    public InviteResponseError getError() {
        return error;
    }

    public void setError(InviteResponseError error) {
        this.error = error;
    }
}
