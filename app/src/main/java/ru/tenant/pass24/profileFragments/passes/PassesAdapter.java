package ru.tenant.pass24.profileFragments.passes;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.passes.apiModels.PassesCollection;

public class PassesAdapter extends RecyclerView.Adapter<PassesAdapter.PassesAdapterHolder> {
    private List<PassesCollection> passesCollections;

    public PassesAdapter(List<PassesCollection> passesCollections) {
        this.passesCollections = passesCollections;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PassesAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_my_pass, parent, false);
        return new PassesAdapterHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull PassesAdapterHolder holder, int position) {
        PassesCollection passesCollection = passesCollections.get(position);
        if (passesCollection.getTitle() != null) {
            holder.tvMyPassName.setText(passesCollection.getTitle());
        }
        if (passesCollection.getUpdatedAt() != null)
            holder.tvMyPassDate.setText(passesCollection.getUpdatedAt().substring(0, 11));
    }

    @Override
    public int getItemCount() {
        return (passesCollections != null ? passesCollections.size() : 0);
    }

    public static class PassesAdapterHolder extends RecyclerView.ViewHolder {
        TextView tvMyPassName, tvMyPassType, tvMyPassDate;

        public PassesAdapterHolder(ViewGroup viewGroup) {
            super(viewGroup);
            tvMyPassName = viewGroup.findViewById(R.id.tvMyPassName);
            tvMyPassType = viewGroup.findViewById(R.id.tvMyPassType);
            tvMyPassDate = viewGroup.findViewById(R.id.tvMyPassDate);

        }
    }
}
