package ru.tenant.pass24.Fragments.PasswordRecovery;

import androidx.fragment.app.FragmentManager;

import ru.tenant.pass24.Fragments.Login.LoginFragment;
import ru.tenant.pass24.R;

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

    public void detachView() {
        view = null;
    }
}
