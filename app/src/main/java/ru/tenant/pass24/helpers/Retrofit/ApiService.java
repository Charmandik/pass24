package ru.tenant.pass24.helpers.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.tenant.pass24.helpers.retrofit.apiInterfaces.AuthApi;
import ru.tenant.pass24.helpers.retrofit.apiInterfaces.ConfidancesApi;
import ru.tenant.pass24.helpers.retrofit.apiInterfaces.FeedApi;
import ru.tenant.pass24.helpers.retrofit.apiInterfaces.PassesApi;
import ru.tenant.pass24.helpers.retrofit.apiInterfaces.ProfileApi;
import ru.tenant.pass24.helpers.retrofit.apiInterfaces.RequestApi;
import ru.tenant.pass24.helpers.retrofit.apiInterfaces.VehicleBrand;

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

    public VehicleBrand getVehicleBrand() {
        return mRetrofit.create(VehicleBrand.class);
    }

}
