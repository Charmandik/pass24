package ru.tenant.pass24.profileFragments.addressSearch.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileAddressesResponseBody {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("object")
    @Expose
    private ProfileAddressObject object;

    @SerializedName("isBlocked")
    @Expose
    private boolean isBlocked;

    @SerializedName("confidanceId")
    @Expose
    private int confidanceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public int getConfidanceId() {
        return confidanceId;
    }

    public void setConfidanceId(int confidanceId) {
        this.confidanceId = confidanceId;
    }

    public ProfileAddressObject getObject() {
        return object;
    }

    public void setObject(ProfileAddressObject object) {
        this.object = object;
    }
}
