package ru.tenant.pass24.profileFragments.trustedPeople;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.MainActivity;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.retrofit.ApiService;
import ru.tenant.pass24.profileFragments.trustedPeople.apiModels.ConfidanceCollection;
import ru.tenant.pass24.profileFragments.trustedPeople.apiModels.ConfidanceResponse;

public class TrustedPeopleModel {
    public TrustedPeoplePresenter trustedPeoplePresenter;
    public TrustedPeopleFragment mContext;

    private List<ConfidanceCollection> confidanceCollections = new ArrayList();

    public void getConfidances() {
        ApiService.getInstance().getConfidancesApi().getConfidances(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ConfidanceResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ConfidanceResponse confidanceResponse) {
                        if (confidanceResponse != null)
                            if (confidanceResponse.getBody() != null) {
                                if (confidanceResponse.getBody().getCollection() != null)
                                    if (confidanceResponse.getBody().getCollection().size() > 0)
                                        confidanceCollections.addAll(confidanceResponse.getBody().getCollection());
                            } else if (confidanceResponse.getError() != null)
                                if (confidanceResponse.getError().getCode() != null)
                                    if (confidanceResponse.getError().getCode().equals("UNAUTHENTICATED"))
                                        toLogin();

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        trustedPeoplePresenter.onDataLoaded(confidanceCollections);
                    }
                });
    }

    public void toLogin() {
        Intent intent = new Intent(mContext.getContext(), MainActivity.class);
        intent.putExtra("toLogin", true);
        mContext.startActivity(intent);
        if (mContext.getActivity() != null)
            mContext.getActivity().finish();
    }

}
