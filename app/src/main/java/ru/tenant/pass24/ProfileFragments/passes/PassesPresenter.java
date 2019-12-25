package ru.tenant.pass24.ProfileFragments.passes;

import androidx.fragment.app.FragmentManager;

public class PassesPresenter {
    private final PassesModel model;
    private PassesFragment view;
    private FragmentManager fragmentManager;

    public PassesPresenter(PassesModel model) {
        this.model = model;
        if (model != null)
            model.passesPresenter = this;
    }

    public void attachView(PassesFragment passesFragment) {
        view = passesFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
    }

    public void detachView() {
        view = null;
    }
}
