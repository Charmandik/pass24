package ru.tenant.pass24.ProfileFragments.passes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.ProfileFragments.requests.RequestConfidantFragment;
import ru.tenant.pass24.R;

public class PassOrderFragment extends Fragment {
    private LinearLayout llVehiclePass, llGuestPass, llInvitePass;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        llVehiclePass = view.findViewById(R.id.llVehiclePass);
        llGuestPass = view.findViewById(R.id.llGuestPass);
        llInvitePass = view.findViewById(R.id.llInvitePass);

        llVehiclePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderVehicleFragment();
            }
        });

        llGuestPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderGuestFragment();
            }
        });

        llInvitePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderInviteFragment();
            }
        });
    }

    public void toPassOrderVehicleFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new PassOrderVehicleFragment())
                .addToBackStack("asd")
                .commit();
    }

    public void toPassOrderGuestFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new PassOrderGuestFragment())
                .addToBackStack("asd")
                .commit();
    }

    public void toPassOrderInviteFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new PassOrderInviteFragment())
                .addToBackStack("asd")
                .commit();
    }
}
