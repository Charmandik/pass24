package ru.tenant.pass24.WelcomeView.rd.pageindicatorview.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;
import ru.tenant.pass24.WelcomeView.rd.PageIndicatorView;

public class WelcomeFragments extends Fragment {

    private TextView TextViewInfoFirst;
    private TextView TextViewInfoSecond;
    private TextView TextViewSkip;
    private Button GoButton;
    private PageIndicatorView pageIndicatorView;

    public WelcomeFragments() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welcome_1, container, false);

        TextViewInfoFirst = view.findViewById(R.id.tvWelcomeInfo1);
        TextViewInfoSecond = view.findViewById(R.id.tvWelcomeInfo1_1);
        TextViewSkip = view.findViewById(R.id.tvWelcomeSkip);
        GoButton = view.findViewById(R.id.btnWelcomeGo);
        pageIndicatorView = view.findViewById(R.id.pageIndicatorView);

        if (getArguments().get("type").equals("description")) {
            TextViewInfoFirst.setText("1");
            TextViewInfoFirst.setText(R.string.text_welcome_info_1);
            TextViewInfoSecond.setText(R.string.text_welcome_info_1_1);
        } else if (getArguments().get("type").equals("invite")) {
            TextViewInfoFirst.setText("2");
            TextViewInfoFirst.setText(R.string.text_welcome_info_2);
            TextViewInfoSecond.setVisibility(View.INVISIBLE);

         } else if (getArguments().get("type").equals("authority")) {
            TextViewInfoFirst.setText("3");
            TextViewInfoFirst.setText(R.string.text_welcome_info_3_1);
            TextViewInfoSecond.setText(R.string.text_welcome_info_3_2);
        } else if (getArguments().get("type").equals("go")) {
            TextViewInfoFirst.setText("4");
            TextViewInfoFirst.setText(R.string.text_welcome_info_4);
            TextViewInfoSecond.setVisibility(View.INVISIBLE);
        }

        if (getArguments().getBoolean("last_page", false)) {
            TextViewSkip.setVisibility(View.INVISIBLE);
            GoButton.setVisibility(View.VISIBLE);
            GoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else {
            GoButton.setVisibility(View.GONE);
            TextViewSkip.setVisibility(View.VISIBLE);
            TextViewSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        return view;
    }
}

