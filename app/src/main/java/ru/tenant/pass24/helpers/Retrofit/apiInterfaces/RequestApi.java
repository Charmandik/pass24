package ru.tenant.pass24.helpers.Retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.tenant.pass24.profileFragments.passes.apiModels.CreatePassRequestBody;
import ru.tenant.pass24.profileFragments.requests.apiModels.RequestResponse;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestBody;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestResponse;
import ru.tenant.pass24.profileFragments.requests.newConfidance.apiModels.NewConfidanceRequest;

public interface RequestApi {
    @GET("requests/")
    Observable<RequestResponse> getRequest(@Header("Authorization") String authToken);

    @POST("requests/")
    Observable<CreateRequestResponse> createRequest(@Header("Authorization") String authToken,
                                                    @Body CreateRequestBody createRequestBody);

    @POST("requests/")
    Observable<CreateRequestResponse> createRequestNewConfidant(@Header("Authorization") String authToken,
                                                                @Body NewConfidanceRequest newConfidanceRequest);

    @POST("requests/")
    Observable<CreateRequestResponse> createPassRequest(@Header("Authorization") String authToken,
                                                        @Body CreatePassRequestBody createPassRequestBody);
}
