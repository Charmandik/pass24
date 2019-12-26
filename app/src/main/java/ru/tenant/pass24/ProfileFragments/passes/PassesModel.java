package ru.tenant.pass24.ProfileFragments.passes;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Helpers.Constants;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;
import ru.tenant.pass24.ProfileFragments.passes.apiModels.PassesResponse;
import ru.tenant.pass24.ProfileFragments.passes.apiModels.PassesResponseBody;

public class PassesModel {
    public PassesPresenter passesPresenter;
    private List<PassesResponseBody> passesResponses = new ArrayList<>();

    public void getPasses() {
        Constants.authToken = "";
        ApiService.getInstance().getPassesApi().getPasses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PassesResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PassesResponse passesResponse) {
                        passesResponses.add(passesResponse.getBody());
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
