package ru.tenant.pass24.ProfileFragments.requests.apiModels.createRequestModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateRequestData {

    @SerializedName("objectId")
    @Expose
    private int objectId;
    @SerializedName("address")
    @Expose
    private String address;

    public CreateRequestData(int objectId, String address) {
        this.objectId = objectId;
        this.address = address;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
