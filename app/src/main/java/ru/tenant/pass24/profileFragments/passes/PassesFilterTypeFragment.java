package ru.tenant.pass24.profileFragments.passes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;

public class PassesFilterTypeFragment extends Fragment {
    private LinearLayout llAll, llOpen, llAccept, llReject;
    private CheckBox cbAll, cbOpen, cbAccept, cbReject;
    private ImageButton btnBack;
    private ImageView btnClose;
    private PassesFilterTypeFragment mInstance;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_filter_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInstance = this;
        init(view);
    }

    private void init(View view) {
        llAll = view.findViewById(R.id.llAllStatusRequest);
        llOpen = view.findViewById(R.id.llOpenStatusRequest);
        llAccept = view.findViewById(R.id.llAcceptStatusRequest);
        llReject = view.findViewById(R.id.llEntityDeleted);

        cbAll = view.findViewById(R.id.cbAllStatus);
        cbOpen = view.findViewById(R.id.cbOpenStatus);
        cbAccept = view.findViewById(R.id.cbAcceptStatus);
        cbReject = view.findViewById(R.id.cbEntityDeleted);

        btnBack = view.findViewById(R.id.btnBack);
        btnClose = view.findViewById(R.id.btnClose);
        llAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbAll.setChecked(true);
                Constants.requestTypeFilter = null;
            }
        });

        llOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbOpen.setChecked(true);
                Constants.requestTypeFilter = 1;
            }
        });

        llAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbAccept.setChecked(true);
                Constants.requestTypeFilter = 2;
            }
        });

        llReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbReject.setChecked(true);
                Constants.requestTypeFilter = 3;
            }
        });

        cbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbAll.setChecked(true);
                Constants.requestTypeFilter = null;
            }
        });

        cbOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbOpen.setChecked(true);
                Constants.requestTypeFilter = 1;
            }
        });

        cbAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbAccept.setChecked(true);
                Constants.requestTypeFilter = 2;
            }
        });

        cbReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cbReject.setChecked(true);
                Constants.requestTypeFilter = 3;
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInstance.getArguments() != null)
                    if (Objects.requireNonNull(mInstance.getArguments().getString("fragment")).equals(PassesFilterFragment.TAG))
                        toRequestsFilter();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInstance.getArguments() != null)
                    if (Objects.requireNonNull(mInstance.getArguments().getString("fragment")).equals(PassesFilterFragment.TAG))
                        toRequestsFilter();
            }
        });

        setFalseToAll();
        if (Constants.requestTypeFilter != null)
            switch (Constants.requestTypeFilter) {
                case (1):
                    cbOpen.setChecked(true);
                    break;
                case (2):
                    cbAccept.setChecked(true);
                    break;
                case (3):
                    cbReject.setChecked(true);
                    break;
            }
        else
            cbAll.setChecked(true);

        Log.d("tag", "typeFilter=" + Constants.requestTypeFilter);
    }

    private void setFalseToAll() {
        cbAll.setChecked(false);
        cbOpen.setChecked(false);
        cbAccept.setChecked(false);
        cbReject.setChecked(false);
    }


    public void toRequestsFilter() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new PassesFilterFragment())
                .addToBackStack("")
                .commit();
    }
}
