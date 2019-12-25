package ru.tenant.pass24.ProfileFragments.trustedPeople;

import androidx.fragment.app.FragmentManager;

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
    }

    public void detachView() {
        view = null;
    }
}