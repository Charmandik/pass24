package ru.tenant.pass24.profileFragments.requests.newAddress;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

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
import ru.tenant.pass24.profileFragments.requests.RequestTypeFragment;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestBody;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestData;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestResponse;

public class RequestNewAddressFragment extends Fragment {
    private ImageView btnBack, btnClose;
    private Button btnSendAddress;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_new_address, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    public void toRequestsAdd() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, RequestTypeFragment.getInstance())
                .addToBackStack(RequestTypeFragment.TAG)
                .commit();
    }

    private void init(View view) {
        btnBack = view.findViewById(R.id.btnBack);
        btnClose = view.findViewById(R.id.btnClose);
        btnSendAddress = view.findViewById(R.id.btnSendAddress);

        btnBack.setOnClickListener(new View.OnClickListener() {
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

        btnSendAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAddress();
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

    public void createNewAddress() {
        CreateRequestBody createRequestBody = new CreateRequestBody();
        createRequestBody.setType(Constants.objectJoinType);
        createRequestBody.setRequestData(new CreateRequestData(1, "New address"));
        ApiService.getInstance().getRequestApi().createRequest(Constants.getAuthToken(), createRequestBody)
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
