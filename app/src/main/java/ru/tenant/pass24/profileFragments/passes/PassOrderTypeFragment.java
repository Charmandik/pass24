package ru.tenant.pass24.profileFragments.passes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class PassOrderTypeFragment extends Fragment {
    private LinearLayout llSingleUsePass, llPermanentPass;
    private RadioButton rbSingleUse, rbPermanent;
    private Context mContext;

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

    public void toPassOrderFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new PassOrderFragment())
                .addToBackStack(null)
                .commit();
    }
}
