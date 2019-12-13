package ru.tenant.pass24.Fragments.RegistryConfirm;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryCheckRequestBody;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryResponse;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;

public class RegistryConfirmModel {
    public RegistryConfirmPresenter registryConfirmPresenter;

    public void confirmTelephone(RegistryCheckRequestBody registryCheckRequestBody) {
        ApiService.getInstance().getAuthApi().registrate(registryCheckRequestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegistryResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegistryResponse loginResponse) {
//                        registryConfirmPresenter.toRegistryConfirm();
                    }

                    @Override
                    public void onError(Throwable e) {
                        //todo add dialog
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
