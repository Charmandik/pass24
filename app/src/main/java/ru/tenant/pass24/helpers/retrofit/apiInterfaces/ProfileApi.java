package ru.tenant.pass24.helpers.retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import ru.tenant.pass24.apiModelsNonUsed.ChangeProfileRequest;
import ru.tenant.pass24.apiModelsNonUsed.ChangeProfileResponse;
import ru.tenant.pass24.apiModelsNonUsed.PhoneChangeResponse;
import ru.tenant.pass24.apiModelsNonUsed.ProfileObjectsResponse;
import ru.tenant.pass24.apiModelsNonUsed.ProfileResponse;
import ru.tenant.pass24.authorizationFragments.registryConfirm.apiModels.ConfirmPhoneRequest;
import ru.tenant.pass24.profileFragments.addressSearch.apiModels.ProfileAddressesResponse;
import ru.tenant.pass24.profileFragments.profile.changePassword.apiModels.PasswordChangeResponse;

public interface ProfileApi {
    @GET("profile/")
    Observable<ProfileResponse> getProfile(@Header("Authorization") String authToken);

    @PATCH("profile/")
    Observable<ChangeProfileResponse> changeProfile(@Header("Authorization") String authToken,
                                                    @Body ChangeProfileRequest changeProfileRequest); //TODO:check how to send patch requests

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
