package ru.tenant.pass24.ProfileFragments.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class RequestConfidantFragment extends Fragment {

    private RelativeLayout rlRequestConfidantAddress, rlRequestConfidantValidity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_confidant, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    public void toRequestsAdd() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new RequestTypeFragment())
                .addToBackStack("")
                .commit();
    }

    private void init(View view) {
        rlRequestConfidantAddress = view.findViewById(R.id.rlRequestConfidantAddress);
        rlRequestConfidantValidity = view.findViewById(R.id.rlRequestConfidantValidity);

        rlRequestConfidantAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        rlRequestConfidantValidity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
