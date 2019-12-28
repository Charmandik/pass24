package ru.tenant.pass24.Helpers.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static final String BASE_URL = "https://mobile-api.pass24online.ru/v1/";
    private static ApiService mInstance;
    private Retrofit mRetrofit;

    private ApiService() {
        mRetrofit = new Retrofit.Builder()
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

    public AuthApi getAuthApi() {
        return mRetrofit.create(AuthApi.class);
    }

    public ProfileApi getProfileApi() {
        return mRetrofit.create(ProfileApi.class);
    }

    public PassesApi getPassesApi() {
        return mRetrofit.create(PassesApi.class);
    }

    public FeedApi getFeedApi() {
        return mRetrofit.create(FeedApi.class);
    }

    public RequestApi getRequestApi() {
        return mRetrofit.create(RequestApi.class);
    }

    public ConfidancesApi getConfidancesApi() {
        return mRetrofit.create(ConfidancesApi.class);
    }
}
