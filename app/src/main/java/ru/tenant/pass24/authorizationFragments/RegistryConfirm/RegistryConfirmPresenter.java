package ru.tenant.pass24.authorizationFragments.RegistryConfirm;

import androidx.fragment.app.FragmentManager;

import ru.tenant.pass24.R;
import ru.tenant.pass24.authorizationFragments.Login.LoginFragment;

public class RegistryConfirmPresenter {
    public final RegistryConfirmModel model;
    private RegistryConfirmFragment view;
    private FragmentManager fragmentManager;

    public RegistryConfirmPresenter(RegistryConfirmModel model) {
        this.model = model;
        if (model != null)
            model.registryConfirmPresenter = this;
    }

    public void attachView(RegistryConfirmFragment registryConfirmFragment) {
        view = registryConfirmFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
    }

    public void confirmTelephone(String phone, String code, boolean fromRecovery) {
        model.confirmTelephone(phone, code, fromRecovery);

    }

    public void sendConfirmPhone(String phone) {
        model.sendConfirmPhone(phone);
    }

    public void onError(String errorTitle, String errorMessage) {
        view.showError(errorTitle, errorMessage);
    }

    public void toLogin() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flMainContainer, new LoginFragment())
                .addToBackStack(null)
                .commit();
    }


    public void detachView() {
        view = null;
    }
}
