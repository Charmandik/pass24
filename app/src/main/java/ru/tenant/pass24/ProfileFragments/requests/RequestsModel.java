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
    public List<RequestCollection> requestResponses = new ArrayList();

    public void getRequest() {
        Constants.authToken ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvdGVuYW50LWFwaS5hbHBoYS5wYXNzMjQub25saW5lXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU3NzM2MTM3NCwiZXhwIjoxNTc3NDQ3Nzc0LCJuYmYiOjE1NzczNjEzNzQsImp0aSI6IkJkazJNWHdSeTY0T3NkYnciLCJzdWIiOjEwMDAwMDIsInBydiI6IjQzMjYzMzc1ZjdmZmQ2YTJjZTVmMzhiZTkzOGZkMTJlM2YwNzlmYWUiLCJ1aWQiOiI3OTYzNjk5MzYzMDVlMDQ5ZmRlZDE0NWMzLjUwMTc0NjM5In0.3-35QjEx9PNS7PD0W5gqRlbGIILcFCdtAzIBT2xINsw";
        ApiService.getInstance().getRequestApi().getRequest(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RequestResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RequestResponse requestResponse) {
                        if (requestResponse.getBody().getCollection().size() > 0)
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
