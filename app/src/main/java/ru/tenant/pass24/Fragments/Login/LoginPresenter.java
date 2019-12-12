package ru.tenant.pass24.Fragments.Login;

import androidx.fragment.app.FragmentManager;

import ru.tenant.pass24.Fragments.MainScreen;
import ru.tenant.pass24.R;
import ru.tenant.pass24.Fragments.Registration.RegistryFragment;

public class LoginPresenter {
    private final LoginModel model;
    private LoginFragment view;
    private FragmentManager fragmentManager;

    public LoginPresenter(LoginModel model) {
        this.model = model;
        if (model != null)
            model.loginPresenter = this;
    }

    public void attachView(LoginFragment loginFragment) {
        view = loginFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
    }

    public void detachView() {
        view = null;
    }

    public void login(String phone, String password) {
        model.login(phone, password);
    }

    public void onError(String errorTitle, String errorMessage) {
        view.showError(errorTitle, errorMessage);
    }

    public void onLoggedIn() {
        fragmentManager.beginTransaction().replace(R.id.flMainContainer, new MainScreen()).commit();
    }

    public void toRegistry() {
        fragmentManager.beginTransaction().replace(R.id.flMainContainer, new RegistryFragment()).commit();
    }

    public void toForgotPass() {
        fragmentManager.beginTransaction().replace(R.id.flMainContainer, new MainScreen()).commit();
    }
}
