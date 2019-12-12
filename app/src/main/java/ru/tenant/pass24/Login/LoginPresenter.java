package ru.tenant.pass24.Login;

public class LoginPresenter {
    private final LoginModel model;
    private LoginFragment view;

    public LoginPresenter(LoginModel model) {
        this.model = model;
        if (model != null)
            model.loginPresenter = this;
    }

    public void attachView(LoginFragment loginFragment) {
        view = loginFragment;
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

    }
}
