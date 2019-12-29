package ru.tenant.pass24.Helpers.Retrofit.apiInterfaces;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import ru.tenant.pass24.ProfileFragments.VehicleBrand.apiModels.VehicleBrandResponse;

public interface VehicleBrand {
    @GET("vehicle-models/")
    Observable<VehicleBrandResponse> getBrands(@Header("Authorization") String authToken);
}
