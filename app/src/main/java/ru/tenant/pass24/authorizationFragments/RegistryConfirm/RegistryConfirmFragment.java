package ru.tenant.pass24.authorizationFragments.RegistryConfirm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Dialog;

public class RegistryConfirmFragment extends Fragment {
    public String phone;
    private RegistryConfirmPresenter registryConfirmPresenter;
    private Button btnRegistry;
    private TextView tvSendAgain;
    private EditText etConfirmRegistryCode;
    private boolean fromRecovery = false;

    public RegistryConfirmFragment(String phone) {
        this.phone = phone;
    }

    public RegistryConfirmFragment(String phone, boolean fromRecovery) {
        this.fromRecovery = fromRecovery;
        this.phone = phone;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registry_confirm, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        RegistryConfirmModel passwordRecoveryModel = new RegistryConfirmModel();
        registryConfirmPresenter = new RegistryConfirmPresenter(passwordRecoveryModel);
        registryConfirmPresenter.attachView(this);
        btnRegistry = view.findViewById(R.id.btnRegistry);
        tvSendAgain = view.findViewById(R.id.tvSendAgain);
        etConfirmRegistryCode = view.findViewById(R.id.etConfirmRegistryCode);

        btnRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registryConfirmPresenter.confirmTelephone(phone, etConfirmRegistryCode.getText().toString().trim(), fromRecovery);
            }
        });

        tvSendAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registryConfirmPresenter.sendConfirmPhone(phone);
            }
        });
    }

    public void showError(String errorTitle, String errorMessage) {
        final Dialog dialog = new Dialog(errorTitle, errorMessage);
        dialog.show(this.getFragmentManager(), "");
    }
}
