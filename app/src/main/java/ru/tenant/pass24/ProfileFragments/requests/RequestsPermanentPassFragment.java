package ru.tenant.pass24.ProfileFragments.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.ProfileFragments.VehicleBrand.VehicleBrandFragment;
import ru.tenant.pass24.ProfileFragments.addressSearch.AddressSearchFragment;
import ru.tenant.pass24.R;

public class RequestsPermanentPassFragment extends Fragment {
    private ConstraintLayout clBrandField, clCarTypeField, clAddressField;
    private ImageView backBtn, btnClose;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_vehicle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        clBrandField = view.findViewById(R.id.clBrandField);
        clCarTypeField = view.findViewById(R.id.clCarTypeField);
        clAddressField = view.findViewById(R.id.clAddressField);
        backBtn = view.findViewById(R.id.btnBack);
        btnClose = view.findViewById(R.id.btnClose);

        clBrandField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toVehicleBrand();
            }
        });

        clCarTypeField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toVehicleType();
            }
        });

        clAddressField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAddressSearch();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRequestType();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRequestType();
            }
        });
    }

    public void toAddressSearch() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new AddressSearchFragment())
                .addToBackStack("")
                .commit();
    }

    public void toVehicleBrand() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new VehicleBrandFragment())
                .addToBackStack("")
                .commit();
    }

    public void toVehicleType() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new RequestVehicleTypeFragment())
                .addToBackStack("")
                .commit();
    }

    public void toRequestType() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, RequestTypeFragment.getInstance())
                .addToBackStack("")
                .commit();
    }
}
