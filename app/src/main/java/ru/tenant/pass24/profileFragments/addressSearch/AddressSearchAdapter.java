package ru.tenant.pass24.profileFragments.addressSearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.addressSearch.apiModels.ProfileAddressesResponseBody;

public class AddressSearchAdapter extends RecyclerView.Adapter<AddressSearchAdapter.AddressSearchHolder> {
    private List<ProfileAddressesResponseBody> profileAddressesBodiesList;
    private List<RadioButton> radioButtonList = new ArrayList();
    private Context mContext;

    public AddressSearchAdapter(List<ProfileAddressesResponseBody> profileAddressesBodiesList, Context context) {
        this.profileAddressesBodiesList = profileAddressesBodiesList;
        this.mContext = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AddressSearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_address_search, parent, false);
        return new AddressSearchHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull final AddressSearchHolder holder, int position) {
        ProfileAddressesResponseBody profileAddressesResponseBody = profileAddressesBodiesList.get(position);
        holder.tvAddressName.setText(profileAddressesResponseBody.getName());

        holder.addressName = profileAddressesResponseBody.getName();
        holder.objectId = profileAddressesResponseBody.getId();
        radioButtonList.add(holder.rbAddressSearch);
        holder.rlAddressSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < radioButtonList.size(); i++) {
                    radioButtonList.get(i).setChecked(false);
                }
                holder.rbAddressSearch.setChecked(true);
                AddressSearchFragment.addressName = holder.addressName;
                AddressSearchFragment.objectId = holder.objectId;

            }
        });

        holder.rbAddressSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return profileAddressesBodiesList != null ? profileAddressesBodiesList.size() : 0;
    }

    public static class AddressSearchHolder extends RecyclerView.ViewHolder {
        private TextView tvAddressName;
        private RadioButton rbAddressSearch;
        private RelativeLayout rlAddressSearch;
        private String addressName = "";
        private int objectId = 1;

        public AddressSearchHolder(ViewGroup viewGroup) {
            super(viewGroup);
            tvAddressName = viewGroup.findViewById(R.id.tvAddressName);
            rbAddressSearch = viewGroup.findViewById(R.id.rbAddressSearch);
            rlAddressSearch = viewGroup.findViewById(R.id.rlAddressSearch);
        }
    }
}
