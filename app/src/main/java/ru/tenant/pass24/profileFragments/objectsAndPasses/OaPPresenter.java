package ru.tenant.pass24.profileFragments.objectsAndPasses;

import androidx.fragment.app.FragmentManager;

public class OaPPresenter {
    private final OaPModel model;
    private OaPFragment view;
    private FragmentManager fragmentManager;

    public OaPPresenter(OaPModel model) {
        this.model = model;
        if (model != null)
            model.oaPPresenter = this;
    }

    public void attachView(OaPFragment oaPFragment) {
        view = oaPFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
    }

    public void detachView() {
        view = null;
    }
}
