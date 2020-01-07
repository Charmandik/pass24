package ru.tenant.pass24.profileFragments.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.requests.newAddress.RequestNewAddressFragment;
import ru.tenant.pass24.profileFragments.requests.newConfidance.RequestConfidantFragment;
import ru.tenant.pass24.profileFragments.requests.permanentPass.RequestsPermanentPassFragment;

public class RequestTypeFragment extends Fragment {
    public static String TAG = "RequestTypeFragment";
    private static RequestTypeFragment mInstance;
    private LinearLayout llConfidant, llNewAddress, llPermanentPass;
    private ImageView btnClose;

    private RequestTypeFragment() {
    }

    public static RequestTypeFragment getInstance() {
        if (mInstance == null) {
            mInstance = new RequestTypeFragment();
        }
        return mInstance;
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

    }

    private void init(View view) {
        llConfidant = view.findViewById(R.id.llConfidant);
        llNewAddress = view.findViewById(R.id.llNewAddress);
        llPermanentPass = view.findViewById(R.id.llPermanentPass);
        btnClose = view.findViewById(R.id.btnClose);

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

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRequestsFragment();
            }
        });
    }

    public void toRequestsConfidant() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", TAG);
        RequestConfidantFragment requestConfidantFragment = RequestConfidantFragment.getInstance();
        requestConfidantFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.flRequestsContainer, requestConfidantFragment)
                .addToBackStack(RequestTypeFragment.TAG)
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
                .replace(R.id.flRequestsContainer, RequestsPermanentPassFragment.getInstance())
                .addToBackStack("")
                .commit();
    }

    public void toRequestsFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new RequestsFragment())
                .addToBackStack("")
                .commit();
    }

}
