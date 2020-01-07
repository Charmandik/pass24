package ru.tenant.pass24.profileFragments.requests.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.profileFragments.trustedPeople.apiModels.Confidant;

public class CollectionRequestData {
    @SerializedName("comment")
    @Expose
    private String comment;

    @SerializedName("startsAt")
    @Expose
    private String startsAt;

    @SerializedName("expiresAt")
    @Expose
    private String expiresAt;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("tenantId")
    @Expose
    private int tenantId;

    @SerializedName("objectId")
    @Expose
    private int objectId;

    @SerializedName("addressId")
    @Expose
    private int addressId;

    @SerializedName("guestType")
    @Expose
    private int guestType;

    @SerializedName("durationType")
    @Expose
    private int durationType;

    @SerializedName("tenant")
    @Expose
    private Tenant tenant;

    @SerializedName("guestData")
    @Expose
    private RequestGuestData guestData;

    @SerializedName("confidant")
    @Expose
    private Confidant confidant;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getGuestType() {
        return guestType;
    }

    public void setGuestType(int guestType) {
        this.guestType = guestType;
    }

    public int getDurationType() {
        return durationType;
    }

    public void setDurationType(int durationType) {
        this.durationType = durationType;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
