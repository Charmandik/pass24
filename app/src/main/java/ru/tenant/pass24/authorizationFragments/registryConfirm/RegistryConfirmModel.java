package ru.tenant.pass24.authorizationFragments.registryConfirm;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.authorizationFragments.registration.apiModels.RegistryCheckRequestBody;
import ru.tenant.pass24.authorizationFragments.registration.apiModels.RegistryResponse;
import ru.tenant.pass24.authorizationFragments.registryConfirm.apiModels.ConfirmPhoneRequest;
import ru.tenant.pass24.authorizationFragments.registryConfirm.apiModels.ConfirmPhoneResponse;
import ru.tenant.pass24.authorizationFragments.registryConfirm.apiModels.SendConfirmPhoneRequest;
import ru.tenant.pass24.authorizationFragments.registryConfirm.apiModels.SendConfirmPhoneResponse;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.retrofit.ApiService;

public class RegistryConfirmModel {
    public RegistryConfirmPresenter registryConfirmPresenter;

    public void confirmTelephone(String phone, String code, final boolean fromRecovery) {
        final ConfirmPhoneRequest confirmPhoneRequest = new ConfirmPhoneRequest();
        confirmPhoneRequest.setCode(code);
        confirmPhoneRequest.setPhone(phone);
        ApiService.getInstance()
                .getAuthApi()
                .confirmPhone(confirmPhoneRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ConfirmPhoneResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ConfirmPhoneResponse confirmPhoneResponse) {
//                        registryConfirmPresenter.toRegistryConfirm();
                        if (confirmPhoneResponse.getBody() == null) {
                            if (confirmPhoneResponse.getError() != null)
                                registryConfirmPresenter.onError(confirmPhoneResponse.getError().getCode(), confirmPhoneResponse.getError().getMessage());
                        } else {
                            Constants.confirmPhoneToken = confirmPhoneResponse.getBody();
                            if (!fromRecovery)
                                registryConfirmPresenter.model.registration(Constants.registryBody);
                            else
                                registryConfirmPresenter.toLogin();
                        }
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

    public void sendConfirmPhone(final String phone) {
        ApiService.getInstance().getAuthApi().sendConfirmPhone(new SendConfirmPhoneRequest(phone))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SendConfirmPhoneResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(SendConfirmPhoneResponse sendConfirmPhoneResponse) {
                        if (sendConfirmPhoneResponse.getError() != null)
                            registryConfirmPresenter.onError(sendConfirmPhoneResponse.getError().getCode(), sendConfirmPhoneResponse.getError().getMessage());
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

    public void registration(RegistryCheckRequestBody registryCheckRequestBody) {
        ApiService.getInstance().getAuthApi().registrate("Bearer " + Constants.confirmPhoneToken, registryCheckRequestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegistryResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegistryResponse registryResponse) {
                        if (registryResponse.getError() == null)
                            registryConfirmPresenter.toLogin();
                        else
                            registryConfirmPresenter.onError(registryResponse.getError().getCode(), registryResponse.getError().getMessage());
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
