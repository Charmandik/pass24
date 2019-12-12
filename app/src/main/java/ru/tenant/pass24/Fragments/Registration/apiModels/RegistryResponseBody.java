package ru.tenant.pass24.Fragments.Registration.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistryResponseBody {
    @SerializedName("id")
    @Expose
    private boolean id;
    @SerializedName("name")
    @Expose
    private boolean name;
    @SerializedName("firstName")
    @Expose
    private boolean firstName;
    @SerializedName("lastName")
    @Expose
    private boolean lastName;
    @SerializedName("middleName")
    @Expose
    private boolean middleName;
    @SerializedName("phone")
    @Expose
    private boolean phone;
    @SerializedName("email")
    @Expose
    private boolean email;

    public boolean isId() {
        return id;
    }

    public void setId(boolean id) {
        this.id = id;
    }

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }

    public boolean isFirstName() {
        return firstName;
    }

    public void setFirstName(boolean firstName) {
        this.firstName = firstName;
    }

    public boolean isLastName() {
        return lastName;
    }

    public void setLastName(boolean lastName) {
        this.lastName = lastName;
    }

    public boolean isMiddleName() {
        return middleName;
    }

    public void setMiddleName(boolean middleName) {
        this.middleName = middleName;
    }

    public boolean isPhone() {
        return phone;
    }

    public void setPhone(boolean phone) {
        this.phone = phone;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }
}
