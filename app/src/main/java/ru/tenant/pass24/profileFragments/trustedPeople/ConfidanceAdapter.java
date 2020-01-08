package ru.tenant.pass24.profileFragments.trustedPeople;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.trustedPeople.apiModels.ConfidanceCollection;

class ConfidanceAdapter extends RecyclerView.Adapter<ConfidanceAdapter.ConfidanceAdapterHolder> {
    private List<ConfidanceCollection> confidanceCollectionList;
    private String prevData;
    private FragmentManager fragmentManager;

    public ConfidanceAdapter(List<ConfidanceCollection> confidanceCollectionList, FragmentManager fragmentManager) {
        this.confidanceCollectionList = confidanceCollectionList;
        this.fragmentManager = fragmentManager;
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
        final ConfidanceCollection confidanceCollection = confidanceCollectionList.get(position);
        if (confidanceCollection != null) {
            if (confidanceCollection.getConfidant() != null)
                if (confidanceCollection.getConfidant().getName() != null)
                    holder.tvTrustPeopleName.setText(confidanceCollection.getConfidant().getName());
            if (confidanceCollection.getExpiresAt() != null)
                holder.tvTrustPeopleDate.setText(confidanceCollection.getExpiresAt().substring(0, 11));
            holder.cvTrustPeopleItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toTrustPeopleSelected(
                            confidanceCollection.getConfidant().getName(),
                            confidanceCollection.getAddress().getName(),
                            confidanceCollection.getStartsAt(),
                            confidanceCollection.getExpiresAt(),
                            confidanceCollection.getConfidant().getPhone());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return (confidanceCollectionList != null ? confidanceCollectionList.size() : 0);
    }

    public void toTrustPeopleSelected(String name, String address, String startsAt, String expiresAt, String phone) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flTrustPeopleContainer, new TrustedPeopleSelected(name, address, startsAt, expiresAt, phone))
                .addToBackStack(null)
                .commit();
    }

    public static class ConfidanceAdapterHolder extends RecyclerView.ViewHolder {
        public TextView tvTrustPeopleName, tvTrustPeopleDate;
        public ImageView ivTrustPeopleItem;
        public FrameLayout flConfidanceItem;
        private CardView cvTrustPeopleItem;

        public ConfidanceAdapterHolder(ViewGroup viewGroup) {
            super(viewGroup);
            this.tvTrustPeopleName = viewGroup.findViewById(R.id.tvTrustPeopleName);
            this.tvTrustPeopleDate = viewGroup.findViewById(R.id.tvTrustPeopleDate);
            this.ivTrustPeopleItem = viewGroup.findViewById(R.id.ivTrustPeopleItem);
            this.flConfidanceItem = viewGroup.findViewById(R.id.flConfidanceItem);
            this.cvTrustPeopleItem = viewGroup.findViewById(R.id.cvTrustPeopleItem);
        }
    }
}