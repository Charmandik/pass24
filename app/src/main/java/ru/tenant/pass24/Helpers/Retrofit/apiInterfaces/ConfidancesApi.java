package ru.tenant.pass24.Helpers.Retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import ru.tenant.pass24.ProfileFragments.trustedPeople.apiModels.ConfidanceResponse;

public interface ConfidancesApi {
    @GET("confidances/")
    Observable<ConfidanceResponse> getConfidances(@Header("Authorization") String authToken);
}