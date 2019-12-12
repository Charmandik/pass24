package ru.tenant.pass24.WelcomeView.rd.pageindicatorview.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class PageFragment extends Fragment {


    private TextView TextViewExample;


    public PageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welcome_1, container, false);

        TextViewExample = view.findViewById(R.id.tvWelcomeInfo1);

        if (getArguments().get("type").equals("main_page")) {
            TextViewExample.setText("Первый экран");
        } else if (getArguments().get("type").equals("suspencion")) {
            TextViewExample.setText("Второй экран");
         }

//        if (getArguments().getBoolean("last_page", false)) {
//            mTextViewStart.setVisibility(View.VISIBLE);
//            mTextViewStart.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    if (isPinNeeded()) {
//                        startActivity(new Intent(getActivity(), PinPFActivity.class));
//                    } else {
//                        if (dbUtils.userNotEmpty(BaseApp.getRealm())) {
//                            startActivity(new Intent(getActivity(), SplashActivity.class));
//                        } else {
//                            startActivity(new Intent(getActivity(), LoginActivity.class));
//                        }
//                    }
//                }
//            });
//        } else {
//            mTextViewStart.setVisibility(View.GONE);
//        }

        return view;
    }

//    public boolean isPinNeeded() {
//        if (BaseApp.getSharedPref().getBoolean(Constants.PIN_CODE_BOOL_PREF, false)) {
//            return !BaseApp.getSharedPref().getString(Constants.PIN_CODE_PREF, "0").equals("0");
//        }
//        return false;
//    }


}

