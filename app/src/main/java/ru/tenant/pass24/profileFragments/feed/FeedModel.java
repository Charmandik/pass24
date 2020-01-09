package ru.tenant.pass24.profileFragments.feed;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.retrofit.ApiService;
import ru.tenant.pass24.profileFragments.feed.apiModels.FeedCollection;
import ru.tenant.pass24.profileFragments.feed.apiModels.FeedResponse;

public class FeedModel {
    public FeedPresenter feedPresenter;
    private List<FeedCollection> feedResponses = new ArrayList();

    public void getEvents() {
        Constants.authToken += "123";
        ApiService.getInstance().getFeedApi().getFeed(Constants.getAuthToken(), Constants.eventFeedTypeFilter, Constants.eventFeedConfidantFilter)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FeedResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(FeedResponse feedResponse) {
                        if (feedResponse != null)
                            if (feedResponse.getBody() != null) {
                                if (feedResponse.getBody().getCollection() != null)
                                    if (feedResponse.getBody().getCollection().size() > 0)
                                        feedResponses.addAll(feedResponse.getBody().getCollection());
                            } else if (feedResponse.getError() != null)
                                if (feedResponse.getError().getCode() != null)
                                    if (feedResponse.getError().getCode().equals("UNAUTHENTICATED"))
                                        toLogin();

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

    public void toLogin() {
        feedPresenter.toLogin();
    }
}
