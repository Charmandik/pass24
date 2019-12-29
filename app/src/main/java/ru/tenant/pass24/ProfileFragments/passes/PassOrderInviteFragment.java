package ru.tenant.pass24.ProfileFragments.passes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.ProfileFragments.addressSearch.AddressSearchFragment;
import ru.tenant.pass24.ProfileFragments.ValidityFragment;
import ru.tenant.pass24.R;

public class PassOrderInviteFragment extends Fragment {
    private RelativeLayout rlPassInviteAddress, rlPassInviteVisitTime;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_order_invite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        rlPassInviteAddress = view.findViewById(R.id.rlPassInviteAddress);
        rlPassInviteVisitTime = view.findViewById(R.id.rlPassInviteVisitTime);

        rlPassInviteAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAddressSearchFragment();
            }
        });

        rlPassInviteVisitTime.setOnClickListener(new View.OnClickListener() {
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

    public void toValidityFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new ValidityFragment())
                .addToBackStack("")
                .commit();
    }
}
