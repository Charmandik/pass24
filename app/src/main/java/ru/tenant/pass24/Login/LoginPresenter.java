package ru.tenant.pass24.Login;

public class LoginPresenter {
    private final LoginModel model;
    private LoginFragment view;

    public LoginPresenter(LoginModel model) {
        this.model = model;
    }

    public void attachView(LoginFragment loginFragment) {
        view = loginFragment;
    }

    public void detachView() {
        view = null;
    }
}
