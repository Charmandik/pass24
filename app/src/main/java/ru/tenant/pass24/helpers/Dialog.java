package ru.tenant.pass24.helpers;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import ru.tenant.pass24.R;

public class Dialog extends DialogFragment {
    private LayoutInflater layoutInflater;
    private View view;
    private String title;
    private String message;
    private String positiveBtnText;
    private String negativeBtnText;
    private String neutralBtnText;
    private Button positiveBtn;
    private Button negativeBtn;
    private Button neutralBtn;
    private TextView dialogTitle;
    private TextView dialogMessage;

    public Dialog(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public Dialog(String title, String message, String neutralBtnText) {
        this.title = title;
        this.message = message;
        this.neutralBtnText = neutralBtnText;
    }

    public Dialog(String title, String message, String positiveBtnText, String negativeBtnText) {
        this.title = title;
        this.message = message;
        this.positiveBtnText = positiveBtnText;
        this.negativeBtnText = negativeBtnText;
    }


    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        layoutInflater = getActivity().getLayoutInflater();
        view = layoutInflater.inflate(R.layout.alert_dialog, null);
        configureViews(view);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        return builder.create();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutInflater = getActivity().getLayoutInflater();
        view = layoutInflater.inflate(R.layout.alert_dialog, null);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void configureViews(View view) {
        positiveBtn = view.findViewById(R.id.btnPositive);
        negativeBtn = view.findViewById(R.id.btnNegative);
        neutralBtn = view.findViewById(R.id.btnNeutral);
        dialogTitle = view.findViewById(R.id.dialog_title);
        dialogMessage = view.findViewById(R.id.dialog_message);

        if (this.title != null)
            dialogTitle.setText(this.title);
        if (this.message != null)
            dialogMessage.setText(this.message);

        if (positiveBtnText == null && negativeBtnText == null) {
            positiveBtn.setVisibility(View.GONE);
            negativeBtn.setVisibility(View.GONE);
            neutralBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog.super.dismiss();
                }
            });
        } else {
            positiveBtn.setVisibility(View.VISIBLE);
            negativeBtn.setVisibility(View.VISIBLE);
            neutralBtn.setVisibility(View.GONE);

            positiveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            negativeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog.super.dismiss();
                }
            });
        }
    }
}
