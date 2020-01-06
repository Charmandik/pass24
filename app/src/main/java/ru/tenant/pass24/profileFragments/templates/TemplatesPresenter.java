package ru.tenant.pass24.profileFragments.templates;

import androidx.fragment.app.FragmentManager;

public class TemplatesPresenter {
    private final TemplatesModel model;
    private TemplatesFragment view;
    private FragmentManager fragmentManager;

    public TemplatesPresenter(TemplatesModel model) {
        this.model = model;
        if (model != null)
            model.templatesPresenter = this;
    }

    public void attachView(TemplatesFragment templatesFragment) {
        view = templatesFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
    }

    public void detachView() {
        view = null;
    }
}
