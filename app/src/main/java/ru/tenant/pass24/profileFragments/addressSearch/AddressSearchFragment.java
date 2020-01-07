package ru.tenant.pass24.profileFragments.addressSearch;

import android.content.Context;
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
import java.util.Objects;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.retrofit.ApiService;
import ru.tenant.pass24.profileFragments.addressSearch.apiModels.ProfileAddressesResponse;
import ru.tenant.pass24.profileFragments.addressSearch.apiModels.ProfileAddressesResponseBody;
import ru.tenant.pass24.profileFragments.passes.PassOrderGuestFragment;
import ru.tenant.pass24.profileFragments.passes.PassOrderInviteFragment;
import ru.tenant.pass24.profileFragments.passes.PassOrderVehicleFragment;
import ru.tenant.pass24.profileFragments.requests.RequestTypeFragment;
import ru.tenant.pass24.profileFragments.requests.newConfidance.RequestConfidantFragment;
import ru.tenant.pass24.profileFragments.requests.permanentPass.RequestsPermanentPassFragment;
import ru.tenant.pass24.profileFragments.trustedPeople.AddConfidanceFragment;

public class AddressSearchFragment extends Fragment {
    public static String addressName = "";
    public static int objectId = 1;
    private RecyclerView rvAddressSearch;
    private RecyclerView.LayoutManager layoutManager;
    private AddressSearchAdapter mAdapter;
    private List<ProfileAddressesResponseBody> profileAddressesBodiesList = new ArrayList();
    private ImageView backBtn;
    private AddressSearchFragment mInstance;
    private Context mContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_address_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInstance = this;
        mContext = this.getContext();
        init(view);
    }

    private void init(View view) {
        rvAddressSearch = view.findViewById(R.id.rvAddressSearch);
        backBtn = view.findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInstance.getArguments() != null)
                    if (Objects.equals(mInstance.getArguments().getString("fragment"), RequestConfidantFragment.TAG)) {
                        toRequestConfidantFragment();
                    } else if (Objects.equals(mInstance.getArguments().getString("fragment"), RequestsPermanentPassFragment.TAG)) {
                        toRequestsPermanentPassFragment();
                    } else if (Objects.equals(mInstance.getArguments().getString("fragment"), PassOrderVehicleFragment.TAG)) {
                        toPassOrderVehicleFragment();
                    } else if (Objects.equals(mInstance.getArguments().getString("fragment"), PassOrderGuestFragment.TAG)) {
                        toPassOrderGuestFragment();
                    } else if (Objects.equals(mInstance.getArguments().getString("fragment"), PassOrderInviteFragment.TAG)) {
                        toPassOrderInviteFragment();
                    } else if (Objects.equals(mInstance.getArguments().getString("fragment"), PassOrderInviteFragment.TAG)) {
                        toPassOrderInviteFragment();
                    } else if (Objects.equals(mInstance.getArguments().getString("fragment"), AddConfidanceFragment.TAG)) {
                        toAddConfidanceFragment();
                    }
            }
        });
        getAddresses();
    }

    public void setDataForRecycler(List<ProfileAddressesResponseBody> profileAddressesBodiesList) {
        layoutManager = new LinearLayoutManager(getContext());
        rvAddressSearch.setLayoutManager(layoutManager);
        mAdapter = new AddressSearchAdapter(profileAddressesBodiesList, mContext);
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
                        if (profileAddressesResponse != null)
                            if (profileAddressesResponse.getBody() != null)
                                profileAddressesBodiesList.addAll(profileAddressesResponse.getBody());
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        setDataForRecycler(profileAddressesBodiesList);
                    }
                });
    }

    public void toRequestType() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, RequestTypeFragment.getInstance())
                .addToBackStack(RequestTypeFragment.TAG)
                .commit();
    }

    public void toRequestConfidantFragment() {
        if (!addressName.equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString("addressName", addressName);
            bundle.putInt("objectId", objectId);
            RequestConfidantFragment requestConfidantFragment = RequestConfidantFragment.getInstance();
            requestConfidantFragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flRequestsContainer, requestConfidantFragment)
                    .addToBackStack(RequestTypeFragment.TAG)
                    .commit();
        } else {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flRequestsContainer, RequestConfidantFragment.getInstance())
                    .addToBackStack(RequestTypeFragment.TAG)
                    .commit();
        }
    }

    public void toAddConfidanceFragment() {
        if (!addressName.equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString("addressName", addressName);
            bundle.putInt("objectId", objectId);
            AddConfidanceFragment addConfidanceFragment = AddConfidanceFragment.getInstance();
            addConfidanceFragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flTrustPeopleContainer, addConfidanceFragment)
                    .addToBackStack(AddConfidanceFragment.TAG)
                    .commit();
        } else {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flTrustPeopleContainer, AddConfidanceFragment.getInstance())
                    .addToBackStack(AddConfidanceFragment.TAG)
                    .commit();
        }
    }

    public void toRequestsPermanentPassFragment() {
        if (!addressName.equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString("addressName", addressName);
            bundle.putInt("objectId", objectId);
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

    public void toPassOrderVehicleFragment() {
        if (!addressName.equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString("addressName", addressName);
            bundle.putInt("objectId", objectId);
            PassOrderVehicleFragment passOrderVehicleFragment = PassOrderVehicleFragment.getInstance();
            passOrderVehicleFragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flPassesContainer, passOrderVehicleFragment)
                    .addToBackStack(RequestTypeFragment.TAG)
                    .commit();
        } else {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flPassesContainer, PassOrderVehicleFragment.getInstance())
                    .addToBackStack(RequestTypeFragment.TAG)
                    .commit();
        }
    }

    public void toPassOrderGuestFragment() {
        if (!addressName.equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString("addressName", addressName);
            bundle.putInt("objectId", objectId);
            PassOrderGuestFragment passOrderGuestFragment = PassOrderGuestFragment.getInstance();
            passOrderGuestFragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flPassesContainer, passOrderGuestFragment)
                    .addToBackStack(PassOrderGuestFragment.TAG)
                    .commit();
        } else {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flPassesContainer, PassOrderGuestFragment.getInstance())
                    .addToBackStack(PassOrderGuestFragment.TAG)
                    .commit();
        }
    }

    public void toPassOrderInviteFragment() {
        if (!addressName.equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString("addressName", addressName);
            bundle.putInt("objectId", objectId);
            PassOrderInviteFragment passOrderInviteFragment = PassOrderInviteFragment.getInstance();
            passOrderInviteFragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flPassesContainer, passOrderInviteFragment)
                    .addToBackStack(PassOrderInviteFragment.TAG)
                    .commit();
        } else {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flPassesContainer, PassOrderInviteFragment.getInstance())
                    .addToBackStack(PassOrderInviteFragment.TAG)
                    .commit();
        }
    }
}
