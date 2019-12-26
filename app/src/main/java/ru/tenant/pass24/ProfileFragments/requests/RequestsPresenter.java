package ru.tenant.pass24.ProfileFragments.requests;

import androidx.fragment.app.FragmentManager;

public class RequestsPresenter {

    private final RequestsModel model;
    private RequestsFragment view;
    private FragmentManager fragmentManager;

    public RequestsPresenter(RequestsModel model) {
        this.model = model;
        if (model != null)
            model.requestsPresenter = this;
    }

    public void attachView(RequestsFragment requestsFragment) {
        view = requestsFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
    }

    public void detachView() {
        view = null;
    }
}
