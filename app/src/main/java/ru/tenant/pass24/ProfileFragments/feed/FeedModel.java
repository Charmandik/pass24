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
        ApiService.getInstance().getFeedApi().getFeed(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FeedResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(FeedResponse feedResponse) {
                        if(feedResponse != null)
                            if(feedResponse.getBody() != null)
                                if(feedResponse.getBody().getCollection() != null)
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
