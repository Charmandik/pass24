package ru.tenant.pass24.Fragments.Registration.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ErrorDetailsResponse {
    @SerializedName("firstName")
    @Expose
    private List<String> firstName;

    @SerializedName("lastName")
    @Expose
    private List<String> lastName;

    @SerializedName("phone")
    @Expose
    private List<String> phone;

    @SerializedName("email")
    @Expose
    private List<String> email;

    @SerializedName("password")
    @Expose
    private List<String> password;


    public List<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(List<String> firstName) {
        this.firstName = firstName;
    }

    public List<String> getLastName() {
        return lastName;
    }

    public void setLastName(List<String> lastName) {
        this.lastName = lastName;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getPassword() {
        return password;
    }

    public void setPassword(List<String> password) {
        this.password = password;
    }
}
