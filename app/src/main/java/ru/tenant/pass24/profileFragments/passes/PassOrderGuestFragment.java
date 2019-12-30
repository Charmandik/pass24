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

public class PassOrderGuestFragment extends Fragment {
    private RelativeLayout rlPassGuestVisitTime, rlPassGuestAddress;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_order_guest, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        rlPassGuestVisitTime = view.findViewById(R.id.rlPassGuestVisitTime);
        rlPassGuestAddress = view.findViewById(R.id.rlPassGuestAddress);

        rlPassGuestVisitTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toValidityFragment();
            }
        });

        rlPassGuestAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAddressSearchFragment();
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
                .addToBackStack(null)
                .commit();
    }

}
