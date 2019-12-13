package ru.tenant.pass24.Fragments.RegistryConfirm;

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

public class RegistryConfirmFragment extends Fragment {
    private RegistryConfirmPresenter registryConfirmPresenter;
    private Button btnRegistry;
    private TextView tvSendAgain;
    private EditText etConfirmRegistryCode;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registry_confirm_fragment, container, false);
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
                registryConfirmPresenter.confirmTelephone(etConfirmRegistryCode.getText().toString().trim());
            }
        });

        tvSendAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registryConfirmPresenter.confirmTelephone(etConfirmRegistryCode.getText().toString().trim());
            }
        });
    }
}
