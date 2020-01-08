package ru.tenant.pass24.profileFragments.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class FeedSelected extends Fragment {
    private ImageButton btnBack;
    private ImageView btnClose;
    private TextView tvEventFeedMessage, tvEventFeedTitle;
    private String title, message;

    public FeedSelected(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_feed_selected, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        btnBack = view.findViewById(R.id.btnBack);
        btnClose = view.findViewById(R.id.btnClose);
        tvEventFeedTitle = view.findViewById(R.id.tvEventFeedTitle);
        tvEventFeedMessage = view.findViewById(R.id.tvEventFeedMessage);
        tvEventFeedTitle.setText(title);
        tvEventFeedMessage.setText(message);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toEventFeed();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toEventFeed();
            }
        });
    }

    public void toEventFeed() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flFeedContainer, new FeedFragment())
                .addToBackStack(null)
                .commit();
    }
}
