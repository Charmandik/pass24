package ru.tenant.pass24.profileFragments.profile.changePassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.retrofit.ApiService;
import ru.tenant.pass24.profileFragments.profile.ProfileFragment;
import ru.tenant.pass24.profileFragments.profile.changePassword.apiModels.PasswordChangeResponse;

public class ChangePasswordFragment extends Fragment {
    private ImageView btnBack;
    private Button btnChangePass;
    private TextInputEditText etOldPassword, etNewPass, etNewPassConfirm;
    private TextInputLayout tilNewPass, tilNewPassConfirm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_change_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        btnBack = view.findViewById(R.id.btnBack);
        btnChangePass = view.findViewById(R.id.btnChangePass);
        etOldPassword = view.findViewById(R.id.etOldPassword);
        etNewPass = view.findViewById(R.id.etNewPass);
        etNewPassConfirm = view.findViewById(R.id.etNewPassConfirm);
        tilNewPass = view.findViewById(R.id.tilNewPass);
        tilNewPassConfirm = view.findViewById(R.id.tilNewPassConfirm);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toProfileFragment();
            }
        });

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Objects.requireNonNull(etNewPass.getText()).toString().trim().equals(etNewPassConfirm.getText().toString().trim())) {
                    tilNewPassConfirm.setError("Пароли не совпадают");
                } else {
                    tilNewPassConfirm.setError("");
                    changePassword();
                    toProfileFragment();//todo delete this if method on backend will start working
                }
            }
        });
    }

    public void changePassword() {
        ApiService.getInstance().getProfileApi().changePassword(Constants.getAuthToken(), etNewPassConfirm.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PasswordChangeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(PasswordChangeResponse passwordChangeResponse) {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private void toProfileFragment() {
        if (getFragmentManager() != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flProfileContainer, new ProfileFragment())
                    .commit();
        }
    }
}
