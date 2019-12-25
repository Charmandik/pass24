package ru.tenant.pass24.ProfileFragments.feed;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.ProfileFragments.feed.apiModels.FeedResponseBody;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedAdapterHolder> {
    private List<FeedResponseBody> feedResponses;

    public FeedAdapter(List<FeedResponseBody> feedResponses) {
        this.feedResponses = feedResponses;
    }

    @NonNull
    @Override
    public FeedAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class FeedAdapterHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;

        public FeedAdapterHolder(TextView v) {
            super(v);
            textView = v;
        }
    }
}
