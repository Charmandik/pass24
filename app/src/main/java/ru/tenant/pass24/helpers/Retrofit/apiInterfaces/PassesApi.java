package ru.tenant.pass24.helpers.Retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.tenant.pass24.profileFragments.passes.apiModels.PassesResponse;
import ru.tenant.pass24.profileFragments.passes.apiModels.guestPassCreationModels.CreateGuestPassRequest;
import ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels.CreateVehiclePassRequest;
import ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels.CreateVehiclePassResponse;

public interface PassesApi {
    @GET("passes/")
    Observable<PassesResponse> getPasses(@Header("Authorization") String authToken);

    @POST("passes/")
    Observable<CreateVehiclePassResponse> createVehiclePass(@Header("Authorization") String authToken,
                                                            @Body CreateVehiclePassRequest createVehiclePassRequest);
    @POST("passes/")
    Observable<CreateVehiclePassResponse> createGuestPass(@Header("Authorization") String authToken,
                                                          @Body CreateGuestPassRequest createVehiclePassRequest);

//    @GET("passes/")  TODO::method to get single pass
//    Observable<PassesResponse> getPasses();

    //    @PATCH("passes/")  TODO::method to edit pass
//    Observable<PassesResponse> getPasses();

    //    @DELETE("passes/")  TODO::method to delete pass
//    Observable<PassesResponse> getPasses();
}
