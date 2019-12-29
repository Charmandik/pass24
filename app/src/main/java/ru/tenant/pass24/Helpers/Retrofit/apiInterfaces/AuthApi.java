package ru.tenant.pass24.Helpers.Retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.Body;

import retrofit2.http.Header;

import retrofit2.http.POST;
import ru.tenant.pass24.AuthorizationFragments.Login.apiModels.LoginRequestBody;
import ru.tenant.pass24.AuthorizationFragments.Login.apiModels.LoginResponse;
import ru.tenant.pass24.AuthorizationFragments.PasswordRecovery.apiModels.PasswordResetRequest;
import ru.tenant.pass24.AuthorizationFragments.PasswordRecovery.apiModels.PasswordResetResponse;
import ru.tenant.pass24.AuthorizationFragments.Registration.apiModels.RegistryCheckRequestBody;
import ru.tenant.pass24.AuthorizationFragments.Registration.apiModels.RegistryCheckResponse;
import ru.tenant.pass24.AuthorizationFragments.Registration.apiModels.RegistryResponse;
import ru.tenant.pass24.AuthorizationFragments.RegistryConfirm.apiModels.ConfirmPhoneRequest;
import ru.tenant.pass24.AuthorizationFragments.RegistryConfirm.apiModels.ConfirmPhoneResponse;

import ru.tenant.pass24.AuthorizationFragments.RegistryConfirm.apiModels.SendConfirmPhoneRequest;

import ru.tenant.pass24.AuthorizationFragments.RegistryConfirm.apiModels.SendConfirmPhoneResponse;

public interface AuthApi {
    @POST("auth/login/")
    Observable<LoginResponse> login(@Body LoginRequestBody loginRequestBody);

    @POST("auth/register/")
    Observable<RegistryResponse> registrate(@Header("Authorization") String token,
                                            @Body RegistryCheckRequestBody registryCheckRequestBody);

    @POST("auth/register/check")
    Observable<RegistryCheckResponse> checkRegistrationData(@Body RegistryCheckRequestBody registryCheckRequestBody);

    @POST("auth/passwordReset")
    Observable<PasswordResetResponse> resetPassword(@Body PasswordResetRequest passwordResetRequest);

    @POST("auth/sendConfirmPhone/")

    Observable<SendConfirmPhoneResponse> sendConfirmPhone(@Body SendConfirmPhoneRequest sendConfirmPhoneRequest);

    @POST("auth/confirmPhone/")
    Observable<ConfirmPhoneResponse> confirmPhone(@Body ConfirmPhoneRequest confirmPhoneRequest);

//    @POST("auth/refresh/")
//    Observable<RefreshTokenResponse> refreshToken(@Body RefreshtokenRequest refreshtokenRequest);
//
//    @POST("auth/logout/")
//    Observable<LogoutResponse> logout(@Body LogoutResponse logoutResponse);
}

