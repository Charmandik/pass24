package ru.tenant.pass24.AuthorizationFragments.PasswordRecovery;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import ru.tenant.pass24.Helpers.Dialog;
import ru.tenant.pass24.R;

public class PasswordRecoveryFragment extends Fragment {
    private PasswordRecoveryPresenter passwordRecoveryPresenter;
    private TextView tvBackToLogin;
    private Button btnRegistry;
    private EditText etPhone;
    private TextInputLayout tilRegistryPhone;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_password_recovery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        PasswordRecoveryModel passwordRecoveryModel = new PasswordRecoveryModel();
        passwordRecoveryPresenter = new PasswordRecoveryPresenter(passwordRecoveryModel);
        passwordRecoveryPresenter.attachView(this);
        tvBackToLogin = view.findViewById(R.id.tvBackToLogin);
        btnRegistry = view.findViewById(R.id.btnRegistry);
        etPhone = view.findViewById(R.id.etPhone);
        tilRegistryPhone = view.findViewById(R.id.tilRegistryPhone);
        this.phoneMask(etPhone);

        btnRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordRecoveryPresenter.sendConfirmPhone(etPhone.getText().toString());
            }
        });
        tvBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordRecoveryPresenter.toLogin();
            }
        });
    }

    public void showError(String errorTitle, String errorMessage) {
        final Dialog dialog = new Dialog(errorTitle, errorMessage);
        dialog.show(this.getFragmentManager(), "");
    }

    public void showErrorOnPhone(boolean show, String text) {
        if (show)
            tilRegistryPhone.setError(text);
        else
            tilRegistryPhone.setError("");
    }

    public void phoneMask(final EditText edTelData){
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
                cursorComplement = s.length()-edTelData.getSelectionStart();
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
                        String ans = "7(" + phone.substring(1, 4) + ") " + phone.substring(4,7) + "-" + phone.substring(7,9) + "-" + phone.substring(9);
                        edTelData.setText(ans);
                        //we deliver the cursor to its original position relative to the end of the string
                        edTelData.setSelection(edTelData.getText().length()-cursorComplement);

                        //we end at the most simple case, when just one character mask is needed
                        //example: 99999 <- 3+ digits already typed
                        // masked: (999) 99
                    } else if (phone.length() >= 4 && !backspacingFlag) {
                        editedFlag = true;
                        String ans = "7(" +phone.substring(1, 4) + ") " + phone.substring(4);
                        edTelData.setText(ans);
                        edTelData.setSelection(edTelData.getText().length()-cursorComplement);
                    }
                    // We just edited the field, ignoring this cicle of the watcher and getting ready for the next
                } else {
                    editedFlag = false;
                }
            }
        });
    }
}
