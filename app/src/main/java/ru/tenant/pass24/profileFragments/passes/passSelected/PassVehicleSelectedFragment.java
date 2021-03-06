package ru.tenant.pass24.profileFragments.passes.passSelected;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.MainActivity;
import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.retrofit.ApiService;
import ru.tenant.pass24.profileFragments.passes.PassOrderFragment;
import ru.tenant.pass24.profileFragments.passes.PassesFragment;
import ru.tenant.pass24.profileFragments.passes.apiModels.DeletePassResponse;

public class PassVehicleSelectedFragment extends Fragment {
    public static String TAG = "PassVehicleSelectedFragment";
    private ImageView backBtn, ivBtnClose, ivDeletePass, ivAddPermanentPass, ivAddTemporaryPass;
    private TextView tvPassSelectedTitle, tvPassSelectedAddress, tvPassSelectedVisitTime, tvPassSelectedComment;
    private LinearLayout llEditPass;
    private PassVehicleSelectedFragment mInstance;

    private int passId;
    private String title;
    private String inviteLink;
    private String address;
    private String visitTime;
    private String commentary;

    public PassVehicleSelectedFragment(int id, String title, String address, String visitTime, String commentary, String inviteLink) {
        this.passId = id;
        this.title = title;
        this.inviteLink = inviteLink;
        this.address = address;
        this.visitTime = visitTime;
        this.commentary = commentary;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_selected, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInstance = this;
        init(view);
    }

    private void init(View view) {
        backBtn = view.findViewById(R.id.backBtn);
        ivBtnClose = view.findViewById(R.id.ivBtnClose);
        tvPassSelectedTitle = view.findViewById(R.id.tvPassSelectedTitle);
        tvPassSelectedAddress = view.findViewById(R.id.tvPassSelectedAddress);
        tvPassSelectedVisitTime = view.findViewById(R.id.tvPassSelectedVisitTime);
        tvPassSelectedComment = view.findViewById(R.id.tvPassSelectedComment);
        ivDeletePass = view.findViewById(R.id.ivDeletePass);
        ivAddPermanentPass = view.findViewById(R.id.ivAddPermanentPass);
        ivAddTemporaryPass = view.findViewById(R.id.ivAddTemporaryPass);
        llEditPass = view.findViewById(R.id.llEditPass);

        if (address != null)
            tvPassSelectedAddress.setText(address);
        if (title != null)
            tvPassSelectedTitle.setText(title);
        if (visitTime != null)
            tvPassSelectedVisitTime.setText(visitTime);
        if (commentary != null)
            tvPassSelectedComment.setText(commentary);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPassesFragment();
            }
        });

        ivDeletePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePass();
            }
        });

        ivAddPermanentPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPassOrderFragment();
            }
        });

        ivAddTemporaryPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPassOrderFragment();
            }
        });

        ivBtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPassesFragment();
            }
        });

        llEditPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPassVehicleEditFragment();
            }
        });
    }

    private void deletePass() {
        ApiService.getInstance().getPassesApi().deletePass(Constants.getAuthToken(), passId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeletePassResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DeletePassResponse deletePassResponse) {
                        if (deletePassResponse != null)
                            if (deletePassResponse.getBody() != null)
                                Toast.makeText(getContext(), "Успешно удален", Toast.LENGTH_LONG).show();
                            else if (deletePassResponse.getError() != null)
                                if (deletePassResponse.getError().getCode() != null)
                                    if (deletePassResponse.getError().getCode().equals("UNAUTHENTICATED"))
                                        toLogin();
                                    else
                                        Toast.makeText(mInstance.getContext(), deletePassResponse.getError().getCode(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    public void toPassesFragment() {
        if (getFragmentManager() != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flPassesContainer, new PassesFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void toPassOrderFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, new PassOrderFragment())
                .addToBackStack("asd")
                .commit();
    }

    public void toPassVehicleEditFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flPassesContainer, PassVehicleEditFragment.getInstance(passId))
                .addToBackStack("asd")
                .commit();
    }

    public void toLogin() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.putExtra("toLogin", true);
        this.startActivity(intent);
        if (this.getActivity() != null)
            this.getActivity().finish();
    }
}