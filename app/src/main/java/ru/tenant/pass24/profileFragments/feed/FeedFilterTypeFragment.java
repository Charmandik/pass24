package ru.tenant.pass24.profileFragments.feed;

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

import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;

public class FeedFilterTypeFragment extends Fragment {
    private LinearLayout llAllStatusRequest, llOpenStatusRequest, llAcceptStatusRequest, llEntityDeleted, llPassStatusChanged, llTrustmentStatusChanged, llRequestConfirmed, llRequestRejected;
    private CheckBox cbAllStatus, cbOpenStatus, cbAcceptStatus, cbEntityDeleted, cbPassStatusChanged, cbTrustmentStatusChanged, cbRequestConfirmed, cbRequestRejected;
    private ImageButton btnBack;
    private ImageView btnClose;
    private FeedFilterTypeFragment mInstance;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_filter_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInstance = this;
        init(view);
    }

    private void init(View view) {
        btnBack = view.findViewById(R.id.btnBack);
        btnClose = view.findViewById(R.id.btnClose);
        llAllStatusRequest = view.findViewById(R.id.llAllStatusRequest);
        llOpenStatusRequest = view.findViewById(R.id.llOpenStatusRequest);
        llAcceptStatusRequest = view.findViewById(R.id.llAcceptStatusRequest);
        llEntityDeleted = view.findViewById(R.id.llEntityDeleted);
        llPassStatusChanged = view.findViewById(R.id.llPassStatusChanged);
        llTrustmentStatusChanged = view.findViewById(R.id.llTrustmentStatusChanged);
        llRequestConfirmed = view.findViewById(R.id.llRequestConfirmed);
        llRequestRejected = view.findViewById(R.id.llRequestRejected);
        cbAllStatus = view.findViewById(R.id.cbAllStatus);
        cbOpenStatus = view.findViewById(R.id.cbOpenStatus);
        cbAcceptStatus = view.findViewById(R.id.cbAcceptStatus);
        cbEntityDeleted = view.findViewById(R.id.cbEntityDeleted);
        cbPassStatusChanged = view.findViewById(R.id.cbPassStatusChanged);
        cbTrustmentStatusChanged = view.findViewById(R.id.cbTrustmentStatusChanged);
        cbRequestConfirmed = view.findViewById(R.id.cbRequestConfirmed);
        cbRequestRejected = view.findViewById(R.id.cbRequestRejected);
        setClickListeners(llAllStatusRequest, cbAllStatus, null);
        setClickListeners(llOpenStatusRequest, cbOpenStatus, 1);
        setClickListeners(llAcceptStatusRequest, cbAcceptStatus, 2);
        setClickListeners(llEntityDeleted, cbEntityDeleted, 3);
        setClickListeners(llPassStatusChanged, cbPassStatusChanged, 4);
        setClickListeners(llTrustmentStatusChanged, cbTrustmentStatusChanged, 8);
        setClickListeners(llRequestConfirmed, cbRequestConfirmed, 11);
        setClickListeners(llRequestRejected, cbRequestRejected, 12);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toFeedFilter();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toFeedFilter();
            }
        });

        setFalseToAll();
        if (Constants.eventFeedTypeFilter != null)
            switch (Constants.eventFeedTypeFilter) {
                case (1):
                    cbOpenStatus.setChecked(true);
                    break;
                case (2):
                    cbAcceptStatus.setChecked(true);
                    break;
                case (3):
                    cbEntityDeleted.setChecked(true);
                    break;
                case (4):
                    cbPassStatusChanged.setChecked(true);
                    break;
                case (8):
                    cbTrustmentStatusChanged.setChecked(true);
                    break;
                case (11):
                    cbRequestConfirmed.setChecked(true);
                    break;
                case (12):
                    cbRequestRejected.setChecked(true);
                    break;
            }
        else
            cbAllStatus.setChecked(true);

        Log.d("tag", "typeFilter=" + Constants.requestTypeFilter);
    }

    private void setClickListeners(LinearLayout ll, final CheckBox cb, final Integer type) {
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFalseToAll();
                cb.setChecked(true);
                Constants.eventFeedTypeFilter = type;
                Log.d("tag", Constants.eventFeedTypeFilter + " type");
            }
        };
        ll.setOnClickListener(clickListener);
        cb.setOnClickListener(clickListener);
    }

    private void setFalseToAll() {
        cbAllStatus.setChecked(false);
        cbOpenStatus.setChecked(false);
        cbAcceptStatus.setChecked(false);
        cbEntityDeleted.setChecked(false);
        cbPassStatusChanged.setChecked(false);
        cbTrustmentStatusChanged.setChecked(false);
        cbRequestConfirmed.setChecked(false);
        cbRequestRejected.setChecked(false);
    }


    public void toFeedFilter() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flFeedContainer, new FeedFilter())
                .addToBackStack("")
                .commit();
    }
}
