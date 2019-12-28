package ru.tenant.pass24.ProfileFragments.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class RequestTypeFragment extends Fragment {
    private LinearLayout llConfidant, llNewAddress, llPermanentPass;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        llConfidant = view.findViewById(R.id.llConfidant);
        llNewAddress = view.findViewById(R.id.llNewAddress);
        llPermanentPass = view.findViewById(R.id.llPermanentPass);

        llConfidant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRequestsConfidant();
            }
        });

        llNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRequestNewAddress();
            }
        });

        llPermanentPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRequestPermanentPass();
            }
        });
    }

    public void toRequestsConfidant() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new RequestConfidantFragment())
                .addToBackStack("")
                .commit();
    }

    public void toRequestNewAddress() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new RequestNewAddressFragment())
                .addToBackStack("")
                .commit();
    }

    public void toRequestPermanentPass() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new RequestsPermanentPassFragment())
                .addToBackStack("")
                .commit();
    }

    private void init(View view) {

    }
}
