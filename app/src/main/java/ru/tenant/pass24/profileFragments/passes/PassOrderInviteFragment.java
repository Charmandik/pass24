package ru.tenant.pass24.profileFragments.passes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.ValidityFragment;
import ru.tenant.pass24.profileFragments.addressSearch.AddressSearchFragment;

public class PassOrderInviteFragment extends Fragment {
    public static String TAG = "PassOrderInviteFragment";
    private RelativeLayout rlPassInviteAddress, rlPassInviteVisitTime;
    private ImageButton backBtn, closeBtn;

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
        backBtn = view.findViewById(R.id.backBtn);
        closeBtn = view.findViewById(R.id.closeBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderFragment();
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderFragment();
            }
        });

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
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderInviteFragment.TAG);
        AddressSearchFragment addressSearchFragment = new AddressSearchFragment();
        addressSearchFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, addressSearchFragment)
                .addToBackStack("")
                .commit();
    }

    public void toValidityFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderInviteFragment.TAG);
        ValidityFragment validityFragment = new ValidityFragment();
        validityFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, validityFragment)
                .addToBackStack("")
                .commit();
    }

    public void toPassOrderFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new PassOrderFragment())
                .addToBackStack("asd")
                .commit();
    }
}
