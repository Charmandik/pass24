package ru.tenant.pass24.profileFragments.trustedPeople;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class TrustedPeopleSelected extends Fragment {
    private TextView tvConfidanceName, tvConfidanceAddress, tvConfidancePhone, tvConfidanceDataExpires;
    private LinearLayout llConfidanceEdit, llConfidanceDelete;
    private ImageView ivBackBtn, btnClose;

    private String name, address, startsAt, expiresAt, phone;

    public TrustedPeopleSelected(String name, String addres, String startsAt, String expiresAt, String phone) {
        this.name = name;
        this.address = addres;
        this.startsAt = startsAt;
        this.expiresAt = expiresAt;
        this.phone = phone;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trust_people_selected, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        tvConfidanceName = view.findViewById(R.id.tvConfidanceName);
        tvConfidanceAddress = view.findViewById(R.id.tvConfidanceAddress);
        tvConfidancePhone = view.findViewById(R.id.tvConfidancePhone);
        tvConfidanceDataExpires = view.findViewById(R.id.tvConfidanceDataExpires);
        llConfidanceEdit = view.findViewById(R.id.llConfidanceEdit);
        llConfidanceDelete = view.findViewById(R.id.llConfidanceDelete);
        ivBackBtn = view.findViewById(R.id.ivBackBtn);
        btnClose = view.findViewById(R.id.btnClose);

        tvConfidanceName.setText(name);
        tvConfidanceAddress.setText(address);
        tvConfidancePhone.setText(phone);
        String expiresData = "";
        if (startsAt != null && expiresAt != null && startsAt.length() > 0 && expiresAt.length() > 0)
            expiresData = "c" + startsAt + " до " + expiresAt;
        else {
            if (startsAt != null && startsAt.length() > 0)
                expiresData += "c " + startsAt;
            else if (expiresAt != null && expiresAt.length() > 0)
                expiresData += "до " + expiresAt;
        }
        tvConfidanceDataExpires.setText(expiresData);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTrustedPeople();
            }
        });

        ivBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTrustedPeople();
            }
        });
    }

    private void toTrustedPeople() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flTrustPeopleContainer, new TrustedPeopleFragment())
                .addToBackStack(null)
                .commit();
    }
}
