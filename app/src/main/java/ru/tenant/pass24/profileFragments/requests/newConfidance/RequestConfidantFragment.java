package ru.tenant.pass24.profileFragments.requests.newConfidance;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
import ru.tenant.pass24.profileFragments.ValidityFragment;
import ru.tenant.pass24.profileFragments.addressSearch.AddressSearchFragment;
import ru.tenant.pass24.profileFragments.requests.RequestTypeFragment;
import ru.tenant.pass24.profileFragments.requests.RequestsFragment;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestBody;
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestResponse;

public class RequestConfidantFragment extends Fragment {
    public static String TAG = "RequestConfidantFragment";
    public static RequestConfidantFragment mInstance;
    private ImageView btnBack, btnClose;
    private Button btnSendConfidant;
    private TextInputLayout tilConfidantInfo;
    private Context mContext;
    private RelativeLayout rlRequestConfidantAddress, rlRequestConfidantValidity;
    private String userName = "";
    private TextView tvAddressInfo;
    private int objectId = 1;

    private RequestConfidantFragment() {
    }

    public static RequestConfidantFragment getInstance() {
        if (mInstance == null)
            return new RequestConfidantFragment();
        else
            return mInstance;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_confidant, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = this.getContext();
        mInstance = this;
        init(view);
    }


    private void init(View view) {
        rlRequestConfidantAddress = view.findViewById(R.id.rlRequestConfidantAddress);
        rlRequestConfidantValidity = view.findViewById(R.id.rlRequestConfidantValidity);
        btnBack = view.findViewById(R.id.btnBack);
        btnClose = view.findViewById(R.id.btnClose);
        btnSendConfidant = view.findViewById(R.id.btnSendConfidant);
        tilConfidantInfo = view.findViewById(R.id.tilConfidantInfo);
        tvAddressInfo = view.findViewById(R.id.tvAddressInfo);
        tilConfidantInfo.getEditText().setText(userName);
        if (this.getArguments() != null)
            if (this.getArguments().getString("addressName") != null) {
                tvAddressInfo.setVisibility(View.VISIBLE);
                tvAddressInfo.setText(this.getArguments().getString("addressName"));
                objectId = this.getArguments().getInt("objectId");
            }


        tilConfidantInfo.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable text) {
                userName = text.toString();
                checkFields();
            }
        });

        rlRequestConfidantAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSearchAddressFragment();
            }
        });

        rlRequestConfidantValidity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toValidityFragment();
            }
        });

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

        btnSendConfidant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewConfidance();
            }
        });
    }

    public void checkFields() {
        if (tilConfidantInfo.getEditText().getText().length() > 0)
            btnSendConfidant.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rounded_red_button));
        else
            btnSendConfidant.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rounded_gray_button));
    }

    public void createNewConfidance() {
        CreateRequestBody createRequestBody = new CreateRequestBody();
        createRequestBody.setType(Constants.confidanceType);
        Random random = new Random();

//        createRequestBody.setRequestData(new CreateRequestData(1, tilNewAddress.getEditText().getText().toString()));
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

    public void toRequestsFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new RequestsFragment())
                .addToBackStack(RequestTypeFragment.TAG)
                .commit();
    }

    public void toRequestType() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, RequestTypeFragment.getInstance())
                .addToBackStack(RequestTypeFragment.TAG)
                .commit();
    }

    public void toSearchAddressFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", RequestConfidantFragment.TAG);
        AddressSearchFragment requestNewAddressFragment = new AddressSearchFragment();
        requestNewAddressFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, requestNewAddressFragment)
                .addToBackStack("")
                .commit();
    }

    public void toValidityFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, new ValidityFragment())
                .addToBackStack("")
                .commit();
    }
}
