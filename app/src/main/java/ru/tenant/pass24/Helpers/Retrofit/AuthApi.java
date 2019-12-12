package ru.tenant.pass24.Helpers.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.tenant.pass24.Login.apiModels.LoginRequestBody;
import ru.tenant.pass24.Login.apiModels.LoginResponse;

public interface AuthApi {
    @POST("auth/login/")
    Observable<LoginResponse> getLogin(@Body LoginRequestBody loginRequestBody);
}

