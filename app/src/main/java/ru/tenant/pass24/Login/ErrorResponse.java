package ru.tenant.pass24.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorResponse {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
}
