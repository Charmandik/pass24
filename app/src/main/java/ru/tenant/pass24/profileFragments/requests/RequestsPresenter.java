package ru.tenant.pass24.profileFragments.requests;

import androidx.fragment.app.FragmentManager;

import java.util.List;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.requests.apiModels.RequestCollection;

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

    public void toRequestsFilter() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new RequestFilterFragment())
                .addToBackStack("")
                .commit();
    }

    public void toRequestsAdd() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flRequestsContainer, RequestTypeFragment.getInstance())
                .addToBackStack(RequestTypeFragment.TAG)
                .commit();
    }
}
