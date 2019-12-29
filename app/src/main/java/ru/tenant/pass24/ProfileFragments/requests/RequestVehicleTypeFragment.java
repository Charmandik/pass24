package ru.tenant.pass24.ProfileFragments.requests;

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

public class RequestVehicleTypeFragment extends Fragment {
    private LinearLayout llCar, llTruck, llBigTruck, llAnotherTruck;
    private RadioButton rbCar, rbTruck, rbBigTruck, rbAnotherType;
    private Context mContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_vehicle_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = this.getContext();
        init(view);
    }

    private void init(View view) {
        llCar = view.findViewById(R.id.llCar);
        llTruck = view.findViewById(R.id.llTruck);
        llBigTruck = view.findViewById(R.id.llBigTruck);
        llAnotherTruck = view.findViewById(R.id.llAnotherTruck);

        rbCar = view.findViewById(R.id.rbCar);
        rbTruck = view.findViewById(R.id.rbTruck);
        rbBigTruck = view.findViewById(R.id.rbBigTruck);
        rbAnotherType = view.findViewById(R.id.rbAnotherType);

        llCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutRounded(llCar);
                llCar.setBackground(ContextCompat.getDrawable(mContext, R.drawable.checked_rounded_green));
                setRadioButtonChecked(rbCar);
                rbCar.setChecked(true);
            }
        });

        llTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutRounded(llTruck);
                llTruck.setBackground(ContextCompat.getDrawable(mContext, R.drawable.checked_rounded_green));
                setRadioButtonChecked(rbTruck);
                rbTruck.setChecked(true);
            }
        });

        llBigTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutRounded(llBigTruck);
                llBigTruck.setBackground(ContextCompat.getDrawable(mContext, R.drawable.checked_rounded_green));
                setRadioButtonChecked(rbBigTruck);
                rbBigTruck.setChecked(true);
            }
        });

        llAnotherTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutRounded(llAnotherTruck);
                llAnotherTruck.setBackground(ContextCompat.getDrawable(mContext, R.drawable.checked_rounded_green));
                setRadioButtonChecked(rbAnotherType);
                rbAnotherType.setChecked(true);
            }
        });

        rbCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutRounded(llCar);
                llCar.setBackground(ContextCompat.getDrawable(mContext, R.drawable.checked_rounded_green));
                setRadioButtonChecked(rbCar);
                rbCar.setChecked(true);
            }
        });

        rbTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutRounded(llTruck);
                llTruck.setBackground(ContextCompat.getDrawable(mContext, R.drawable.checked_rounded_green));
                setRadioButtonChecked(rbTruck);
                rbTruck.setChecked(true);
            }
        });

        rbBigTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutRounded(llBigTruck);
                llBigTruck.setBackground(ContextCompat.getDrawable(mContext, R.drawable.checked_rounded_green));
                setRadioButtonChecked(rbBigTruck);
                rbBigTruck.setChecked(true);
            }
        });

        rbAnotherType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutRounded(llAnotherTruck);
                llAnotherTruck.setBackground(ContextCompat.getDrawable(mContext, R.drawable.checked_rounded_green));
                setRadioButtonChecked(rbAnotherType);
                rbAnotherType.setChecked(true);
            }
        });
    }

    private void setRadioButtonChecked(RadioButton radioButton) {
        if (radioButton != rbCar)
            rbCar.setChecked(false);
        if (radioButton != rbTruck)
            rbTruck.setChecked(false);
        if (radioButton != rbBigTruck)
            rbBigTruck.setChecked(false);
        if (radioButton != rbAnotherType)
            rbAnotherType.setChecked(false);
    }

    private void setLayoutRounded(LinearLayout layoutRounded) {
        if (layoutRounded != llCar)
            llCar.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rounded_type_transport));
        if (layoutRounded != llTruck)
            llTruck.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rounded_type_transport));
        if (layoutRounded != llBigTruck)
            llBigTruck.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rounded_type_transport));
        if (layoutRounded != llAnotherTruck)
            llAnotherTruck.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rounded_type_transport));
    }
}
