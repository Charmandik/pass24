package ru.tenant.pass24.Helpers.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import ru.tenant.pass24.ProfileFragments.feed.apiModels.FeedResponse;

public interface FeedApi {
    @GET("feed/")
    Observable<FeedResponse> getFeed(@Header("Authorization") String authToken);
}
