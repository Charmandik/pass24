package ru.tenant.pass24.ProfileFragments.VehicleBrand;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import ru.tenant.pass24.Helpers.Constants;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;
import ru.tenant.pass24.ProfileFragments.VehicleBrand.apiModels.VehicleBrandCollection;
import ru.tenant.pass24.ProfileFragments.VehicleBrand.apiModels.VehicleBrandResponse;
import ru.tenant.pass24.R;

public class VehicleBrandFragment extends Fragment {
    private RecyclerView rvVehicleBrand;
    private RecyclerView.LayoutManager layoutManager;
    private VehicleBrandAdapter mAdapter;
    private List<VehicleBrandCollection> vehicleBrandCollections = new ArrayList();

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
}
