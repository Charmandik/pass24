package ru.tenant.pass24.profileFragments.trustedPeople;

import androidx.fragment.app.FragmentManager;

import java.util.List;

import ru.tenant.pass24.profileFragments.trustedPeople.apiModels.ConfidanceCollection;

public class TrustedPeoplePresenter {
    private final TrustedPeopleModel model;
    private TrustedPeopleFragment view;
    private FragmentManager fragmentManager;

    public TrustedPeoplePresenter(TrustedPeopleModel model) {
        this.model = model;
        if (model != null)
            model.trustedPeoplePresenter = this;
    }

    public void attachView(TrustedPeopleFragment trustedPeopleFragment) {
        view = trustedPeopleFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
        model.mContext = view;
    }

    public void detachView() {
        view = null;
    }

    public void onDataLoaded(List<ConfidanceCollection> confidanceCollections) {
        view.setDataForRecycler(confidanceCollections);
    }
}
