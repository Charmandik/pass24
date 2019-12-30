package ru.tenant.pass24.helpers.Retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.tenant.pass24.profileFragments.requests.apiModels.RequestResponse;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestBody;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestResponse;

public interface RequestApi {
    @GET("requests/")
    Observable<RequestResponse> getRequest(@Header("Authorization") String authToken);

    @POST("requests/")
    Observable<CreateRequestResponse> createRequest(@Header("Authorization") String authToken,
                                                    @Body CreateRequestBody createRequestBody);
}
