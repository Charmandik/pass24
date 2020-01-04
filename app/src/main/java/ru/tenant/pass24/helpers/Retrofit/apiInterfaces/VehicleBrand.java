package ru.tenant.pass24.helpers.Retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import ru.tenant.pass24.profileFragments.vehicleBrand.apiModels.VehicleBrandResponse;

public interface VehicleBrand {
    @GET("vehicle-models/")
    Observable<VehicleBrandResponse> getBrands(@Header("Authorization") String authToken);
}
