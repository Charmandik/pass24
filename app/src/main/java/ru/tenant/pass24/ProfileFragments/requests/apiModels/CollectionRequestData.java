package ru.tenant.pass24.ProfileFragments.requests.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CollectionRequestData {
    @SerializedName("objectId")
    @Expose
    private int objectId;

    @SerializedName("address")
    @Expose
    private String address;

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
