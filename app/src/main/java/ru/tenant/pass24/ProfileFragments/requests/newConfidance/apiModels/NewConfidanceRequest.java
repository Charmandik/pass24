package ru.tenant.pass24.ProfileFragments.requests.newConfidance.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewConfidanceRequest {
    @SerializedName("addressId")
    @Expose
    private int addressId;

    @SerializedName("confidant")
    @Expose
    private RequestConfidant confidant;

    @SerializedName("startsAt")
    @Expose
    private String startsAt;

    @SerializedName("expiresAt")
    @Expose
    private String expiresAt;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public RequestConfidant getConfidant() {
        return confidant;
    }

    public void setConfidant(RequestConfidant confidant) {
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
