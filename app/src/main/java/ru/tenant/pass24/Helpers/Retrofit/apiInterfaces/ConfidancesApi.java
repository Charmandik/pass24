package ru.tenant.pass24.Helpers.Retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.tenant.pass24.ProfileFragments.requests.newConfidance.apiModels.NewConfidanceRequest;
import ru.tenant.pass24.ProfileFragments.requests.newConfidance.apiModels.NewConfidanceResponse;
import ru.tenant.pass24.ProfileFragments.trustedPeople.apiModels.ConfidanceResponse;

public interface ConfidancesApi {
    @GET("confidances/")
    Observable<ConfidanceResponse> getConfidances(@Header("Authorization") String authToken);

    @POST("confidances/")
    Observable<NewConfidanceResponse> createConfidance(@Header("Authorization") String authToken,
                                                       @Body NewConfidanceRequest newConfidanceRequest);
}