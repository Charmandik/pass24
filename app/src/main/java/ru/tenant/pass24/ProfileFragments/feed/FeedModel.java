package ru.tenant.pass24.ProfileFragments.feed;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Helpers.Constants;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;
import ru.tenant.pass24.ProfileFragments.feed.apiModels.FeedResponse;
import ru.tenant.pass24.ProfileFragments.feed.apiModels.FeedResponseBody;

public class FeedModel {
    public FeedPresenter feedPresenter;
    private List<FeedResponseBody> feedResponses = new ArrayList();

    public void getEvents() {
        Constants.authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvdGVuYW50LWFwaS5hbHBoYS5wYXNzMjQub25saW5lXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU3NzI5ODAwMiwiZXhwIjoxNTc3Mzg0NDAyLCJuYmYiOjE1NzcyOTgwMDIsImp0aSI6ImFQWHpkTkhDaUM2cTJaZzEiLCJzdWIiOjEwMDAwMDcsInBydiI6IjQzMjYzMzc1ZjdmZmQ2YTJjZTVmMzhiZTkzOGZkMTJlM2YwNzlmYWUiLCJ1aWQiOiI3OTYwMzkyMzgxOTVlMDNhODUyYzFkOTAxLjE4MTczODI2In0.wQ-EwBPGYwZS1E25GUPThLeVB3r8-bB-AL1MD1x6Y88";
        ApiService.getInstance().getFeedApi().getFeed(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FeedResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(FeedResponse feedResponse) {
                        feedResponses.add(feedResponse.getBody());
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        feedPresenter.onDataLoaded(feedResponses);
                    }
                });
    }
}
