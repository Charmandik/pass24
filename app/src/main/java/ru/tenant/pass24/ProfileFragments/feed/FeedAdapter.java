package ru.tenant.pass24.ProfileFragments.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.ProfileFragments.feed.apiModels.FeedCollection;
import ru.tenant.pass24.R;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedAdapterHolder> {
    private List<FeedCollection> feedResponses;
    private String prevData;

    public FeedAdapter(List<FeedCollection> feedResponses) {
        this.feedResponses = feedResponses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FeedAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_feed, parent, false);
        return new FeedAdapterHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapterHolder holder, int position) {
        FeedCollection feedCollection = feedResponses.get(position);
        if (feedCollection != null) {
            holder.tvItemInfo.setText(feedCollection.getTitle());
            if (feedCollection.getHappenedAt() != null) {
                String str = feedCollection.getHappenedAt();
                holder.tvItemTime.setText(str.substring(11, 16));

                if (prevData != null && prevData.equals(str.substring(0, 11))) {
                    holder.tvEventDate.setVisibility(View.GONE);
                    holder.viewLine.setVisibility(View.GONE);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(0, 0, 0, 0);
                    holder.llItem.setLayoutParams(layoutParams);
                } else {
                    holder.tvEventDate.setText(str.substring(0, 11));
                    prevData = str.substring(0, 11);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return (feedResponses != null ? feedResponses.size() : 0);
    }

    public static class FeedAdapterHolder extends RecyclerView.ViewHolder {
        public TextView tvEventDate, tvItemInfo, tvItemTime;
        public ImageView ivItemLogo;
        public View viewLine;
        public LinearLayout llItem;

        public FeedAdapterHolder(ViewGroup viewGroup) {
            super(viewGroup);
            this.tvEventDate = viewGroup.findViewById(R.id.tvEventDate);
            this.tvItemInfo = viewGroup.findViewById(R.id.tvItemInfo);
            this.tvItemTime = viewGroup.findViewById(R.id.tvItemTime);
            this.ivItemLogo = viewGroup.findViewById(R.id.ivItemLogo);
            this.viewLine = viewGroup.findViewById(R.id.viewLine);
            this.llItem = viewGroup.findViewById(R.id.llItem);
        }
    }
}
