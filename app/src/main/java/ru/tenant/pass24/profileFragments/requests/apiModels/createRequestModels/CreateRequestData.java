package ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.profileFragments.trustedPeople.apiModels.Confidant;

public class CreateRequestData {

    @SerializedName("objectId")
    @Expose
    private int objectId;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("startsAt")
    @Expose
    private String startsAt;

    @SerializedName("expiresAt")
    @Expose
    private String expiresAt;

    @SerializedName("confidant")
    @Expose
    private Confidant confidant;

    public CreateRequestData(int objectId, String address) {
        this.objectId = objectId;
        this.address = address;
    }

    public CreateRequestData() {
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

    public Confidant getConfidant() {
        return confidant;
    }

    public void setConfidant(Confidant confidant) {
        this.confidant = confidant;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }
}
