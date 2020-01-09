package ru.tenant.pass24.profileFragments.passes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.MainActivity;
import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.retrofit.ApiService;
import ru.tenant.pass24.profileFragments.ValidityFragment;
import ru.tenant.pass24.profileFragments.addressSearch.AddressSearchFragment;
import ru.tenant.pass24.profileFragments.passes.apiModels.guestPassCreationModels.GuestData;
import ru.tenant.pass24.profileFragments.passes.apiModels.inviteCreationModels.CreateInviteRequest;
import ru.tenant.pass24.profileFragments.passes.apiModels.inviteCreationModels.CreateInviteResponse;

public class PassOrderInviteFragment extends Fragment {
    public static String TAG = "PassOrderInviteFragment";
    private static PassOrderInviteFragment mInstance;
    private RelativeLayout rlPassInviteAddress, rlPassInviteVisitTime;
    private ImageView backBtn, btnClose;
    private Button btnCreatePass;
    private TextView tvInviteAddress, tvVisitTimeInfo;
    private TextInputEditText tieGuestName, tieInviteComment;
    private String startsAt = "";
    private String expiresAt = "";
    private String addressName = "";
    private int objectId;

    private PassOrderInviteFragment() {
        mInstance = this;
    }

    public static PassOrderInviteFragment getInstance() {
        if (mInstance == null)
            return new PassOrderInviteFragment();
        else return mInstance;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_order_invite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        rlPassInviteAddress = view.findViewById(R.id.rlPassInviteAddress);
        rlPassInviteVisitTime = view.findViewById(R.id.rlPassInviteVisitTime);
        backBtn = view.findViewById(R.id.backBtn);
        btnClose = view.findViewById(R.id.btnClose);
        btnCreatePass = view.findViewById(R.id.btnCreatePass);
        tvInviteAddress = view.findViewById(R.id.tvInviteAddress);
        tvVisitTimeInfo = view.findViewById(R.id.tvVisitTimeInfo);
        tieGuestName = view.findViewById(R.id.tieGuestName);
        tieInviteComment = view.findViewById(R.id.tieInviteComment);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderFragment();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderFragment();
            }
        });

        btnCreatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createInvite();
            }
        });

        rlPassInviteAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAddressSearchFragment();
            }
        });

        rlPassInviteVisitTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toValidityFragment();
            }
        });

        if (!addressName.equals("")) {
            tvInviteAddress.setText(addressName);
            tvInviteAddress.setVisibility(View.VISIBLE);
        }

        if (!startsAt.equals("")) {
            tvVisitTimeInfo.setText(startsAt + " - " + expiresAt);
            tvVisitTimeInfo.setVisibility(View.VISIBLE);
        }

        if (this.getArguments() != null) {
            if (this.getArguments().getString("addressName") != null) {
                tvInviteAddress.setVisibility(View.VISIBLE);
                tvInviteAddress.setText(this.getArguments().getString("addressName"));
                addressName = this.getArguments().getString("addressName");
                objectId = this.getArguments().getInt("objectId");
            }

            if (this.getArguments().getString("startsAt") != null) {
                tvVisitTimeInfo.setVisibility(View.VISIBLE);
                String data = this.getArguments().getString("startsAt") + " - " + this.getArguments().getString("expiresAt");
                startsAt = this.getArguments().getString("startsAt");
                expiresAt = this.getArguments().getString("expiresAt");
                tvVisitTimeInfo.setText(data);
            }
        }
    }

    private void createInvite() {
        CreateInviteRequest createInviteRequest = new CreateInviteRequest();
        createInviteRequest.setAddressId(objectId);
        createInviteRequest.setStartsAt(startsAt);
        createInviteRequest.setExpiresAt(expiresAt);
        createInviteRequest.setDurationType(1);
        createInviteRequest.setGuestType(2);
        GuestData guestData = new GuestData();
        guestData.setName(tieGuestName.getText().toString());
        createInviteRequest.setGuestData(guestData);
        createInviteRequest.setComment(tieInviteComment.getText().toString());
        createInviteRequest.setOptions(new ArrayList());
        ApiService.getInstance().getPassesApi().createInvite(Constants.getAuthToken(), createInviteRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CreateInviteResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CreateInviteResponse createInviteResponse) {
                        if (createInviteResponse != null)
                            if (createInviteResponse.getBody() != null)
                                toPassCreatedFragment();
                            else if (createInviteResponse.getError() != null)
                                if (createInviteResponse.getError().getCode() != null)
                                    if (createInviteResponse.getError().getCode().equals("UNAUTHENTICATED"))
                                        toLogin();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void toAddressSearchFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderInviteFragment.TAG);
        AddressSearchFragment addressSearchFragment = new AddressSearchFragment();
        addressSearchFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, addressSearchFragment)
                .addToBackStack("")
                .commit();
    }

    public void toValidityFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderInviteFragment.TAG);
        ValidityFragment validityFragment = new ValidityFragment();
        validityFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, validityFragment)
                .addToBackStack("")
                .commit();
    }

    public void toPassOrderFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new PassOrderFragment())
                .addToBackStack("asd")
                .commit();
    }

    public void toPassCreatedFragment() {
        if (getFragmentManager() != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flPassesContainer, new PassCreatedFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void toLogin() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.putExtra("toLogin", true);
        this.startActivity(intent);
        if (this.getActivity() != null)
            this.getActivity().finish();
    }
}
