package ru.tenant.pass24.profileFragments.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class RequestFilterFragment extends Fragment {
    private ImageView btnBack, btnClose;
    private RelativeLayout rlRequestStatusFilter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_filter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        rlRequestStatusFilter = view.findViewById(R.id.rlRequestStatusFilter);
        btnBack = view.findViewById(R.id.btnBack);
        btnClose = view.findViewById(R.id.btnClose);
        rlRequestStatusFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRequestFilterStatusFragment();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRequestType();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRequestType();
            }
        });
    }

    public void toRequestFilterStatusFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new RequestFilterStatusFragment())
                .addToBackStack("")
                .commit();
    }

    public void toRequestType() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, RequestTypeFragment.getInstance())
                .addToBackStack(RequestTypeFragment.TAG)
                .commit();
    }
}
