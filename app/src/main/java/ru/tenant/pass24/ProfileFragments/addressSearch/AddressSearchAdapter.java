package ru.tenant.pass24.ProfileFragments.addressSearch;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.tenant.pass24.ProfileFragments.addressSearch.apiModels.ProfileAddressesResponseBody;
import ru.tenant.pass24.R;

public class AddressSearchAdapter extends RecyclerView.Adapter<AddressSearchAdapter.AddressSearchHolder> {
    private FragmentManager fragmentManager;
    private List<ProfileAddressesResponseBody> profileAddressesBodiesList;
    private List<RadioButton> radioButtonList = new ArrayList();

    public AddressSearchAdapter(List<ProfileAddressesResponseBody> profileAddressesBodiesList, FragmentManager fragmentManager) {
        this.profileAddressesBodiesList = profileAddressesBodiesList;
        this.fragmentManager = fragmentManager;
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

    }

    @Override
    public int getItemCount() {
        return profileAddressesBodiesList != null ? profileAddressesBodiesList.size() : 0;
    }

    public static class AddressSearchHolder extends RecyclerView.ViewHolder {
        private TextView tvModelName;
        private RadioButton rbVehicleModel;
        private RelativeLayout rlVehicleBrand;

        public AddressSearchHolder(ViewGroup viewGroup) {
            super(viewGroup);
            tvModelName = viewGroup.findViewById(R.id.tvModelName);
            rbVehicleModel = viewGroup.findViewById(R.id.rbVehicleModel);
            rlVehicleBrand = viewGroup.findViewById(R.id.rlVehicleBrand);
        }
    }
}
