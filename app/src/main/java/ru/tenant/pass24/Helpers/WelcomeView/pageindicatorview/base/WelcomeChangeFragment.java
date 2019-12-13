package ru.tenant.pass24.Helpers.WelcomeView.pageindicatorview.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import ru.tenant.pass24.R;

public class WelcomeChangeFragment extends Fragment {

    private TextView welcomeInfo;
    private TextView welcomeInfo2;


    public WelcomeChangeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welcome_1, container, false);

        welcomeInfo = view.findViewById(R.id.tvWelcomeInfo1);
        welcomeInfo2 = view.findViewById(R.id.tvWelcomeInfo1_1);

        if (getArguments().get("type").equals("description")) {
            welcomeInfo.setText(R.string.text_welcome_info_1);
            welcomeInfo2.setText(R.string.text_welcome_info_1_1);
        } else if (getArguments().get("type").equals("invite")) {
            welcomeInfo.setText(R.string.text_welcome_info_2);
            welcomeInfo2.setVisibility(View.INVISIBLE);
         } else if (getArguments().get("type").equals("authority")) {
            welcomeInfo.setText(R.string.text_welcome_info_3_1);
            welcomeInfo2.setText(R.string.text_welcome_info_3_2);
        } else if (getArguments().get("type").equals("go")) {
            welcomeInfo.setText(R.string.text_welcome_info_4);
            welcomeInfo2.setVisibility(View.INVISIBLE);
        }

        return view;
    }
}

