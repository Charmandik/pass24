package ru.tenant.pass24.ProfileFragments.feed;

import androidx.fragment.app.FragmentManager;

import java.util.List;

import ru.tenant.pass24.AuthorizationFragments.Registration.RegistryFragment;
import ru.tenant.pass24.ProfileFragments.feed.apiModels.FeedCollection;
import ru.tenant.pass24.R;

public class FeedPresenter {
    private final FeedModel model;
    private FeedFragment view;
    private FragmentManager fragmentManager;

    public FeedPresenter(FeedModel model) {
        this.model = model;
        if (model != null)
            model.feedPresenter = this;
    }

    public void attachView(FeedFragment feedFragment) {
        view = feedFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
    }

    public void detachView() {
        view = null;
    }

    public void onDataLoaded(List<FeedCollection> feedResponses) {
        view.setDataForRecycler(feedResponses);
    }

    public void toEventFeedFilters() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flFeedContainer, new FeedFilter())
                .addToBackStack(null)
                .commit();
    }
}
