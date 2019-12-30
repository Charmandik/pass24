package ru.tenant.pass24.ProfileFragments.requests.apiModels.createRequestModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateRequestResponseBody {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("objectId")
    @Expose
    private int objectId;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("requestData")
    @Expose
    private CreateRequestData requestData;

    @SerializedName("refuseReason")
    @Expose
    private String refuseReason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CreateRequestData getRequestData() {
        return requestData;
    }

    public void setRequestData(CreateRequestData requestData) {
        this.requestData = requestData;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }
}
