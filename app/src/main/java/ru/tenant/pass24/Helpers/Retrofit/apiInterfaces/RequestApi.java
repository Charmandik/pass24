package ru.tenant.pass24.Helpers.Retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import ru.tenant.pass24.ProfileFragments.requests.apiModels.RequestResponse;

public interface RequestApi {
    @GET("requests/")
    Observable<RequestResponse> getRequest(@Header("Authorization") String authToken);
}
