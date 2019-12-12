package ru.tenant.pass24.Fragments.Registration;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryCheckRequestBody;
import ru.tenant.pass24.Fragments.Registration.apiModels.RegistryCheckResponse;

public class RegistryModel {
    public RegistryPresenter registryPresenter;

    public void registration(String phone, String password) {
//        ApiService.getInstance().getAuthApi().login(new LoginRequestBody(phone, password))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<LoginResponse>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(LoginResponse loginResponse) {
//                        if (loginResponse.getError() != null)
//                            loginPresenter.onError(loginResponse.getError().getCode(), loginResponse.getError().getMessage());
//                        else if (loginResponse.getBody() != null) {
//                            Constants.authToken = loginResponse.getBody();
//                            loginPresenter.onLoggedIn();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        //todo add dialog
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    public void checkData(String firstName, String lastName, String phone, String email, String password) {
        RegistryCheckRequestBody registryCheckRequestBody = new RegistryCheckRequestBody();
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
