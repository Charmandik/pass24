package ru.tenant.pass24.helpers.retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.tenant.pass24.profileFragments.passes.apiModels.DeletePassResponse;
import ru.tenant.pass24.profileFragments.passes.apiModels.PassesResponse;
import ru.tenant.pass24.profileFragments.passes.apiModels.guestPassCreationModels.CreateGuestPassRequest;
import ru.tenant.pass24.profileFragments.passes.apiModels.inviteCreationModels.CreateInviteRequest;
import ru.tenant.pass24.profileFragments.passes.apiModels.inviteCreationModels.CreateInviteResponse;
import ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels.CreateVehiclePassRequest;
import ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels.CreateVehiclePassResponse;
import ru.tenant.pass24.profileFragments.passes.passSelected.apiModels.GetPassResponse;

public interface PassesApi {
    @GET("passes/")
    Observable<PassesResponse> getPasses(@Header("Authorization") String authToken);

    @POST("passes/")
    Observable<CreateVehiclePassResponse> createVehiclePass(@Header("Authorization") String authToken,
                                                            @Body CreateVehiclePassRequest createVehiclePassRequest);

    @POST("passes/")
    Observable<CreateVehiclePassResponse> createGuestPass(@Header("Authorization") String authToken,
                                                          @Body CreateGuestPassRequest createVehiclePassRequest);

    @POST("passes/invite")
    Observable<CreateInviteResponse> createInvite(@Header("Authorization") String authToken,
                                                  @Body CreateInviteRequest createInviteRequest);

    //    @PATCH("passes/")  TODO::method to edit pass
//    Observable<PassesResponse> getPasses();

    @DELETE("passes/{passId}")
    Observable<DeletePassResponse> deletePass(@Header("Authorization") String authToken,
                                              @Path("passId") int passId);

    @GET("passes/{passId}")
    Observable<GetPassResponse> getPassInfo(@Header("Authorization") String authToken,
                                            @Path("passId") int passId);
}
