package ru.tenant.pass24.ProfileFragments.requests;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Helpers.Constants;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;
import ru.tenant.pass24.ProfileFragments.requests.apiModels.RequestCollection;
import ru.tenant.pass24.ProfileFragments.requests.apiModels.RequestResponse;

public class RequestsModel {
    public RequestsPresenter requestsPresenter;
    public List<RequestCollection> requestResponses = new ArrayList<>();

    public void getRequest() {
        Constants.authToken ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvdGVuYW50LWFwaS5hbHBoYS5wYXNzMjQub25saW5lXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU3NzM0MjIzOSwiZXhwIjoxNTc3NDI4NjM5LCJuYmYiOjE1NzczNDIyMzksImp0aSI6Im9mVjRqTm9uaHV2VEx5S1YiLCJzdWIiOjEwMDAwMDcsInBydiI6IjQzMjYzMzc1ZjdmZmQ2YTJjZTVmMzhiZTkzOGZkMTJlM2YwNzlmYWUiLCJ1aWQiOiI3OTYwMzkyMzgxOTVlMDQ1NTFmZDZhNjU2Ljc3NTEyODU2In0.xtB9QHgmqfKSB5aHQXY0f8Ry2Y1ttJ5v97f8TnynmE8";
        ApiService.getInstance().getRequestApi().getRequest(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RequestResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RequestResponse requestResponse) {
                        requestResponses.addAll(requestResponse.getBody().getCollection());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        requestsPresenter.onDataLoaded(requestResponses);
                    }
                });
    }
}
