package ru.tenant.pass24.Helpers.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static ApiService mInstance;
    private static final String BASE_URL = "https://tenant-api.alpha.pass24.online";
    private Retrofit mRetrofit;

    private ApiService() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static ApiService getInstance() {
        if (mInstance == null) {
            mInstance = new ApiService();
        }
        return mInstance;
    }

    public AuthMethods getAuthMethods() {
        return mRetrofit.create(AuthMethods.class);
    }

}
