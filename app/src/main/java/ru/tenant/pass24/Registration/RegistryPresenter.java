package ru.tenant.pass24.Registration;

import androidx.fragment.app.FragmentManager;

public class RegistryPresenter {
    private final RegistryModel model;
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

//    public void onError(String errorTitle, String errorMessage) {
//        view.showError(errorTitle, errorMessage);
//    }
//
//    public void onLoggedIn() {
//        fragmentManager.beginTransaction().add(R.id.flMainContainer, new MainScreen()).commit();
//    }
//
//    public void toRegistry() {
//        fragmentManager.beginTransaction().add(R.id.flMainContainer, new MainScreen()).commit();
//    }
//
//    public void toForgotPass() {
//        fragmentManager.beginTransaction().add(R.id.flMainContainer, new MainScreen()).commit();
//    }
}
