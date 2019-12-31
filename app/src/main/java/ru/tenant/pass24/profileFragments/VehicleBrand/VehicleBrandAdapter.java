package ru.tenant.pass24.profileFragments.VehicleBrand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.VehicleBrand.apiModels.VehicleBrandCollection;

public class VehicleBrandAdapter extends RecyclerView.Adapter<VehicleBrandAdapter.VehicleBrandHolder> {
    private FragmentManager fragmentManager;
    private List<VehicleBrandCollection> vehicleBrandCollectionList;
    private List<RadioButton> radioButtonList = new ArrayList();

    public VehicleBrandAdapter(List<VehicleBrandCollection> vehicleBrandCollections, FragmentManager fragmentManager) {
        this.vehicleBrandCollectionList = vehicleBrandCollections;
        this.fragmentManager = fragmentManager;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VehicleBrandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_vehicle_model, parent, false);
        return new VehicleBrandHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull final VehicleBrandHolder holder, int position) {
        VehicleBrandCollection vehicleBrandCollection = vehicleBrandCollectionList.get(position);
        if (vehicleBrandCollection != null)
            if (vehicleBrandCollection.getName() != null) {
                holder.tvModelName.setText(vehicleBrandCollection.getName());
                radioButtonList.add(holder.rbVehicleModel);
                holder.rbVehicleModel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for (int i = 0; i < radioButtonList.size(); i++) {
                            radioButtonList.get(i).setChecked(false);
                        }

                        for (int i = 0; i < radioButtonList.size(); i++) {
                            if (radioButtonList.get(i).isChecked() && radioButtonList.get(i) != holder.rbVehicleModel)
                                radioButtonList.get(i).setChecked(false);
                        }
                        holder.rbVehicleModel.setChecked(true);
                    }
                });
                holder.rlVehicleBrand.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for (int i = 0; i < radioButtonList.size(); i++) {
                            radioButtonList.get(i).setChecked(false);
                        }
                        holder.rbVehicleModel.setChecked(true);
                        VehicleBrandFragment.vehicleBrand = holder.tvModelName.getText().toString();
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return vehicleBrandCollectionList != null ? vehicleBrandCollectionList.size() : 0;
    }

    public static class VehicleBrandHolder extends RecyclerView.ViewHolder {
        private TextView tvModelName;
        private RadioButton rbVehicleModel;
        private RelativeLayout rlVehicleBrand;

        public VehicleBrandHolder(ViewGroup viewGroup) {
            super(viewGroup);
            tvModelName = viewGroup.findViewById(R.id.tvModelName);
            rbVehicleModel = viewGroup.findViewById(R.id.rbVehicleModel);
            rlVehicleBrand = viewGroup.findViewById(R.id.rlVehicleBrand);
        }
    }
}
