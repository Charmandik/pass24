package ru.tenant.pass24.ProfileFragments.trustedPeople;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.ProfileFragments.trustedPeople.apiModels.ConfidanceCollection;
import ru.tenant.pass24.R;

class ConfidanceAdapter extends RecyclerView.Adapter<ConfidanceAdapter.ConfidanceAdapterHolder> {
    private List<ConfidanceCollection> confidanceCollectionList;
    private String prevData;

    public ConfidanceAdapter(List<ConfidanceCollection> confidanceCollectionList) {
        this.confidanceCollectionList = confidanceCollectionList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ConfidanceAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_trust_people, parent, false);
        return new ConfidanceAdapterHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull ConfidanceAdapterHolder holder, int position) {
        ConfidanceCollection feedCollection = confidanceCollectionList.get(position);
        if (feedCollection != null) {
            if (feedCollection.getConfidant() != null)
                if (feedCollection.getConfidant().getName() != null)
                    holder.tvTrustPeopleName.setText(feedCollection.getConfidant().getName());
            if (feedCollection.getExpiresAt() != null)
                holder.tvTrustPeopleDate.setText(feedCollection.getExpiresAt().substring(0, 11));
        }
    }

    @Override
    public int getItemCount() {
        return (confidanceCollectionList != null ? confidanceCollectionList.size() : 0);
    }

    public static class ConfidanceAdapterHolder extends RecyclerView.ViewHolder {
        public TextView tvTrustPeopleName, tvTrustPeopleDate;
        public ImageView ivTrustPeopleItem;

        public ConfidanceAdapterHolder(ViewGroup viewGroup) {
            super(viewGroup);
            this.tvTrustPeopleName = viewGroup.findViewById(R.id.tvTrustPeopleName);
            this.tvTrustPeopleDate = viewGroup.findViewById(R.id.tvTrustPeopleDate);
            this.ivTrustPeopleItem = viewGroup.findViewById(R.id.ivTrustPeopleItem);
        }
    }
}