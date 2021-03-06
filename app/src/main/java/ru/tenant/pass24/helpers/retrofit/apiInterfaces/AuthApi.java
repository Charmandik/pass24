package ru.tenant.pass24.helpers.retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.tenant.pass24.authorizationFragments.login.apiModels.LoginRequestBody;
import ru.tenant.pass24.authorizationFragments.login.apiModels.LoginResponse;
import ru.tenant.pass24.authorizationFragments.passwordRecovery.apiModels.PasswordResetRequest;
import ru.tenant.pass24.authorizationFragments.passwordRecovery.apiModels.PasswordResetResponse;
import ru.tenant.pass24.authorizationFragments.registration.apiModels.RegistryCheckRequestBody;
import ru.tenant.pass24.authorizationFragments.registration.apiModels.RegistryCheckResponse;
import ru.tenant.pass24.authorizationFragments.registration.apiModels.RegistryResponse;
import ru.tenant.pass24.authorizationFragments.registryConfirm.apiModels.ConfirmPhoneRequest;
import ru.tenant.pass24.authorizationFragments.registryConfirm.apiModels.ConfirmPhoneResponse;
import ru.tenant.pass24.authorizationFragments.registryConfirm.apiModels.SendConfirmPhoneRequest;
import ru.tenant.pass24.authorizationFragments.registryConfirm.apiModels.SendConfirmPhoneResponse;

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

    @POST("auth/refresh/")
    Observable<LoginResponse> refreshToken(@Header("Authorization") String token);
//
//    @POST("auth/logout/")
//    Observable<LogoutResponse> logout(@Body LogoutResponse logoutResponse);
}

