package ru.tenant.pass24.profileFragments.requests.newConfidance.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class NewConfidanceErrorDetails {
    @SerializedName("addressId")
    @Expose
    private List<String> addressId;

    @SerializedName("startsAt")
    @Expose
    private List<String> startsAt;

    @SerializedName("expiresAt")
    @Expose
    private List<String> expiresAt;

    @SerializedName("confidant")
    @Expose
    private List<String> confidant;

    @SerializedName("confidant.phone")
    @Expose
    private List<String> confidant_phone;

    @SerializedName("confidant.firstName")
    @Expose
    private List<String> confidant_firstName;

    @SerializedName("confidant.lastName")
    @Expose
    private List<String> confidant_lastName;

    public List<String> getAddressId() {
        return addressId;
    }

    public void setAddressId(List<String> addressId) {
        this.addressId = addressId;
    }

    public List<String> getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(List<String> startsAt) {
        this.startsAt = startsAt;
    }

    public List<String> getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(List<String> expiresAt) {
        this.expiresAt = expiresAt;
    }

    public List<String> getConfidant() {
        return confidant;
    }

    public void setConfidant(List<String> confidant) {
        this.confidant = confidant;
    }

    public List<String> getConfidant_phone() {
        return confidant_phone;
    }

    public void setConfidant_phone(List<String> confidant_phone) {
        this.confidant_phone = confidant_phone;
    }

    public List<String> getConfidant_firstName() {
        return confidant_firstName;
    }

    public void setConfidant_firstName(List<String> confidant_firstName) {
        this.confidant_firstName = confidant_firstName;
    }

    public List<String> getConfidant_lastName() {
        return confidant_lastName;
    }

    public void setConfidant_lastName(List<String> confidant_lastName) {
        this.confidant_lastName = confidant_lastName;
    }
}
