package ru.tenant.pass24.Fragments.Registration;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryCheckRequestBody;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryCheckResponse;
import ru.tenant.pass24.Fragments.RegistryConfirm.apiModels.SendConfirmPhoneRequest;
import ru.tenant.pass24.Fragments.RegistryConfirm.apiModels.SendConfirmPhoneResponse;
import ru.tenant.pass24.Helpers.Constants;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;

public class RegistryModel {
    public RegistryPresenter registryPresenter;

    public void checkData(String firstName, String lastName, final String phone, String email, String password) {
        final RegistryCheckRequestBody registryCheckRequestBody = new RegistryCheckRequestBody();
        registryCheckRequestBody.setFirstName(firstName);
        registryCheckRequestBody.setLastName(lastName);
        registryCheckRequestBody.setPhone(phone);
        registryCheckRequestBody.setEmail(email);
        registryCheckRequestBody.setPassword(password);

        ApiService.getInstance().getAuthApi().checkRegistrationData(registryCheckRequestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegistryCheckResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegistryCheckResponse registryCheckResponse) {
                        if (registryCheckResponse.isBody()) {
                            if (registryCheckResponse.getError() != null)
                                registryPresenter.onError(registryCheckResponse.getError().getCode(), registryCheckResponse.getError().getMessage());
                            else
                                registryPresenter.onError("Неизвестная ошибка", "");
                        } else {
                            registryPresenter.model.sendConfirmPhone(phone);
                            Constants.registryBody = registryCheckRequestBody;
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
                            registryPresenter.onError(sendConfirmPhoneResponse.getError().getCode(), sendConfirmPhoneResponse.getError().getMessage());
                        else
                            registryPresenter.toRegistryConfirm(phone);
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
