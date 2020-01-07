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
                setFalseToAll();
                cbAll.setChecked(true);
            }
        });

        llOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbOpen.setChecked(true);
            }
        });

        llAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbAccept.setChecked(true);
            }
        });

        llReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbReject.setChecked(true);
            }
        });

        cbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbAll.setChecked(true);
            }
        });

        cbOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbOpen.setChecked(true);
            }
        });

        cbAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbAccept.setChecked(true);
            }
        });

        cbReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbReject.setChecked(true);
            }
        });
    }

    private void setFalseToAll() {
        cbAll.setChecked(false);
        cbOpen.setChecked(false);
        cbAccept.setChecked(false);
        cbReject.setChecked(false);
    }
}
