package ru.tenant.pass24.Helpers.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import ru.tenant.pass24.ProfileFragments.trustedPeople.ConfidancesResponse;

public interface ConfidancesApi {
    @GET("confidances/")
    Observable<ConfidancesResponse> getConfidances(@Header("Authorization") String authToken);
}