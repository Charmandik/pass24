package ru.tenant.pass24.Helpers.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.tenant.pass24.Fragments.Login.apiModels.LoginRequestBody;
import ru.tenant.pass24.Fragments.Login.apiModels.LoginResponse;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryCheckRequestBody;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryCheckResponse;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryResponse;

public interface AuthApi {
    @POST("auth/login/")
    Observable<LoginResponse> login(@Body LoginRequestBody loginRequestBody);

    @POST("auth/register/")
    Observable<RegistryResponse> registrate(@Body RegistryCheckRequestBody registryCheckRequestBody);

    @POST("auth/register/check")
    Observable<RegistryCheckResponse> checkRegistrationData(@Body RegistryCheckRequestBody registryCheckRequestBody);
//
//    @POST("auth/passwordReset")
//    Observable<PasswordResetResponse> resetPassword(@Body PasswordResetRequest passwordResetRequest);
//
//    @POST("auth/sendConfirmPhone/")
//    Observable<SendConfirmPhoneResponse> sendConfirmPhone(@Body SendConfirmPhoneRequest sendConfirmPhoneRequest);
//
//    @POST("auth/ConfirmPhone/")
//    Observable<ConfirmPhoneResponse> confirmPhone(@Body ConfirmPhoneRequest confirmPhoneRequest);
//
//    @POST("auth/refresh/")
//    Observable<RefreshTokenResponse> refreshToken(@Body RefreshtokenRequest refreshtokenRequest);
//
//    @POST("auth/logout/")
//    Observable<LogoutResponse> logout(@Body LogoutResponse logoutResponse);
}

