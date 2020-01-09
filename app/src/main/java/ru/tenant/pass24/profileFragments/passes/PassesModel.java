package ru.tenant.pass24.profileFragments.passes;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.retrofit.ApiService;
import ru.tenant.pass24.profileFragments.passes.apiModels.PassesCollection;
import ru.tenant.pass24.profileFragments.passes.apiModels.PassesResponse;

public class PassesModel {
    public PassesPresenter passesPresenter;
    private List<PassesCollection> passesResponses = new ArrayList<>();

    public void getPasses() {
        ApiService.getInstance().getPassesApi().getPasses(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PassesResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(PassesResponse passesResponse) {
                        if (passesResponse != null)
                            if (passesResponse.getBody() != null) {
                                if (passesResponse.getBody().getCollection() != null)
                                    passesResponses.addAll(passesResponse.getBody().getCollection());
                            } else if (passesResponse.getError() != null) {
                                if (passesResponse.getError().getCode() != null)
                                    if (passesResponse.getError().getCode().equals("UNAUTHENTICATED")) {
                                        toLogin();
                                    }
                            }
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

    public void toLogin() {
        passesPresenter.toLogin();
    }
}
