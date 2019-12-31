package ru.tenant.pass24.profileFragments.passes.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreatePassRequestBody {
    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("requestData")
    @Expose
    private CreatePassRequest requestData;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public CreatePassRequest getRequestData() {
        return requestData;
    }

    public void setRequestData(CreatePassRequest requestData) {
        this.requestData = requestData;
    }
}
