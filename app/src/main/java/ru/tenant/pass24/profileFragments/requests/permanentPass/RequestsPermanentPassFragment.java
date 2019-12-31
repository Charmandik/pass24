package ru.tenant.pass24.profileFragments.requests.permanentPass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.Retrofit.ApiService;
import ru.tenant.pass24.profileFragments.VehicleBrand.VehicleBrandFragment;
import ru.tenant.pass24.profileFragments.addressSearch.AddressSearchFragment;
import ru.tenant.pass24.profileFragments.passes.apiModels.CreatePassRequest;
import ru.tenant.pass24.profileFragments.passes.apiModels.CreatePassRequestBody;
import ru.tenant.pass24.profileFragments.passes.apiModels.GuestData;
import ru.tenant.pass24.profileFragments.requests.RequestTypeFragment;
import ru.tenant.pass24.profileFragments.requests.RequestVehicleTypeFragment;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestResponse;

public class RequestsPermanentPassFragment extends Fragment {
    public static RequestsPermanentPassFragment mInstance;
    public static String TAG = "RequestsPermanentPassFragment";
    private ConstraintLayout clBrandField, clCarTypeField, clAddressField;
    private ImageView backBtn, btnClose;
    private Button btnSendCarPass;

    private RequestsPermanentPassFragment() {
    }

    public static RequestsPermanentPassFragment getInstance() {
        if (mInstance == null) {
            return new RequestsPermanentPassFragment();
        } else return mInstance;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_vehicle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        clBrandField = view.findViewById(R.id.clBrandField);
        clCarTypeField = view.findViewById(R.id.clCarTypeField);
        clAddressField = view.findViewById(R.id.clAddressField);
        backBtn = view.findViewById(R.id.btnBack);
        btnClose = view.findViewById(R.id.btnClose);
        btnSendCarPass = view.findViewById(R.id.btnSendCarPass);

        clBrandField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toVehicleBrand();
            }
        });

        clCarTypeField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toVehicleType();
            }
        });

        clAddressField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAddressSearch();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
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

        btnSendCarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }

    public void toAddressSearch() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", TAG);
        AddressSearchFragment addressSearchFragment = new AddressSearchFragment();
        addressSearchFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, addressSearchFragment)
                .addToBackStack(TAG)
                .commit();
    }

    public void toVehicleBrand() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", TAG);
        VehicleBrandFragment vehicleBrandFragment = new VehicleBrandFragment();
        vehicleBrandFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, vehicleBrandFragment)
                .addToBackStack("")
                .commit();
    }

    public void toVehicleType() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", TAG);
        RequestVehicleTypeFragment requestVehicleTypeFragment = new RequestVehicleTypeFragment();
        requestVehicleTypeFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, requestVehicleTypeFragment)
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

    public void sendRequest() {
        CreatePassRequestBody createPassRequestBody = new CreatePassRequestBody();
        createPassRequestBody.setType(Constants.passJoinType);
        CreatePassRequest createPassRequest = new CreatePassRequest();
        createPassRequest.setAddressId(3);
        createPassRequest.setStartsAt("21.03.2020");
        createPassRequest.setExpiresAt("21.03.2021");
        createPassRequest.setDurationType(2);
        createPassRequest.setGuestType(1);
        GuestData guestData = new GuestData();
        guestData.setVehicleType(1);
        guestData.setModelId(1);
        guestData.setPlateNumber("xx000xx102");
        createPassRequest.setGuestData(guestData);
        createPassRequest.setComment("");
        createPassRequestBody.setRequestData(createPassRequest);
//        createRequestBody.setRequestData(new CreateRequestData(1, tilNewAddress.getEditText().getText().toString()));
        ApiService.getInstance().getRequestApi().createPassRequest(Constants.getAuthToken(), createPassRequestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CreateRequestResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CreateRequestResponse createRequestResponse) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
