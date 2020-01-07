package ru.tenant.pass24.profileFragments.requests;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.retrofit.ApiService;
import ru.tenant.pass24.profileFragments.requests.apiModels.RequestCollection;
import ru.tenant.pass24.profileFragments.requests.apiModels.RequestResponse;

public class RequestsModel {
    public RequestsPresenter requestsPresenter;
    public List<RequestCollection> requestResponses = new ArrayList<>();

    public void getRequest() {
        ApiService.getInstance().getRequestApi().getRequest(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RequestResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RequestResponse requestResponse) {
                        if (requestResponse != null)
                            if (requestResponse.getBody() != null)
                                if (requestResponse.getBody().getCollection() != null)
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
