package ru.tenant.pass24.profileFragments.requests.newConfidance.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewConfidanceRequest {
    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("requestData")
    @Expose
    private NewConfidanceRequestData requestData;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public NewConfidanceRequestData getRequestData() {
        return requestData;
    }

    public void setRequestData(NewConfidanceRequestData requestData) {
        this.requestData = requestData;
    }
}
