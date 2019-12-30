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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

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
import ru.tenant.pass24.profileFragments.requests.newConfidance.apiModels.NewConfidanceRequest;
import ru.tenant.pass24.profileFragments.requests.newConfidance.apiModels.NewConfidanceResponse;

public class RequestConfidantFragment extends Fragment {
    private ImageView btnBack, btnClose;
    private Button btnSendConfidant;
    private TextInputLayout tilConfidantInfo;
    private Context mContext;

    private RelativeLayout rlRequestConfidantAddress, rlRequestConfidantValidity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_confidant, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = this.getContext();
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
        rlRequestConfidantAddress = view.findViewById(R.id.rlRequestConfidantAddress);
        rlRequestConfidantValidity = view.findViewById(R.id.rlRequestConfidantValidity);
        btnBack = view.findViewById(R.id.btnBack);
        btnClose = view.findViewById(R.id.btnClose);
        btnSendConfidant = view.findViewById(R.id.btnSendConfidant);
        tilConfidantInfo = view.findViewById(R.id.tilConfidantInfo);

        tilConfidantInfo.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable text) {
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
        NewConfidanceRequest confidanceRequest = new NewConfidanceRequest();
        //TODO:fill request fields
        ApiService.getInstance().getConfidancesApi().createConfidance(Constants.getAuthToken(), confidanceRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewConfidanceResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(NewConfidanceResponse newConfidanceResponse) {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
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

    public void toSearchAddressFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("fragment", RequestTypeFragment.TAG);
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
