package ru.tenant.pass24.ProfileFragments.passes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.ProfileFragments.AddressSearchFragment;
import ru.tenant.pass24.ProfileFragments.ValidityFragment;
import ru.tenant.pass24.ProfileFragments.VehicleBrand.VehicleBrandFragment;
import ru.tenant.pass24.R;

public class PassOrderVehicleFragment extends Fragment {
    private RelativeLayout rlPassOrderAddress, rlPassOrderType, rlPassOrderVehicleBrand, rlPassOrderVehicleType, rlPassOrderVisitTime;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_order_vehicle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        rlPassOrderAddress = view.findViewById(R.id.rlPassOrderAddress);
        rlPassOrderType = view.findViewById(R.id.rlPassOrderType);
        rlPassOrderVehicleBrand = view.findViewById(R.id.rlPassOrderVehicleBrand);
        rlPassOrderVehicleType = view.findViewById(R.id.rlPassOrderVehicleType);
        rlPassOrderVisitTime = view.findViewById(R.id.rlPassOrderVisitTime);

        rlPassOrderAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAddressSearchFragment();
            }
        });

        rlPassOrderType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderTypeFragment();
            }
        });

        rlPassOrderVehicleBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toVehicleBrandFragment();
            }
        });

        rlPassOrderVehicleType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderVehicleTypeFragment();
            }
        });

        rlPassOrderVisitTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toValidityFragment();
            }
        });
    }


    public void toAddressSearchFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new AddressSearchFragment())
                .addToBackStack("")
                .commit();
    }

    public void toPassOrderTypeFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new PassOrderTypeFragment())
                .addToBackStack("")
                .commit();
    }

    public void toVehicleBrandFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new VehicleBrandFragment())
                .addToBackStack("")
                .commit();
    }

    public void toPassOrderVehicleTypeFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new PassOrderVehicleTypeFragment())
                .addToBackStack("")
                .commit();
    }

    public void toValidityFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new ValidityFragment())
                .addToBackStack("")
                .commit();
    }
}
