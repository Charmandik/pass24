package ru.tenant.pass24.profileFragments.passes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.Retrofit.ApiService;
import ru.tenant.pass24.profileFragments.ValidityFragment;
import ru.tenant.pass24.profileFragments.addressSearch.AddressSearchFragment;
import ru.tenant.pass24.profileFragments.passes.apiModels.GuestData;
import ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels.CreateVehiclePassRequest;
import ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels.CreateVehiclePassResponse;
import ru.tenant.pass24.profileFragments.vehicleBrand.VehicleBrandFragment;

public class PassOrderVehicleFragment extends Fragment {
    public static String TAG = "PassOrderVehicleFragment";
    private RelativeLayout rlPassOrderAddress, rlPassOrderType, rlPassOrderVehicleBrand, rlPassOrderVehicleType, rlPassOrderVisitTime;
    private static PassOrderVehicleFragment mInstance;
    private Button btnCreatePass;
    private TextView tvVehiclePassAddress, tvVehiclePassType, tvBrandName, tvCarTypeName, tvVisitTimeInfo;
    private EditText etVehicleNumber;
    private TextInputEditText etVehiclePassComment;
    private ImageView btnBack, closeBtn;


    private String addressName = "";
    private String vehicleBrand = "";
    private String carTypeName = "";
    private int carType = 0;
    private int objectId;
    private int modelId;
    private String startsAt = "";
    private String expiresAt = "";
    private int passType;
    private String passName = "";


    private PassOrderVehicleFragment() {
        mInstance = this;
    }

    public static PassOrderVehicleFragment getInstance() {
        if (mInstance == null) {
            return new PassOrderVehicleFragment();
        } else return mInstance;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_order_vehicle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        rlPassOrderAddress = view.findViewById(R.id.rlPassOrderAddress);
        rlPassOrderType = view.findViewById(R.id.rlPassOrderType);
        rlPassOrderVehicleBrand = view.findViewById(R.id.rlPassOrderVehicleBrand);
        rlPassOrderVehicleType = view.findViewById(R.id.rlPassOrderVehicleType);
        rlPassOrderVisitTime = view.findViewById(R.id.rlPassOrderVisitTime);
        btnCreatePass = view.findViewById(R.id.btnCreatePass);
        tvVehiclePassAddress = view.findViewById(R.id.tvVehiclePassAddress);
        tvVehiclePassType = view.findViewById(R.id.tvVehiclePassType);
        tvBrandName = view.findViewById(R.id.tvBrandName);
        tvCarTypeName = view.findViewById(R.id.tvCarTypeName);
        tvVisitTimeInfo = view.findViewById(R.id.tvVisitTimeInfo);
        etVehicleNumber = view.findViewById(R.id.etVehicleNumber);
        etVehiclePassComment = view.findViewById(R.id.etVehiclePassComment);
        closeBtn = view.findViewById(R.id.closeBtn);
        btnBack = view.findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderFragment();
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderFragment();
            }
        });

        rlPassOrderAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAddressSearchFragment();
            }
        });

        rlPassOrderType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderTypeFragment();
            }
        });

        rlPassOrderVehicleBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toVehicleBrandFragment();
            }
        });

        rlPassOrderVehicleType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPassOrderVehicleTypeFragment();
            }
        });

        rlPassOrderVisitTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toValidityFragment();
            }
        });

        btnCreatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createVehiclePass();
            }
        });

        if (!addressName.equals("")) {
            tvVehiclePassAddress.setText(addressName);
            tvVehiclePassAddress.setVisibility(View.VISIBLE);
        }

        if (!vehicleBrand.equals("")) {
            tvBrandName.setText(vehicleBrand);
            tvBrandName.setVisibility(View.VISIBLE);
        }

        if (!carTypeName.equals("")) {
            tvCarTypeName.setText(carTypeName);
            tvCarTypeName.setVisibility(View.VISIBLE);
        }

        if (!startsAt.equals("")) {
            tvVisitTimeInfo.setText(startsAt + " - " + expiresAt);
            tvVisitTimeInfo.setVisibility(View.VISIBLE);
        }

        if (!passName.equals("")) {
            tvVehiclePassType.setText(passName);
            tvVehiclePassType.setVisibility(View.VISIBLE);
        }

        if (this.getArguments() != null) {
            if (this.getArguments().getString("addressName") != null) {
                tvVehiclePassAddress.setVisibility(View.VISIBLE);
                tvVehiclePassAddress.setText(this.getArguments().getString("addressName"));
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

            if (this.getArguments().getString("startsAt") != null) {
                tvVisitTimeInfo.setVisibility(View.VISIBLE);
                String data = this.getArguments().getString("startsAt") + " - " + this.getArguments().getString("expiresAt");
                startsAt = this.getArguments().getString("startsAt");
                expiresAt = this.getArguments().getString("expiresAt");
                tvVisitTimeInfo.setText(data);
            }

            if (this.getArguments().getString("passName") != null) {
                tvVehiclePassType.setVisibility(View.VISIBLE);
                passType = this.getArguments().getInt("passType");
                passName = this.getArguments().getString("passName");
                tvVehiclePassType.setText(passName);
            }
        }
    }

    private void createVehiclePass() {
        CreateVehiclePassRequest createVehiclePassRequest = new CreateVehiclePassRequest();
        createVehiclePassRequest.setAddressId(objectId);
        createVehiclePassRequest.setStartsAt(startsAt);
        createVehiclePassRequest.setExpiresAt(expiresAt);
        createVehiclePassRequest.setDurationType(passType);
        createVehiclePassRequest.setGuestType(1);
        GuestData guestData = new GuestData();
        guestData.setVehicleType(carType);
        guestData.setModelId(modelId);
        guestData.setPlateNumber(etVehicleNumber.getText().toString().trim());
        createVehiclePassRequest.setGuestData(guestData);
        createVehiclePassRequest.setComment(etVehiclePassComment.getText().toString().trim());
        ApiService.getInstance().getPassesApi().createVehiclePass(Constants.getAuthToken(), createVehiclePassRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CreateVehiclePassResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CreateVehiclePassResponse createRequestResponse) {

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
        bundle.putString("fragment", PassOrderVehicleFragment.TAG);
        AddressSearchFragment addressSearchFragment = new AddressSearchFragment();
        addressSearchFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, addressSearchFragment)
                .addToBackStack("")
                .commit();
    }

    public void toPassOrderTypeFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderVehicleFragment.TAG);
        PassOrderTypeFragment passOrderTypeFragment = new PassOrderTypeFragment();
        passOrderTypeFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, passOrderTypeFragment)
                .addToBackStack("")
                .commit();
    }

    public void toVehicleBrandFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderVehicleFragment.TAG);
        VehicleBrandFragment vehicleBrandFragment = new VehicleBrandFragment();
        vehicleBrandFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, vehicleBrandFragment)
                .addToBackStack("")
                .commit();
    }

    public void toPassOrderVehicleTypeFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderVehicleFragment.TAG);
        PassOrderVehicleTypeFragment passOrderVehicleTypeFragment = new PassOrderVehicleTypeFragment();
        passOrderVehicleTypeFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, passOrderVehicleTypeFragment)
                .addToBackStack("")
                .commit();
    }

    public void toValidityFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", PassOrderVehicleFragment.TAG);
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
}
