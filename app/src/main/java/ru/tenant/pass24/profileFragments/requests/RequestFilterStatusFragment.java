package ru.tenant.pass24.profileFragments.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class RequestFilterStatusFragment extends Fragment {
    private LinearLayout llAll, llOpen, llAccept, llReject;
    private CheckBox cbAll, cbOpen, cbAccept, cbReject;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_filter_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        llAll = view.findViewById(R.id.llAllStatusRequest);
        llOpen = view.findViewById(R.id.llOpenStatusRequest);
        llAccept = view.findViewById(R.id.llAcceptStatusRequest);
        llReject = view.findViewById(R.id.llRejectStatusRequest);

        cbAll = view.findViewById(R.id.cbAllStatus);
        cbOpen = view.findViewById(R.id.cbOpenStatus);
        cbAccept = view.findViewById(R.id.cbAcceptStatus);
        cbReject = view.findViewById(R.id.cbRejectStatus);

        llAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbAll.setChecked(true);
                cbOpen.setChecked(false);
                cbAccept.setChecked(false);
                cbReject.setChecked(false);
            }
        });

        llOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbAll.setChecked(false);
                cbOpen.setChecked(true);
                cbAccept.setChecked(false);
                cbReject.setChecked(false);
            }
        });

        llAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbAll.setChecked(false);
                cbOpen.setChecked(false);
                cbAccept.setChecked(true);
                cbReject.setChecked(false);
            }
        });

        llReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbAll.setChecked(false);
                cbOpen.setChecked(false);
                cbAccept.setChecked(false);
                cbReject.setChecked(true);
            }
        });

        cbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbAll.setChecked(true);
                cbOpen.setChecked(false);
                cbAccept.setChecked(false);
                cbReject.setChecked(false);
            }
        });

        cbOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbAll.setChecked(false);
                cbOpen.setChecked(true);
                cbAccept.setChecked(false);
                cbReject.setChecked(false);
            }
        });

        cbAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbAll.setChecked(false);
                cbOpen.setChecked(false);
                cbAccept.setChecked(true);
                cbReject.setChecked(false);
            }
        });

        cbReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbAll.setChecked(false);
                cbOpen.setChecked(false);
                cbAccept.setChecked(false);
                cbReject.setChecked(true);
            }
        });

    }
}
