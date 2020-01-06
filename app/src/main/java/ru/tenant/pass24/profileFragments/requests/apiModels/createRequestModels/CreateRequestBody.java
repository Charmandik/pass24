package ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateRequestBody {
    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("requestData")
    @Expose
    private CreateRequestData requestData;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public CreateRequestData getRequestData() {
        return requestData;
    }

    public void setRequestData(CreateRequestData requestData) {
        this.requestData = requestData;
    }
}
