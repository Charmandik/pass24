package ru.tenant.pass24.ProfileFragments.requests;

import androidx.fragment.app.FragmentManager;

import java.util.List;

import ru.tenant.pass24.ProfileFragments.requests.apiModels.RequestCollection;

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

    public void onDataLoaded(List<RequestCollection> requestResponses) {
        view.setDataForRecycler(requestResponses);
    }
}
