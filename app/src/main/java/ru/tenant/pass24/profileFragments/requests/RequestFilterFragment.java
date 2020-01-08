package ru.tenant.pass24.profileFragments.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;

public class RequestFilterFragment extends Fragment {
    public static String TAG = "PassesFilterStatusFragment";
    private ImageView btnBack, btnClose;
    private RelativeLayout rlRequestStatusFilter, rlFilterType;
    private TextView tvRequestStatusFilter, tvRequestTypeFilter, tvResetFilter;

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
        rlFilterType = view.findViewById(R.id.rlFilterType);
        btnBack = view.findViewById(R.id.btnBack);
        btnClose = view.findViewById(R.id.btnClose);
        tvRequestStatusFilter = view.findViewById(R.id.tvRequestStatusFilter);
        tvRequestTypeFilter = view.findViewById(R.id.tvRequestTypeFilter);
        tvResetFilter = view.findViewById(R.id.tvResetFilter);

        if (Constants.requestTypeFilter != null)
            switch (Constants.requestTypeFilter) {
                case (1):
                    tvRequestTypeFilter.setText("На присоединение к объекту");
                    break;
                case (2):
                    tvRequestTypeFilter.setText("На новый пропуск");
                    break;
                case (3):
                    tvRequestTypeFilter.setText("На доверенность");
                    break;
            }
        else
            tvRequestTypeFilter.setText("Все");

        if (Constants.requestStatusFilter != null)
            switch (Constants.requestStatusFilter) {
                case (1):
                    tvRequestStatusFilter.setText("Открытые");
                    break;
                case (2):
                    tvRequestStatusFilter.setText("Подтвержденные");
                    break;
                case (3):
                    tvRequestStatusFilter.setText("Отклоненные");
                    break;
            }
        else
            tvRequestStatusFilter.setText("Все");


        rlRequestStatusFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRequestFilterStatusFragment();
            }
        });

        rlFilterType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRequestFilterTypeFragment();
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRequestsFragment();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRequestsFragment();
            }
        });

        tvResetFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.requestStatusFilter = null;
                Constants.requestTypeFilter = null;
                tvRequestStatusFilter.setText("Все");
                tvRequestTypeFilter.setText("Все");
            }
        });
    }

    public void toRequestFilterStatusFragment() {
        RequestFilterStatusFragment requestFilterStatusFragment = new RequestFilterStatusFragment();
        Bundle bundle = new Bundle();
        bundle.putString("fragment", TAG);
        requestFilterStatusFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, requestFilterStatusFragment)
                .addToBackStack("")
                .commit();
    }

    public void toRequestFilterTypeFragment() {
        RequestFilterTypeFragment requestFilterTypeFragment = new RequestFilterTypeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("fragment", TAG);
        requestFilterTypeFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, requestFilterTypeFragment)
                .addToBackStack("")
                .commit();
    }

    public void toRequestsFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new RequestsFragment())
                .addToBackStack(RequestTypeFragment.TAG)
                .commit();
    }
}
