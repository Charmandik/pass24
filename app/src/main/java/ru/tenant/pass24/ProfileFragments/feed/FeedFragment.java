package ru.tenant.pass24.ProfileFragments.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.ProfileFragments.feed.apiModels.FeedResponse;
import ru.tenant.pass24.ProfileFragments.feed.apiModels.FeedResponseBody;
import ru.tenant.pass24.R;

public class FeedFragment extends Fragment {
    private FeedPresenter feedPresenter;
    private ImageView ibEventSettings;
    private RecyclerView rvFeed;
    private RecyclerView.LayoutManager layoutManager;
    private FeedAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        FeedModel feedModel = new FeedModel();
        feedPresenter = new FeedPresenter(feedModel);
        feedPresenter.attachView(this);
        ibEventSettings = view.findViewById(R.id.ibEventSettings);

        rvFeed = view.findViewById(R.id.rvFeed);
        rvFeed.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        rvFeed.setLayoutManager(layoutManager);
        feedModel.getEvents();
    }

    public void setDataForRecycler(List<FeedResponseBody> feedResponses) {
        mAdapter = new FeedAdapter(feedResponses);
        rvFeed.setAdapter(mAdapter);
    }
}