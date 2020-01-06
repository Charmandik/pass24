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
import ru.tenant.pass24.profileFragments.requests.apiModels.createRequestModels.CreateRequestResponse;
import ru.tenant.pass24.profileFragments.requests.newConfidance.apiModels.NewConfidanceRequest;
import ru.tenant.pass24.profileFragments.requests.newConfidance.apiModels.NewConfidanceRequestData;
import ru.tenant.pass24.profileFragments.requests.newConfidance.apiModels.RequestConfidant;

public class RequestConfidantFragment extends Fragment {
    public static String TAG = "RequestConfidantFragment";
    public static RequestConfidantFragment mInstance;
    private ImageView btnBack, btnClose;
    private Button btnSendConfidant;
    private TextInputLayout tilConfidantFirstName, tilConfidantSecondName, tilConfidantPhone;
    private Context mContext;
    private RelativeLayout rlRequestConfidantAddress, rlRequestConfidantValidity;
    private String firstName = "";
    private String secondName = "";
    private String phone = "7";
    private String startsAt = "";
    private String expiresAt = "";
    private String address = "";
    private TextView tvAddressInfo, tvVisitTimeInfo;
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
        tilConfidantFirstName = view.findViewById(R.id.tilConfidantFirstName);
        tilConfidantSecondName = view.findViewById(R.id.tilConfidantSecondName);
        tilConfidantPhone = view.findViewById(R.id.tilConfidantPhone);
        tvAddressInfo = view.findViewById(R.id.tvAddressInfo);
        tvVisitTimeInfo = view.findViewById(R.id.tvVisitTimeInfo);
        tilConfidantFirstName.getEditText().setText(firstName);
        tilConfidantSecondName.getEditText().setText(secondName);
        tilConfidantPhone.getEditText().setText(phone);
        if (!startsAt.equals("")) {
            tvVisitTimeInfo.setText(startsAt + " - " + expiresAt);
            tvVisitTimeInfo.setVisibility(View.VISIBLE);
        }
        if (!address.equals("")) {
            tvAddressInfo.setText(address);
            tvAddressInfo.setVisibility(View.VISIBLE);
        }

        configureTextInputLayouts();
        if (this.getArguments() != null) {
            if (this.getArguments().getString("addressName") != null) {
                tvAddressInfo.setVisibility(View.VISIBLE);
                tvAddressInfo.setText(this.getArguments().getString("addressName"));
                address = this.getArguments().getString("addressName");
                objectId = this.getArguments().getInt("objectId");
            }

            if (this.getArguments().getString("startsAt") != null) {
                tvVisitTimeInfo.setVisibility(View.VISIBLE);
                String data = this.getArguments().getString("startsAt") + " - " + this.getArguments().getString("expiresAt");
                startsAt = this.getArguments().getString("startsAt");
                expiresAt = this.getArguments().getString("expiresAt");
                tvVisitTimeInfo.setText(data);
            }
        }


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

    public void configureTextInputLayouts() {
        tilConfidantFirstName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable text) {
                firstName = text.toString();
                checkFields();
            }
        });

        tilConfidantSecondName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable text) {
                secondName = text.toString();
                checkFields();
            }
        });

        tilConfidantPhone.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable text) {
                phone = text.toString();
                checkFields();
            }
        });
    }

    public void checkFields() {
        if ((tilConfidantFirstName.getEditText().getText().length() > 0)
                && (tilConfidantSecondName.getEditText().getText().length() > 0)
                && (tilConfidantPhone.getEditText().getText().length() > 0))
            btnSendConfidant.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rounded_red_button));
        else
            btnSendConfidant.setBackground(ContextCompat.getDrawable(mContext, R.drawable.rounded_gray_button));
    }

    public void createNewConfidance() {
        NewConfidanceRequest newConfidanceRequest = new NewConfidanceRequest();
        newConfidanceRequest.setType(Constants.confidanceType);
        NewConfidanceRequestData createRequestData = new NewConfidanceRequestData();
        RequestConfidant confidant = new RequestConfidant();
        confidant.setFirstName(tilConfidantFirstName.getEditText().getText().toString());
        confidant.setLastName(tilConfidantSecondName.getEditText().getText().toString());
        confidant.setPhone(tilConfidantPhone.getEditText().getText().toString());

        createRequestData.setConfidant(confidant);
        createRequestData.setAddressId(objectId);
        createRequestData.setStartsAt(this.getArguments().getString("startsAt"));
        createRequestData.setExpiresAt(this.getArguments().getString("expiresAt"));
        Random random = new Random();

        newConfidanceRequest.setRequestData(createRequestData);
        ApiService.getInstance().getRequestApi().createRequestNewConfidant(Constants.getAuthToken(), newConfidanceRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CreateRequestResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CreateRequestResponse createRequestResponse) {
                        if (createRequestResponse.getError() != null) {
                            if (createRequestResponse.getError().getDetails() != null) {
                                if (createRequestResponse.getError().getDetails().getConfidant_firstName() != null)
                                    showErrorOnFirstName(true, createRequestResponse.getError().getDetails().getConfidant_firstName().get(0));
                                else showErrorOnFirstName(false, "");

                                if (createRequestResponse.getError().getDetails().getConfidant_lastName() != null)
                                    showErrorOnLastName(true, createRequestResponse.getError().getDetails().getConfidant_lastName().get(0));
                                else showErrorOnLastName(false, "");

                                if (createRequestResponse.getError().getDetails().getConfidant_phone() != null)
                                    showErrorOnPhone(true, createRequestResponse.getError().getDetails().getConfidant_phone().get(0));
                                else showErrorOnPhone(false, "");
                            }
                        } else
                            toRequestsFragment();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

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
        Bundle bundle = new Bundle();
        bundle.putString("fragment", RequestConfidantFragment.TAG);
        ValidityFragment validityFragment = new ValidityFragment();
        validityFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flRequestsContainer, validityFragment)
                .addToBackStack("")
                .commit();
    }

    public void showErrorOnFirstName(boolean show, String text) {
        if (show)
            tilConfidantFirstName.setError(text);
        else
            tilConfidantFirstName.setError("");
    }

    public void showErrorOnLastName(boolean show, String text) {
        if (show)
            tilConfidantSecondName.setError(text);
        else
            tilConfidantSecondName.setError("");
    }

    public void showErrorOnPhone(boolean show, String text) {
        if (show)
            tilConfidantPhone.setError(text);
        else
            tilConfidantPhone.setError("");
    }
}
