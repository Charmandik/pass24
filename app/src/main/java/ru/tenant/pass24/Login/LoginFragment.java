package ru.tenant.pass24.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import ru.tenant.pass24.Helpers.Dialog;
import ru.tenant.pass24.R;

public class LoginFragment extends Fragment {
    private TextInputLayout etLoginPhone;
    private TextInputLayout etLoginPass;
    private Button btnLoginEnter;
    private LoginPresenter loginPresenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        LoginModel loginModel = new LoginModel();
        loginPresenter = new LoginPresenter(loginModel);
        loginPresenter.attachView(this);

        View view = this.getView();
        if (view != null) {
            etLoginPhone = view.findViewById(R.id.etLoginPhone);
            etLoginPass = view.findViewById(R.id.etLoginPass);
            btnLoginEnter = view.findViewById(R.id.btnLoginEnter);
        }
        btnLoginEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login(etLoginPhone.getEditText().getText().toString().trim(), etLoginPass.getEditText().getText().toString().trim());
            }
        });
    }

    public void showError(String errorTitle, String errorMessage) {
        final Dialog dialog = new Dialog(errorTitle, errorMessage);
        dialog.show(this.getFragmentManager(), "");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView();
    }
}
