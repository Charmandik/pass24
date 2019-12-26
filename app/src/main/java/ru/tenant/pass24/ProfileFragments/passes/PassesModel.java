package ru.tenant.pass24.ProfileFragments.passes;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Helpers.Constants;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;
import ru.tenant.pass24.ProfileFragments.passes.apiModels.PassesCollection;
import ru.tenant.pass24.ProfileFragments.passes.apiModels.PassesResponse;

public class PassesModel {
    public PassesPresenter passesPresenter;
    private List<PassesCollection> passesResponses = new ArrayList<>();

    public void getPasses() {
        Constants.authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvdGVuYW50LWFwaS5hbHBoYS5wYXNzMjQub25saW5lXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU3NzM2MTM3NCwiZXhwIjoxNTc3NDQ3Nzc0LCJuYmYiOjE1NzczNjEzNzQsImp0aSI6IkJkazJNWHdSeTY0T3NkYnciLCJzdWIiOjEwMDAwMDIsInBydiI6IjQzMjYzMzc1ZjdmZmQ2YTJjZTVmMzhiZTkzOGZkMTJlM2YwNzlmYWUiLCJ1aWQiOiI3OTYzNjk5MzYzMDVlMDQ5ZmRlZDE0NWMzLjUwMTc0NjM5In0.3-35QjEx9PNS7PD0W5gqRlbGIILcFCdtAzIBT2xINsw";
        ApiService.getInstance().getPassesApi().getPasses(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PassesResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(PassesResponse passesResponse) {
                        passesResponses.addAll(passesResponse.getBody().getCollection());
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        passesPresenter.onDataLoaded(passesResponses);
                    }
                });
    }
}
