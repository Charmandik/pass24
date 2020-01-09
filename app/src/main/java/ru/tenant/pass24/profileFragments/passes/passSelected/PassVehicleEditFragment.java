package ru.tenant.pass24.profileFragments.passes.passSelected;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import ru.tenant.pass24.profileFragments.passes.PassCreatedFragment;
import ru.tenant.pass24.profileFragments.passes.PassOrderTypeFragment;
import ru.tenant.pass24.profileFragments.passes.PassOrderVehicleFragment;
import ru.tenant.pass24.profileFragments.passes.PassOrderVehicleTypeFragment;
import ru.tenant.pass24.profileFragments.passes.apiModels.PassesCollection;
import ru.tenant.pass24.profileFragments.passes.apiModels.VehicleGuestData;
import ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels.CreateVehiclePassRequest;
import ru.tenant.pass24.profileFragments.passes.passSelected.apiModels.EditPassResponse;
import ru.tenant.pass24.profileFragments.passes.passSelected.apiModels.GetPassResponse;
import ru.tenant.pass24.profileFragments.vehicleBrand.VehicleBrandFragment;

public class PassVehicleEditFragment extends Fragment {
    public static String TAG = "PassOrderVehicleFragment";
    private static PassVehicleEditFragment mInstance;
    private RelativeLayout rlPassOrderAddress, rlPassOrderType, rlPassOrderVehicleBrand, rlPassOrderVehicleType, rlPassOrderVisitTime;
    private Button btnCreatePass;
    private TextView tvVehiclePassAddress, tvVehiclePassType, tvBrandName, tvCarTypeName, tvVisitTimeInfo;
    private EditText etVehicleNumber;
    private TextInputEditText etVehiclePassComment;
    private ImageView btnBack, closeBtn;
    private View view;

    private String addressName = "";
    private String vehicleBrand = "";
    private String carTypeName = "";
    private int carType = 0;
    private int objectId;
    private int modelId;
    private String startsAt = "";
    private String expiresAt = "";
    private int durationType;
    private String passTypeName = "";
    private String vehicleNumber = "";
    private String commentary = "";
    private int passId;

    private PassVehicleEditFragment(int passId) {
        this.passId = passId;
        mInstance = this;
    }

    public static PassVehicleEditFragment getInstance(int passId) {
        if (mInstance == null) {
            return new PassVehicleEditFragment(passId);
        } else return mInstance;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_vehicle_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        getPassInfo();


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
                editPass();
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

        if (!passTypeName.equals("")) {
            tvVehiclePassType.setText(passTypeName);
            tvVehiclePassType.setVisibility(View.VISIBLE);
        }

        if (!vehicleNumber.equals("")) {
            etVehicleNumber.setText(vehicleNumber);
        }

        if (!commentary.equals("")) {
            etVehiclePassComment.setText(commentary);
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

            if (this.getArguments().getString("passTypeName") != null) {
                tvVehiclePassType.setVisibility(View.VISIBLE);
                durationType = this.getArguments().getInt("durationType");
                passTypeName = this.getArguments().getString("passTypeName");
                tvVehiclePassType.setText(passTypeName);
            }
        }
    }

    private void editPass() {
        CreateVehiclePassRequest createVehiclePassRequest = new CreateVehiclePassRequest();
        createVehiclePassRequest.setAddressId(objectId);
        createVehiclePassRequest.setStartsAt(startsAt);
        createVehiclePassRequest.setExpiresAt(expiresAt);
        createVehiclePassRequest.setDurationType(durationType);
        createVehiclePassRequest.setGuestType(1);
        VehicleGuestData vehicleGuestData = new VehicleGuestData();
        vehicleGuestData.setVehicleType(carType);
        vehicleGuestData.setModelId(modelId);
        vehicleGuestData.setPlateNumber(etVehicleNumber.getText().toString().trim());
        createVehiclePassRequest.setVehicleGuestData(vehicleGuestData);
        createVehiclePassRequest.setComment(etVehiclePassComment.getText().toString().trim());
        createVehiclePassRequest.setOptions(new ArrayList());
        ApiService.getInstance().getPassesApi().editPass(Constants.getAuthToken(), passId, createVehiclePassRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EditPassResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(EditPassResponse editPassResponse) {
                        if (editPassResponse != null)
                            if (editPassResponse.getBody() != null) {
//                                toPassCreatedFragment();
                            } else if (editPassResponse.getError() != null)
                                if (editPassResponse.getError().getCode() != null)
                                    if (editPassResponse.getError().getCode().equals("CLOSED_PASS"))
                                        Toast.makeText(mInstance.getContext(), "Пропуск закрыт", Toast.LENGTH_LONG).show();
                                    else
                                        Toast.makeText(mInstance.getContext(), editPassResponse.getError().getCode(), Toast.LENGTH_LONG).show();
//                        else if (editPassResponse.getError() != null)
//                                if (editPassResponse.getError().getCode() != null)
//                                    if (editPassResponse.getError().getCode().equals("UNAUTHENTICATED"))
//                                        toLogin();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private void getPassInfo() {
        ApiService.getInstance().getPassesApi().getPassInfo(Constants.getAuthToken(), passId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetPassResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetPassResponse getPassResponse) {
                        if (getPassResponse != null)
                            if (getPassResponse.getBody() != null) {
                                PassesCollection body = getPassResponse.getBody();
                                if (body.getAddress() != null) {
                                    if (body.getAddress().getName() != null)
                                        addressName = body.getAddress().getName();

                                    if (body.getAddress().getId() != null)
                                        objectId = body.getAddress().getId();
                                }

                                if (body.getGuestData() != null) {
                                    if (body.getGuestData().getModel() != null) {
                                        vehicleBrand = body.getGuestData().getModel().getTitle();
                                        modelId = body.getGuestData().getModel().getId();
                                    }

                                    if (body.getGuestData().getPlateNumber() != null)
                                        vehicleNumber = body.getGuestData().getPlateNumber();

                                    if (body.getGuestData().getVehicleType() != null) {
                                        carType = body.getGuestData().getVehicleType();

                                        if (carType == 1)
                                            carTypeName = "Легковой/мото";
                                        else if (carType == 2)
                                            carTypeName = "Грузовой До 3,5 тонн";
                                        else if (carType == 3)
                                            carTypeName = "Грузовой от 3,5 до 10 тонн";
                                        else if (carType == 4)
                                            carTypeName = "Грузовой от 10 тонн";
                                    }
                                }

                                if (body.getGuestType() != null)
                                    durationType = body.getGuestType();

                                if (body.getStartsAt() != null)
                                    startsAt = body.getStartsAt();

                                if (body.getExpiresAt() != null)
                                    expiresAt = body.getExpiresAt();

                                if (body.getDurationType() != null) {
                                    if (body.getDurationType() == 1)
                                        passTypeName = "Одноразовый";
                                    else if (body.getDurationType() == 2)
                                        passTypeName = "Временный";
                                    else if (body.getDurationType() == 3)
                                        passTypeName = "Постоянный";
                                }

                                if (body.getComment() != null)
                                    commentary = body.getComment();

                            } else if (getPassResponse.getError() != null)
                                if (getPassResponse.getError().getCode() != null)
                                    if (getPassResponse.getError().getCode().equals("UNAUTHENTICATED"))
                                        toLogin();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        init(view);
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
        if (getFragmentManager() != null) {
            if (getFragmentManager().getBackStackEntryCount() > 0)
                getFragmentManager().popBackStack();
        }
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
