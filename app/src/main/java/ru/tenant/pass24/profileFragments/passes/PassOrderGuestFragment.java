package ru.tenant.pass24.profileFragments.passes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

public class PassOrderGuestFragment extends Fragment {
    private RelativeLayout rlPassGuestVisitTime, rlPassGuestAddress;
    private ImageView backBtn, btnClose;

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
    }

    private void createGuestPass() {
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
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new AddressSearchFragment())
                .addToBackStack("")
                .commit();
    }

    public void toValidityFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new ValidityFragment())
                .addToBackStack(null)
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
