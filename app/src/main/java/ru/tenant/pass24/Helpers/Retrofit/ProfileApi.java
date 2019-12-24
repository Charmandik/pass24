package ru.tenant.pass24.Helpers.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import ru.tenant.pass24.AuthorizationFragments.Registration.apiModels.RegistryCheckRequestBody;
import ru.tenant.pass24.AuthorizationFragments.RegistryConfirm.apiModels.ConfirmPhoneRequest;
import ru.tenant.pass24.ChangeProfileResponse;
import ru.tenant.pass24.PasswordChangeResponse;
import ru.tenant.pass24.PhoneChangeResponse;
import ru.tenant.pass24.ProfileAddressesResponse;
import ru.tenant.pass24.ProfileObjectsResponse;
import ru.tenant.pass24.ProfileResponse;

public interface ProfileApi {
    @GET("profile/")
    Observable<ProfileResponse> getProfile(@Header("Authorization") String authToken);

    @PATCH("profile/")
    Observable<ChangeProfileResponse> changeProfile(@Header("Authorization") String authToken,
                                                    @Body RegistryCheckRequestBody registryCheckRequestBody); //TODO:check how to send patch requests

    @POST("profile/password")
    Observable<PasswordChangeResponse> changePassword(@Header("Authorization") String authToken,
                                                      @Body String password);

    @POST("profile/phone")
    Observable<PhoneChangeResponse> changePhone(@Header("Authorization") String confirmPhoneToken,
                                                @Body String phone);

    @GET("profile/addresses/")
    Observable<ProfileAddressesResponse> getProfileAddresses(@Header("Authorization") String authToken);

    @GET("profile/objects/")
    Observable<ProfileObjectsResponse> getProfileObjects(@Body ConfirmPhoneRequest confirmPhoneRequest);
}
