package ru.tenant.pass24.Helpers.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.tenant.pass24.Login.LoginRequestBody;
import ru.tenant.pass24.Login.LoginResponse;

public interface AuthMethods {
    @POST("auth/login/")
    Observable<LoginResponse> getLogin(@Body LoginRequestBody loginRequestBody);
}

