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
import android.widget.Toast;

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
import ru.tenant.pass24.profileFragments.passes.apiModels.guestPassCreationModels.CreateGuestPassRequest;
import ru.tenant.pass24.profileFragments.passes.apiModels.guestPassCreationModels.GuestData;
import ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels.CreateVehiclePassResponse;

public class PassOrderGuestFragment extends Fragment {
    public static String TAG = "PassOrderGuestFragment";
    private static PassOrderGuestFragment mInstance;
    private RelativeLayout rlPassGuestVisitTime, rlPassGuestAddress;
    private ImageView backBtn, btnClose;
    private Button btnCreatePass;
    private TextView tvGuestPassAddress, tvVisitTimeInfo;
    private TextInputEditText tieGuestPassComment, tieGuestPassName;
    private String startsAt = "";
    private String expiresAt = "";
    private String addressName = "";
    private int objectId;

    private PassOrderGuestFragment() {
        mInstance = this;
    }

    public static PassOrderGuestFragment getInstance() {
        if (mInstance == null)
            return new PassOrderGuestFragment();
        else
            return mInstance;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_order_guest, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
    }

    private void init(View view) {
        rlPassGuestVisitTime = view.findViewById(R.id.rlPassGuestVisitTime);
        rlPassGuestAddress = view.findViewById(R.id.rlPassGuestAddress);
        backBtn = view.findViewById(R.id.backBtn);
        btnClose = view.findViewById(R.id.btnClose);
        btnCreatePass = view.findViewById(R.id.btnCreatePass);
        tvGuestPassAddress = view.findViewById(R.id.tvGuestPassAddress);
        tvVisitTimeInfo = view.findViewById(R.id.tvVisitTimeInfo);
        tieGuestPassComment = view.findViewById(R.id.tieGuestPassComment);
        tieGuestPassName = view.findViewById(R.id.tieGuestPassName);


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

        rlPassGuestVisitTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toValidityFragment();
            }
        });

        rlPassGuestAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAddressSearchFragment();
            }
        });

        btnCreatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createGuestPass();
            }
        });

        if (!addressName.equals("")) {
            tvGuestPassAddress.setText(addressName);
            tvGuestPassAddress.setVisibility(View.VISIBLE);
        }

        if (!startsAt.equals("")) {
            tvVisitTimeInfo.setText(startsAt + " - " + expiresAt);
            tvVisitTimeInfo.setVisibility(View.VISIBLE);
        }

        if (this.getArguments() != null) {
            if (this.getArguments().getString("addressName") != null) {
                tvGuestPassAddress.setVisibility(View.VISIBLE);
                tvGuestPassAddress.setText(this.getArguments().getString("addressName"));
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

    private void createGuestPass() {
        CreateGuestPassRequest createGuestPassRequest = new CreateGuestPassRequest();
        createGuestPassRequest.setAddressId(objectId);
        createGuestPassRequest.setStartsAt(startsAt);
        createGuestPassRequest.setExpiresAt(expiresAt);
        createGuestPassRequest.setDurationType(2);
        createGuestPassRequest.setGuestType(2);
        GuestData guestData = new GuestData();
        guestData.setName(tieGuestPassName.getText().toString().trim());
        createGuestPassRequest.setGuestData(guestData);
        createGuestPassRequest.setComment(tieGuestPassComment.getText().toString().trim());
        createGuestPassRequest.setOptions(new ArrayList());
        ApiService.getInstance().getPassesApi().createGuestPass(Constants.getAuthToken(), createGuestPassRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CreateVehiclePassResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CreateVehiclePassResponse createVehiclePassResponse) {
                        if (createVehiclePassResponse != null)
                            if (createVehiclePassResponse.getBody() != null)
                                toPassCreatedFragment();
                            else if (createVehiclePassResponse.getError() != null)
                                if (createVehiclePassResponse.getError().getCode() != null)
                                    if (createVehiclePassResponse.getError().getCode().equals("UNAUTHENTICATED"))
                                        toLogin();
                                    else {
                                        Toast.makeText(mInstance.getContext(), createVehiclePassResponse.getError().getCode(), android.widget.Toast.LENGTH_LONG).show();
                                    }
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
        bundle.putString("fragment", PassOrderGuestFragment.TAG);
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
        bundle.putString("fragment", PassOrderGuestFragment.TAG);
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
