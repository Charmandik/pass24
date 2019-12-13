package ru.tenant.pass24.Fragments.Registration;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryCheckRequestBody;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryCheckResponse;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryResponse;
import ru.tenant.pass24.Fragments.RegistryConfirm.apiModels.SendConfirmPhoneResponse;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;

public class RegistryModel {
    public RegistryPresenter registryPresenter;

    public void registration(RegistryCheckRequestBody registryCheckRequestBody) {
        ApiService.getInstance().getAuthApi().registrate(registryCheckRequestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegistryResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegistryResponse registryResponse) {
                        registryPresenter.model.sendConfirmPhone(registryResponse.getBody().getPhone());
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

    public void checkData(String firstName, String lastName, String phone, String email, String password) {
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
                        registryPresenter.model.registration(registryCheckRequestBody);
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
        ApiService.getInstance().getAuthApi().sendConfirmPhone(phone)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SendConfirmPhoneResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(SendConfirmPhoneResponse sendConfirmPhoneResponse) {
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
