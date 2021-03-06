package ru.tenant.pass24.authorizationFragments.registration;

import androidx.fragment.app.FragmentManager;

import ru.tenant.pass24.R;
import ru.tenant.pass24.authorizationFragments.login.LoginFragment;
import ru.tenant.pass24.authorizationFragments.registryConfirm.RegistryConfirmFragment;

public class RegistryPresenter {
    public final RegistryModel model;
    private RegistryFragment view;
    private FragmentManager fragmentManager;

    public RegistryPresenter(RegistryModel model) {
        this.model = model;
        if (model != null)
            model.registryPresenter = this;
    }

    public void attachView(RegistryFragment registryFragment) {
        view = registryFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
    }

    public void detachView() {
        view = null;
    }

    public void registration() {
//        model.registration();
    }

    public void checkData(String firstName, String secondName, String phone, String email, String password) {
        model.checkData(firstName, secondName, phone, email, password);
    }

    public void toLogin() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flMainContainer, new LoginFragment())
                .addToBackStack(null)
                .commit();
    }

    public void toRegistryConfirm(String phone) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flMainContainer, new RegistryConfirmFragment(phone))
                .addToBackStack(null)
                .commit();
    }

    public void onError(String errorTitle, String errorMessage) {
        view.showError(errorTitle, errorMessage);
    }

    public void showErrorOnFirstName(boolean show, String text) {
        view.showErrorOnFirstName(show, text);
    }

    public void showErrorOnLastName(boolean show, String text) {
        view.showErrorOnLastName(show, text);
    }

    public void showErrorOnEmail(boolean show, String text) {
        view.showErrorOnEmail(show, text);
    }

    public void showErrorOnPhone(boolean show, String text) {
        view.showErrorOnPhone(show, text);
    }

    public void showErrorOnPassword(boolean show, String text) {
        view.showErrorOnPassword(show, text);
    }
}
