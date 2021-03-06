package ru.tenant.pass24.profileFragments.trustedPeople.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfidanceCollection {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("address")
    @Expose
    private ConfidanceCollectionAddress address;

    @SerializedName("object")
    @Expose
    private ConfidanceCollectionObject object;

    @SerializedName("confidant")
    @Expose
    private Confidant confidant;

    @SerializedName("startsAt")
    @Expose
    private String startsAt;

    @SerializedName("expiresAt")
    @Expose
    private String expiresAt;

    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("closedAt")
    @Expose
    private String closedAt;

    @SerializedName("status")
    @Expose
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ConfidanceCollectionAddress getAddress() {
        return address;
    }

    public void setAddress(ConfidanceCollectionAddress address) {
        this.address = address;
    }

    public ConfidanceCollectionObject getObject() {
        return object;
    }

    public void setObject(ConfidanceCollectionObject object) {
        this.object = object;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
