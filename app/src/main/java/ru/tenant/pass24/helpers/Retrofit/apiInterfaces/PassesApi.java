package ru.tenant.pass24.helpers.Retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.tenant.pass24.profileFragments.passes.apiModels.CreatePassRequest;
import ru.tenant.pass24.profileFragments.passes.apiModels.CreatePassResponse;
import ru.tenant.pass24.profileFragments.passes.apiModels.PassesResponse;

public interface PassesApi {
    @GET("passes/")
    Observable<PassesResponse> getPasses(@Header("Authorization") String authToken);

    @POST("passes/")
    Observable<CreatePassResponse> createPass(@Body CreatePassRequest createPassRequest);

//    @GET("passes/")  TODO::method to get single pass
//    Observable<PassesResponse> getPasses();

    //    @PATCH("passes/")  TODO::method to edit pass
//    Observable<PassesResponse> getPasses();

    //    @DELETE("passes/")  TODO::method to delete pass
//    Observable<PassesResponse> getPasses();
}
