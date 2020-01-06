package ru.tenant.pass24.profileFragments.requests.permanentPass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
import ru.tenant.pass24.helpers.retrofit.ApiService;
import ru.tenant.pass24.profileFragments.addressSearch.AddressSearchFragment;
import ru.tenant.pass24.profileFragments.passes.apiModels.CreatePassRequestBody;
import ru.tenant.pass24.profileFragments.passes.apiModels.VehicleGuestData;
import ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels.CreateVehiclePassRequest;
import ru.tenant.pass24.profileFragments.requests.RequestTypeFragment;
import ru.tenant.pass24.profileFragments.requests.RequestVehicleTypeFragment;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestResponse;
import ru.tenant.pass24.profileFragments.vehicleBrand.VehicleBrandFragment;

public class RequestsPermanentPassFragment extends Fragment {
    public static RequestsPermanentPassFragment mInstance;
    public static String TAG = "RequestsPermanentPassFragment";
    private ConstraintLayout clBrandField, clCarTypeField, clAddressField;
    private ImageView backBtn, btnClose;
    private Button btnSendCarPass;
    private String addressName = "";
    private String vehicleBrand = "";
    private String carTypeName = "";
    private int carType = 0;
    private int objectId;
    private int modelId;


    private TextView tvPermanentPassAddress, tvBrandName, tvCarTypeName;
    private EditText etCarNumber;


    private RequestsPermanentPassFragment() {
        mInstance = this;
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
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }

    private void init(View view) {
        clBrandField = view.findViewById(R.id.clBrandField);
        clCarTypeField = view.findViewById(R.id.clCarTypeField);
        clAddressField = view.findViewById(R.id.clAddressField);
        backBtn = view.findViewById(R.id.btnBack);
        btnClose = view.findViewById(R.id.btnClose);
        btnSendCarPass = view.findViewById(R.id.btnSendCarPass);
        tvPermanentPassAddress = view.findViewById(R.id.tvPermanentPassAddress);
        tvBrandName = view.findViewById(R.id.tvBrandName);
        tvCarTypeName = view.findViewById(R.id.tvCarTypeName);
        etCarNumber = view.findViewById(R.id.etCarNumber);

        if (!addressName.equals("")) {
            tvPermanentPassAddress.setText(addressName);
            tvPermanentPassAddress.setVisibility(View.VISIBLE);
        }

        if (!vehicleBrand.equals("")) {
            tvBrandName.setText(vehicleBrand);
            tvBrandName.setVisibility(View.VISIBLE);
        }

        if (!carTypeName.equals("")) {
            tvCarTypeName.setText(carTypeName);
            tvCarTypeName.setVisibility(View.VISIBLE);
        }

        if (this.getArguments() != null) {
            if (this.getArguments().getString("addressName") != null) {
                tvPermanentPassAddress.setVisibility(View.VISIBLE);
                tvPermanentPassAddress.setText(this.getArguments().getString("addressName"));
                addressName = this.getArguments().getString("addressName");
                objectId = this.getArguments().getInt("objectId");
            }

            if (this.getArguments().getString("vehicleBrand") != null) {
                vehicleBrand = this.getArguments().getString("vehicleBrand");
                modelId = this.getArguments().getInt("modelId");
                tvBrandName.setVisibility(View.VISIBLE);
                tvBrandName.setText(vehicleBrand);
            }

            if (this.getArguments().getString("carTypeName") != null) {
                carTypeName = this.getArguments().getString("carTypeName");
                carType = this.getArguments().getInt("carType");
                tvCarTypeName.setVisibility(View.VISIBLE);
                tvCarTypeName.setText(carTypeName);
            }
        }

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
        CreateVehiclePassRequest createVehiclePassRequest = new CreateVehiclePassRequest();
        createVehiclePassRequest.setAddressId(objectId);
//        createVehiclePassRequest.setStartsAt("21.03.2020");
//        createVehiclePassRequest.setExpiresAt("21.03.2021");
        createVehiclePassRequest.setDurationType(3);
        createVehiclePassRequest.setGuestType(1);
        VehicleGuestData vehicleGuestData = new VehicleGuestData();
        vehicleGuestData.setVehicleType(carType);
        vehicleGuestData.setModelId(modelId);
        vehicleGuestData.setPlateNumber("Y004TM26");
        createVehiclePassRequest.setVehicleGuestData(vehicleGuestData);
        createVehiclePassRequest.setComment("some comment");
        createPassRequestBody.setRequestData(createVehiclePassRequest);
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
