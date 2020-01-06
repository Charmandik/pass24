package ru.tenant.pass24.profileFragments.requests.newAddress;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Random;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.Retrofit.ApiService;
import ru.tenant.pass24.profileFragments.requests.RequestTypeFragment;
import ru.tenant.pass24.profileFragments.requests.RequestsFragment;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestBody;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestData;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestResponse;

public class RequestNewAddressFragment extends Fragment {
    private ImageView btnBack, btnClose;
    private Button btnSendAddress;
    private TextInputLayout tilNewAddress;
    private Context mContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_new_address, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        mContext = this.getContext();
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
        btnSendAddress.setClickable(false);
        tilNewAddress = view.findViewById(R.id.tilNewAddress);

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
                if (tilNewAddress.getEditText().getText().length() > 0)
                    createNewAddress();
            }
        });

        tilNewAddress.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable text) {
                if (text != null)
                    if (text.length() > 0) {
                        btnSendAddress.setClickable(true);
                        setButtonBackground(R.drawable.rounded_red_button);
                    } else {
                        btnSendAddress.setClickable(false);
                        setButtonBackground(R.drawable.rounded_gray_button);
                    }
            }
        });
    }

    public void createNewAddress() {
        CreateRequestBody createRequestBody = new CreateRequestBody();
        createRequestBody.setType(Constants.objectJoinType);
        Random random = new Random();

        createRequestBody.setRequestData(new CreateRequestData(1, tilNewAddress.getEditText().getText().toString()));
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
                        toRequestsFragment();
                    }
                });
    }

    public void setButtonBackground(int drawable) {
        btnSendAddress.setBackground(ContextCompat.getDrawable(mContext, drawable));
    }

    public void toRequestType() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, RequestTypeFragment.getInstance())
                .addToBackStack(RequestTypeFragment.TAG)
                .commit();
    }

    public void toRequestsFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new RequestsFragment())
                .addToBackStack(RequestTypeFragment.TAG)
                .commit();
    }


}
