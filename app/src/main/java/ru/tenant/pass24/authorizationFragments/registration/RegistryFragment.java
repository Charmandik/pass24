package ru.tenant.pass24.authorizationFragments.registration;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Dialog;

public class RegistryFragment extends Fragment {
    private RegistryPresenter registryPresenter;
    private TextInputEditText etRegistryFirstName;
    private TextInputEditText etRegistrySecondName;
    private TextInputEditText etRegistryEmail;
    private TextInputEditText etRegistryPhone;
    private TextInputEditText etRegistryPass;
    private TextInputEditText etRegistryConfirmPass;
    private TextInputLayout tilRegistryFirstName;
    private TextInputLayout tilRegistryLastName;
    private TextInputLayout tilRegistryPhone;
    private TextInputLayout tilRegistryEmail;
    private TextInputLayout tilRegistryPassword;
    private TextInputLayout tilRegistryPasswordConfirm;
    private Switch registrySwitch;
    private Button btnRegistry;
    private TextView tvRegistryToLoginBtn;
    private boolean isAccepted = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registry, container, false);
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
        tilRegistryFirstName = view.findViewById(R.id.tilRegistryFirstName);
        tilRegistryLastName = view.findViewById(R.id.tilRegistryLastName);
        tilRegistryPhone = view.findViewById(R.id.tilRegistryPhone);
        tilRegistryPassword = view.findViewById(R.id.tilRegistryPassword);
        tilRegistryEmail = view.findViewById(R.id.tilRegistryEmail);
        tilRegistryPasswordConfirm = view.findViewById(R.id.tilRegistryPasswordConfirm);
        this.phoneMask(etRegistryPhone);

        registrySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean accept) {
                isAccepted = accept;
            }
        });
        btnRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAccepted) {
                    if (!Objects.requireNonNull(etRegistryPass.getText()).toString().trim().equals(etRegistryConfirmPass.getText().toString().trim())) {
                        tilRegistryPasswordConfirm.setError("Пароли не совпадают");
                    } else {
                        tilRegistryPasswordConfirm.setError("");
                        registryPresenter.checkData(
                                etRegistryFirstName.getText().toString().trim(),
                                etRegistrySecondName.getText().toString().trim(),
                                etRegistryPhone.getText().toString().trim(),
                                etRegistryEmail.getText().toString().trim(),
                                etRegistryPass.getText().toString().trim());
                    }
                } else {
                    showError("Ошибка", "Подвердите согласие на обработку персональных данных");
                }

            }
        });

        tvRegistryToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registryPresenter.toLogin();
            }
        });
    }

    public void showError(String errorTitle, String errorMessage) {
        final Dialog dialog = new Dialog(errorTitle, errorMessage);
        dialog.show(this.getFragmentManager(), "");
    }

    public void showErrorOnFirstName(boolean show, String text) {
        if (show)
            tilRegistryFirstName.setError(text);
        else
            tilRegistryFirstName.setError("");
    }

    public void showErrorOnLastName(boolean show, String text) {
        if (show)
            tilRegistryLastName.setError(text);
        else
            tilRegistryLastName.setError("");
    }

    public void showErrorOnEmail(boolean show, String text) {
        if (show)
            tilRegistryEmail.setError(text);
        else
            tilRegistryEmail.setError("");
    }

    public void showErrorOnPhone(boolean show, String text) {
        if (show)
            tilRegistryPhone.setError(text);
        else
            tilRegistryPhone.setError("");
    }

    public void showErrorOnPassword(boolean show, String text) {
        if (show)
            tilRegistryPassword.setError(text);
        else
            tilRegistryPassword.setError("");
    }

    public void phoneMask(final EditText edTelData) {
        edTelData.addTextChangedListener(new PhoneNumberFormattingTextWatcher() {
            //we need to know if the user is erasing or inputing some new character
            private boolean backspacingFlag = false;
            //we need to block the :afterTextChanges method to be called again after we just replaced the EditText text
            private boolean editedFlag = false;
            //we need to mark the cursor position and restore it after the edition
            private int cursorComplement;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //we store the cursor local relative to the end of the string in the EditText before the edition
                cursorComplement = s.length() - edTelData.getSelectionStart();
                //we check if the user ir inputing or erasing a character
                if (count > after) {
                    backspacingFlag = true;
                } else {
                    backspacingFlag = false;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // nothing to do here =D
            }

            @Override
            public void afterTextChanged(Editable s) {
                String string = s.toString();
                //what matters are the phone digits beneath the mask, so we always work with a raw string with only digits
                String phone = string.replaceAll("[^\\d]", "");

                //if the text was just edited, :afterTextChanged is called another time... so we need to verify the flag of edition
                //if the flag is false, this is a original user-typed entry. so we go on and do some magic
                if (!editedFlag) {

                    //we start verifying the worst case, many characters mask need to be added
                    //example: 999999999 <- 6+ digits already typed
                    // masked: (999) 999-999
                    if (phone.length() >= 9 && !backspacingFlag) {
                        //we will edit. next call on this textWatcher will be ignored
                        editedFlag = true;
                        //here is the core. we substring the raw digits and add the mask as convenient
                        String ans = "7(" + phone.substring(1, 4) + ") " + phone.substring(4, 7) + "-" + phone.substring(7, 9) + "-" + phone.substring(9);
                        edTelData.setText(ans);
                        //we deliver the cursor to its original position relative to the end of the string
                        edTelData.setSelection(edTelData.getText().length() - cursorComplement);

                        //we end at the most simple case, when just one character mask is needed
                        //example: 99999 <- 3+ digits already typed
                        // masked: (999) 99
                    } else if (phone.length() >= 4 && !backspacingFlag) {
                        editedFlag = true;
                        String ans = "7(" + phone.substring(1, 4) + ") " + phone.substring(4);
                        edTelData.setText(ans);
                        edTelData.setSelection(edTelData.getText().length() - cursorComplement);
                    }
                    // We just edited the field, ignoring this cicle of the watcher and getting ready for the next
                } else {
                    editedFlag = false;
                }
            }
        });
    }
}
