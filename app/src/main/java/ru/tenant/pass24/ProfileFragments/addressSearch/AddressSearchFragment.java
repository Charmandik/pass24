package ru.tenant.pass24.ProfileFragments.addressSearch;

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
import ru.tenant.pass24.ProfileFragments.addressSearch.apiModels.ProfileAddressesResponse;
import ru.tenant.pass24.ProfileFragments.addressSearch.apiModels.ProfileAddressesResponseBody;
import ru.tenant.pass24.R;

public class AddressSearchFragment extends Fragment {
    private RecyclerView rvAddressSearch;
    private RecyclerView.LayoutManager layoutManager;
    private AddressSearchAdapter mAdapter;
    private List<ProfileAddressesResponseBody> profileAddressesBodiesList = new ArrayList();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_address_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        rvAddressSearch = view.findViewById(R.id.rvAddressSearch);
        getAddresses();
    }

    public void setDataForRecycler(List<ProfileAddressesResponseBody> profileAddressesBodiesList) {
        layoutManager = new LinearLayoutManager(getContext());
        rvAddressSearch.setLayoutManager(layoutManager);
        mAdapter = new AddressSearchAdapter(profileAddressesBodiesList, getFragmentManager());
        rvAddressSearch.setAdapter(mAdapter);
    }

    private void getAddresses() {
        ApiService.getInstance().getProfileApi().getProfileAddresses(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProfileAddressesResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ProfileAddressesResponse profileAddressesResponse) {
                        profileAddressesBodiesList.addAll(profileAddressesResponse.getBody());
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
