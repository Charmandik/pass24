package ru.tenant.pass24.Fragments.PasswordRecovery;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Fragments.PasswordRecovery.apiModels.PasswordResetRequest;
import ru.tenant.pass24.Fragments.PasswordRecovery.apiModels.PasswordResetResponse;
import ru.tenant.pass24.Fragments.RegistryConfirm.apiModels.SendConfirmPhoneRequest;
import ru.tenant.pass24.Fragments.RegistryConfirm.apiModels.SendConfirmPhoneResponse;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;

public class PasswordRecoveryModel {
    public PasswordRecoveryPresenter passwordRecoveryPresenter;

    public void passRecovery(String phone) {
        ApiService.getInstance().getAuthApi().resetPassword(new PasswordResetRequest(phone, ""))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PasswordResetResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PasswordResetResponse loginResponse) {
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
                        if (sendConfirmPhoneResponse.getError() != null) {
                            if (sendConfirmPhoneResponse.getError().getDetails() != null) {
                                if (sendConfirmPhoneResponse.getError().getDetails().getPhone() != null)
                                    passwordRecoveryPresenter.showErrorOnPhone(true, sendConfirmPhoneResponse.getError().getDetails().getPhone().get(0));
                            } else {
                                passwordRecoveryPresenter.onError(sendConfirmPhoneResponse.getError().getCode(), sendConfirmPhoneResponse.getError().getMessage());
                                passwordRecoveryPresenter.showErrorOnPhone(false, "");
                            }
                        } else {
                            passwordRecoveryPresenter.toRegistryConfirm(phone);
                            passwordRecoveryPresenter.showErrorOnPhone(false, "");
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
}
