package ru.tenant.pass24.Fragments.RegistryConfirm;

import androidx.fragment.app.FragmentManager;

public class RegistryConfirmPresenter {
    private final RegistryConfirmModel model;
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

    public void detachView() {
        view = null;
    }
}
