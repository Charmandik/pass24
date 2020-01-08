package ru.tenant.pass24.profileFragments.feed;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;

public class FeedFilter extends Fragment {
    private RelativeLayout rlEventTypeFilter, rlEventConfidantFilter;
    private TextView tvResetFilter, tvFeedTypeFilter;
    private Switch swEventConfidantFilter;
    private ImageButton btnBack;
    private ImageView btnClose;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_feed_filter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        rlEventTypeFilter = view.findViewById(R.id.rlEventTypeFilter);
        rlEventConfidantFilter = view.findViewById(R.id.rlEventConfidantFilter);
        tvResetFilter = view.findViewById(R.id.tvResetFilter);
        swEventConfidantFilter = view.findViewById(R.id.swEventConfidantFilter);
        tvFeedTypeFilter = view.findViewById(R.id.tvFeedTypeFilter);
        btnClose = view.findViewById(R.id.btnClose);
        btnBack = view.findViewById(R.id.btnBack);

        rlEventTypeFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toFeedTypeFilterFragment();
            }
        });

        rlEventConfidantFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swEventConfidantFilter.toggle();
                toggleTypeFilter();
            }
        });

        tvResetFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.eventFeedConfidantFilter = null;
                Constants.eventFeedTypeFilter = null;
                Log.d("tag", Constants.eventFeedTypeFilter + " nulled");
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toEventFeed();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toEventFeed();
            }
        });
        Log.d("tag", Constants.eventFeedTypeFilter + " type");
        if (Constants.eventFeedTypeFilter != null)
            switch (Constants.eventFeedTypeFilter) {
                case (1):
                    tvFeedTypeFilter.setText("Сущность создана");
                    break;
                case (2):
                    tvFeedTypeFilter.setText("Сущность изменена");
                    break;
                case (3):
                    tvFeedTypeFilter.setText("Сущность удалена");
                    break;
                case (4):
                    tvFeedTypeFilter.setText("Изменен статус пропуска");
                    break;
                case (8):
                    tvFeedTypeFilter.setText("Изменен статус доверенности");
                    break;
                case (11):
                    tvFeedTypeFilter.setText("Запрос одобрен");
                    break;
                case (12):
                    tvFeedTypeFilter.setText("Запрос отклонен");
                    break;
            }
        else
            tvFeedTypeFilter.setText("Все");
    }

    public void toFeedTypeFilterFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flFeedContainer, new FeedFilterTypeFragment())
                .addToBackStack("")
                .commit();
    }

    private void toggleTypeFilter() {
        if (Constants.eventFeedConfidantFilter != null)
            if (Constants.eventFeedConfidantFilter == 0)
                Constants.eventFeedConfidantFilter = 1;
            else
                Constants.eventFeedConfidantFilter = 0;
    }

    public void toEventFeed() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flFeedContainer, new FeedFragment())
                .addToBackStack(null)
                .commit();
    }
}
