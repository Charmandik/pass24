package ru.tenant.pass24.Registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import ru.tenant.pass24.R;

public class RegistryFragment extends Fragment {
    private RegistryPresenter registryPresenter;
    private TextInputEditText etRegistryFirstName;
    private TextInputEditText etRegistrySecondName;
    private TextInputEditText etRegistryEmail;
    private TextInputEditText etRegistryPhone;
    private TextInputEditText etRegistryPass;
    private TextInputEditText etRegistryConfirmPass;
    private Switch registrySwitch;
    private Button btnRegistry;
    private TextView tvRegistryToLoginBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registry_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registryPresenter = new RegistryPresenter(new RegistryModel());
        registryPresenter.attachView(this);
        initViews(view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        registryPresenter.detachView();
    }

    private void initViews(View view) {
        etRegistryFirstName = view.findViewById(R.id.etRegistryFirstName);
        etRegistrySecondName = view.findViewById(R.id.etRegistrySecondName);
        etRegistryEmail = view.findViewById(R.id.etRegistryEmail);
        etRegistryPhone = view.findViewById(R.id.etRegistryPhone);
        etRegistryPass = view.findViewById(R.id.etRegistryPass);
        etRegistryConfirmPass = view.findViewById(R.id.etRegistryConfirmPass);
        registrySwitch = view.findViewById(R.id.registrySwitch);
        btnRegistry = view.findViewById(R.id.btnRegistry);
        tvRegistryToLoginBtn = view.findViewById(R.id.tvRegistryToLoginBtn);

        btnRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDataValid())
                    registryPresenter.checkData(
                            etRegistryFirstName.getText().toString().trim(),
                            etRegistrySecondName.getText().toString().trim(),
                            etRegistryPhone.getText().toString().trim(),
                            etRegistryEmail.getText().toString().trim(),
                            etRegistryPass.getText().toString().trim());
            }
        });
    }

    private boolean isDataValid() {
        if (etRegistryFirstName.getText().toString().equals("")) {
            return false;
        }
        if (etRegistrySecondName.getText().toString().equals("")) {
            return false;
        }
        if (etRegistryEmail.getText().toString().equals("")) {
            return false;
        }
        if (etRegistryPhone.getText().toString().equals("")) {
            return false;
        }
        if (etRegistryPass.getText().toString().equals("")) {
            return false;
        }
        if (etRegistryConfirmPass.getText().toString().equals("")) {
            return false;
        }
        if (!etRegistryConfirmPass.getText().toString().trim().equals(etRegistryPass.getText().toString().trim())) {
            return false;
        }
        return true;
    }
}
