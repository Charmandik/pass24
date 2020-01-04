package ru.tenant.pass24.profileFragments.passes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.ValidityFragment;
import ru.tenant.pass24.profileFragments.addressSearch.AddressSearchFragment;
import ru.tenant.pass24.profileFragments.vehicleBrand.VehicleBrandFragment;

public class PassOrderVehicleFragment extends Fragment {
    public static String TAG = "PassOrderVehicleFragment";
    private RelativeLayout rlPassOrderAddress, rlPassOrderType, rlPassOrderVehicleBrand, rlPassOrderVehicleType, rlPassOrderVisitTime;
    private static PassOrderVehicleFragment mInstance;

    private PassOrderVehicleFragment() {
        mInstance = this;
    }

    public static PassOrderVehicleFragment getInstance() {
        if (mInstance == null) {
            return new PassOrderVehicleFragment();
        } else return mInstance;
    }

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
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderVehicleFragment.TAG);
        AddressSearchFragment addressSearchFragment = new AddressSearchFragment();
        addressSearchFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, addressSearchFragment)
                .addToBackStack("")
                .commit();
    }

    public void toPassOrderTypeFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderVehicleFragment.TAG);
        PassOrderTypeFragment passOrderTypeFragment = new PassOrderTypeFragment();
        passOrderTypeFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, passOrderTypeFragment)
                .addToBackStack("")
                .commit();
    }

    public void toVehicleBrandFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderVehicleFragment.TAG);
        VehicleBrandFragment vehicleBrandFragment = new VehicleBrandFragment();
        vehicleBrandFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, vehicleBrandFragment)
                .addToBackStack("")
                .commit();
    }

    public void toPassOrderVehicleTypeFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderVehicleFragment.TAG);
        PassOrderVehicleTypeFragment passOrderVehicleTypeFragment = new PassOrderVehicleTypeFragment();
        passOrderVehicleTypeFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, passOrderVehicleTypeFragment)
                .addToBackStack("")
                .commit();
    }

    public void toValidityFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderVehicleFragment.TAG);
        ValidityFragment validityFragment = new ValidityFragment();
        validityFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, validityFragment)
                .addToBackStack("")
                .commit();
    }
}
