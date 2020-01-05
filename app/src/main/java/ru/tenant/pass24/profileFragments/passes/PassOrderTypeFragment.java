package ru.tenant.pass24.profileFragments.passes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.profileFragments.requests.RequestTypeFragment;

public class PassOrderTypeFragment extends Fragment {
    private LinearLayout llSingleUsePass, llPermanentPass;
    private RadioButton rbSingleUse, rbPermanent;
    private Context mContext;
    private ImageButton btnBack;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_order_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = this.getContext();
        init(view);
    }

    private void init(View view) {
        llSingleUsePass = view.findViewById(R.id.llSingleUsePass);
        llPermanentPass = view.findViewById(R.id.llPermanentPass);
        rbSingleUse = view.findViewById(R.id.rbSingleUse);
        rbPermanent = view.findViewById(R.id.rbPermanent);
        btnBack = view.findViewById(R.id.btnBack);
        rbSingleUse.setChecked(true);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderVehicleFragment();
            }
        });

        rbPermanent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        rbSingleUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        llSingleUsePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llSingleUsePass.setBackground(ContextCompat.getDrawable(mContext, R.drawable.checked_rounded_green));
                llPermanentPass.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rounded_type_transport));
                rbSingleUse.setChecked(true);
                rbPermanent.setChecked(false);
            }
        });

        llPermanentPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llPermanentPass.setBackground(ContextCompat.getDrawable(mContext, R.drawable.checked_rounded_green));
                llSingleUsePass.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rounded_type_transport));
                rbSingleUse.setChecked(false);
                rbPermanent.setChecked(true);
            }
        });
    }

    public void toPassOrderVehicleFragment() {
        Bundle bundle = new Bundle();
        if (rbSingleUse.isChecked()) {
            bundle.putInt("passType", Constants.SINGLE_USE_PASS);
            bundle.putString("passName", "Одноразовый");
        } else {
            bundle.putInt("passType", Constants.TEMPORARY_PASS);
            bundle.putString("passName", "Временный");
        }
        PassOrderVehicleFragment passOrderVehicleFragment = PassOrderVehicleFragment.getInstance();
        passOrderVehicleFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, passOrderVehicleFragment)
                .addToBackStack(RequestTypeFragment.TAG)
                .commit();

    }
}
