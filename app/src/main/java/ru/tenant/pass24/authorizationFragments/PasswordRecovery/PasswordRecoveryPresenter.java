package ru.tenant.pass24.authorizationFragments.PasswordRecovery;

import androidx.fragment.app.FragmentManager;

import ru.tenant.pass24.R;
import ru.tenant.pass24.authorizationFragments.Login.LoginFragment;
import ru.tenant.pass24.authorizationFragments.RegistryConfirm.RegistryConfirmFragment;

public class PasswordRecoveryPresenter {
    private final PasswordRecoveryModel model;
    private PasswordRecoveryFragment view;
    private FragmentManager fragmentManager;

    public PasswordRecoveryPresenter(PasswordRecoveryModel model) {
        this.model = model;
        if (model != null)
            model.passwordRecoveryPresenter = this;
    }

    public void attachView(PasswordRecoveryFragment passwordRecoveryFragment) {
        view = passwordRecoveryFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
    }

    public void toLogin() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flMainContainer, new LoginFragment())
                .addToBackStack(null)
                .commit();
    }

    public void recoveryPass(String phone) {
        model.passRecovery(phone);
        fragmentManager
                .beginTransaction()
                .replace(R.id.flMainContainer, new RegistryConfirmFragment(phone, true))
                .addToBackStack(null)
                .commit();
    }
    public void sendConfirmPhone(String phone) {
        model.sendConfirmPhone(phone);
    }

    public void toRegistryConfirm(String phone) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flMainContainer, new RegistryConfirmFragment(phone, true))
                .addToBackStack(null)
                .commit();
    }

    public void onError(String errorTitle, String errorMessage) {
        view.showError(errorTitle, errorMessage);
    }

    public void showErrorOnPhone(boolean show, String text) {
        view.showErrorOnPhone(show, text);
    }


    public void detachView() {
        view = null;
    }
}
