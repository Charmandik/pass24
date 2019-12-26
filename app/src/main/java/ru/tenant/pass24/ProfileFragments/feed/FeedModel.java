package ru.tenant.pass24.ProfileFragments.feed;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Helpers.Constants;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;
import ru.tenant.pass24.ProfileFragments.feed.apiModels.FeedCollection;
import ru.tenant.pass24.ProfileFragments.feed.apiModels.FeedResponse;

public class FeedModel {
    public FeedPresenter feedPresenter;
    private List<FeedCollection> feedResponses = new ArrayList();

    public void getEvents() {
        Constants.authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvdGVuYW50LWFwaS5hbHBoYS5wYXNzMjQub25saW5lXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU3NzM0MjIzOSwiZXhwIjoxNTc3NDI4NjM5LCJuYmYiOjE1NzczNDIyMzksImp0aSI6Im9mVjRqTm9uaHV2VEx5S1YiLCJzdWIiOjEwMDAwMDcsInBydiI6IjQzMjYzMzc1ZjdmZmQ2YTJjZTVmMzhiZTkzOGZkMTJlM2YwNzlmYWUiLCJ1aWQiOiI3OTYwMzkyMzgxOTVlMDQ1NTFmZDZhNjU2Ljc3NTEyODU2In0.xtB9QHgmqfKSB5aHQXY0f8Ry2Y1ttJ5v97f8TnynmE8";
        ApiService.getInstance().getFeedApi().getFeed(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FeedResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(FeedResponse feedResponse) {
                        if (feedResponse.getBody().getCollection().size() > 0)
                            feedResponses.addAll(feedResponse.getBody().getCollection());
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
