package ru.tenant.pass24.profileFragments.vehicleBrand;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.Retrofit.ApiService;
import ru.tenant.pass24.profileFragments.requests.RequestTypeFragment;
import ru.tenant.pass24.profileFragments.requests.permanentPass.RequestsPermanentPassFragment;
import ru.tenant.pass24.profileFragments.vehicleBrand.apiModels.VehicleBrandCollection;
import ru.tenant.pass24.profileFragments.vehicleBrand.apiModels.VehicleBrandResponse;

public class VehicleBrandFragment extends Fragment {
    public static String vehicleBrand = "";
    private RecyclerView rvVehicleBrand;
    private RecyclerView.LayoutManager layoutManager;
    private VehicleBrandAdapter mAdapter;
    private List<VehicleBrandCollection> vehicleBrandCollections = new ArrayList();
    private ImageView backBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vehicle_brand, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        rvVehicleBrand = view.findViewById(R.id.rvVehicleBrand);
        backBtn = view.findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRequestsPermanentPassFragment();
            }
        });
        getVehicleBrands();
    }

    public void setDataForRecycler(List<VehicleBrandCollection> vehicleBrandCollectionList) {
        layoutManager = new LinearLayoutManager(getContext());
        rvVehicleBrand.setLayoutManager(layoutManager);
        mAdapter = new VehicleBrandAdapter(vehicleBrandCollectionList, getFragmentManager());
        rvVehicleBrand.setAdapter(mAdapter);
    }

    private void getVehicleBrands() {
        ApiService.getInstance().getVehicleBrand().getBrands(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VehicleBrandResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(VehicleBrandResponse vehicleBrandResponse) {
                        vehicleBrandCollections.addAll(vehicleBrandResponse.getBody());
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        setDataForRecycler(vehicleBrandCollections);
                    }
                });
    }

    public void toRequestsPermanentPassFragment() {
        if (!vehicleBrand.equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString("vehicleBrand", vehicleBrand);
            RequestsPermanentPassFragment requestsPermanentPassFragment = RequestsPermanentPassFragment.getInstance();
            requestsPermanentPassFragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flRequestsContainer, requestsPermanentPassFragment)
                    .addToBackStack(RequestTypeFragment.TAG)
                    .commit();
        } else {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flRequestsContainer, RequestsPermanentPassFragment.getInstance())
                    .addToBackStack(RequestTypeFragment.TAG)
                    .commit();
        }
    }
}

