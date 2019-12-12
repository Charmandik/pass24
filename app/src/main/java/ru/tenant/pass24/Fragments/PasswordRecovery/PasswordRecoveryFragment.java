package ru.tenant.pass24.Fragments.PasswordRecovery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class PasswordRecoveryFragment extends Fragment {
    private PasswordRecoveryPresenter passwordRecoveryPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.password_recovery_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        PasswordRecoveryModel passwordRecoveryModel = new PasswordRecoveryModel();
        passwordRecoveryPresenter = new PasswordRecoveryPresenter(passwordRecoveryModel);
        passwordRecoveryPresenter.attachView(this);
    }
}
