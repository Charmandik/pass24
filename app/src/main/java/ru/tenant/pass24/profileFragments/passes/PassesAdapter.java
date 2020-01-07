package ru.tenant.pass24.profileFragments.passes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.passes.apiModels.PassesCollection;

public class PassesAdapter extends RecyclerView.Adapter<PassesAdapter.PassesAdapterHolder> {
    private List<PassesCollection> passesCollections;
    private FragmentManager fragmentManager;

    public PassesAdapter(List<PassesCollection> passesCollections, FragmentManager fragmentManager) {
        this.passesCollections = passesCollections;
        this.fragmentManager = fragmentManager;
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
        final PassesCollection passesCollection = passesCollections.get(position);
        final int id;
        final String title;
        final String address;
        final String visitTime;
        String visitTime1;
        final String commentary;
        final String inviteLink;

        if (passesCollection.getId() > 0)
            id = passesCollection.getId();
        else id = 0;

        if (passesCollection.getTitle() != null) {
            title = passesCollection.getTitle();
            holder.tvMyPassName.setText(title);
        } else title = "";

        if (passesCollection.getAddress() != null) {
            if (passesCollection.getAddress().getName() != null) {
                address = passesCollection.getAddress().getName();
            } else address = "";
        } else address = "";

        if (passesCollection.getStartsAt() != null) {
            visitTime1 = passesCollection.getStartsAt() + " - ";
            if (passesCollection.getExpiresAt() != null)
                visitTime1 += passesCollection.getExpiresAt();
        } else visitTime1 = "";
        visitTime = visitTime1;

        if (passesCollection.getComment() != null) {
            commentary = passesCollection.getComment();
        } else commentary = "";

        if (passesCollection.getInviteLink() != null)
            inviteLink = passesCollection.getInviteLink();
        else inviteLink = "";


        holder.cvMyPassItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPassSelected(id, title, address, visitTime, commentary, inviteLink);
            }
        });


        if (passesCollection.getUpdatedAt() != null)
            holder.tvMyPassDate.setText(passesCollection.getUpdatedAt().substring(0, 11));


    }

    public void toPassSelected(int id, String title, String address, String visitTime, String commentary, String inviteLink) {
        fragmentManager
                .beginTransaction()
                .add(R.id.flPassesContainer, new PassSelectedFragment(id, title, address, visitTime, commentary, inviteLink))
                .addToBackStack("PassSelectedFragment")
                .commit();
    }

    @Override
    public int getItemCount() {
        return (passesCollections != null ? passesCollections.size() : 0);
    }

    public static class PassesAdapterHolder extends RecyclerView.ViewHolder {
        TextView tvMyPassName, tvMyPassType, tvMyPassDate;
        CardView cvMyPassItem;

        public PassesAdapterHolder(ViewGroup viewGroup) {
            super(viewGroup);
            tvMyPassName = viewGroup.findViewById(R.id.tvMyPassName);
            tvMyPassType = viewGroup.findViewById(R.id.tvMyPassType);
            tvMyPassDate = viewGroup.findViewById(R.id.tvMyPassDate);
            cvMyPassItem = viewGroup.findViewById(R.id.cvMyPassItem);

        }
    }
}
