package ru.tenant.pass24.profileFragments.requests.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.profileFragments.trustedPeople.apiModels.Confidant;

public class CollectionRequestData {
    @SerializedName("objectId")
    @Expose
    private int objectId;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("tenant")
    @Expose
    private Tenant tenant;

    @SerializedName("guestData")
    @Expose
    private RequestGuestData guestData;

    @SerializedName("confidant")
    @Expose
    private Confidant confidant;

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

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public RequestGuestData getGuestData() {
        return guestData;
    }

    public void setGuestData(RequestGuestData guestData) {
        this.guestData = guestData;
    }

    public Confidant getConfidant() {
        return confidant;
    }

    public void setConfidant(Confidant confidant) {
        this.confidant = confidant;
    }
}
