package ru.tenant.pass24.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class LoginFragment extends Fragment {


    private EditText etLoginPhone;
    private EditText etLoginPass;
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

            }
        });

    }

}
