package ru.tenant.pass24.Helpers.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;
import ru.tenant.pass24.ProfileFragments.passes.apiModels.PassesResponse;

public interface PassesApi {
    @GET("passes/")
    Observable<PassesResponse> getPasses();
}
