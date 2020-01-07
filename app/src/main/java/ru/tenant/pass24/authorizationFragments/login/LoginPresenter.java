package ru.tenant.pass24.authorizationFragments.login;

import android.content.Intent;
import android.content.SharedPreferences;

import androidx.fragment.app.FragmentManager;

import java.util.Objects;

import ru.tenant.pass24.MainScreenActivity;
import ru.tenant.pass24.R;
import ru.tenant.pass24.authorizationFragments.passwordRecovery.PasswordRecoveryFragment;
import ru.tenant.pass24.authorizationFragments.registration.RegistryFragment;

import static android.content.Context.MODE_PRIVATE;

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
        Intent intent = new Intent(this.view.getContext(), MainScreenActivity.class);
        Objects.requireNonNull(this.view.getActivity()).startActivity(intent);
    }

    public void saveToken(String token) {
        SharedPreferences sharedPreferences = this.view.getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("AUTH_TOKEN", token);
        editor.apply();
    }

    public void toRegistry() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flMainContainer, new RegistryFragment())
                .addToBackStack(null)
                .commit();
    }

    public void toForgotPass() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flMainContainer, new PasswordRecoveryFragment())
                .addToBackStack(null)
                .commit();
    }
}
