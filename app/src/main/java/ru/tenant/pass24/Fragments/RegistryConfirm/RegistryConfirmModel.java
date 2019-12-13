package ru.tenant.pass24.Fragments.RegistryConfirm;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Fragments.RegistryConfirm.apiModels.ConfirmPhoneRequest;
import ru.tenant.pass24.Fragments.RegistryConfirm.apiModels.ConfirmPhoneResponse;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;

public class RegistryConfirmModel {
    public RegistryConfirmPresenter registryConfirmPresenter;

    public void confirmTelephone(String phone, String code) {
        ConfirmPhoneRequest confirmPhoneRequest = new ConfirmPhoneRequest();
        confirmPhoneRequest.setCode(code);
        confirmPhoneRequest.setPhone(phone);
        ApiService.getInstance().getAuthApi().confirmPhone(confirmPhoneRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ConfirmPhoneResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ConfirmPhoneResponse confirmPhoneResponse) {
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
