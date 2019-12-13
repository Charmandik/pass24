package ru.tenant.pass24.Fragments.Registration;

import androidx.fragment.app.FragmentManager;

import ru.tenant.pass24.Fragments.Login.LoginFragment;
import ru.tenant.pass24.Fragments.RegistryConfirm.RegistryConfirmFragment;
import ru.tenant.pass24.R;

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
}
