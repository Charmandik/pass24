package ru.tenant.pass24.profileFragments.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.profileFragments.profile.changePassword.ChangePasswordFragment;

public class ProfileFragment extends Fragment {
    private TextView tvUserLastName, tvUserFirstName, tvUserMiddleName, tvProfileChangePass;
    private ImageView btnBack;
    private ProfileFragment mInstance;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstance = this;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        tvUserLastName = view.findViewById(R.id.tvUserLastName);
        tvUserFirstName = view.findViewById(R.id.tvUserFirstName);
        tvUserMiddleName = view.findViewById(R.id.tvUserMiddleName);
        tvProfileChangePass = view.findViewById(R.id.tvProfileChangePass);
        btnBack = view.findViewById(R.id.btnBack);

        tvUserLastName.setText(Constants.userLastName);
        tvUserFirstName.setText(Constants.userFirstName);
        tvUserMiddleName.setText("");

        tvProfileChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toChangPasswordFragment();
            }
        });
    }

    private void toChangPasswordFragment() {
        if (getFragmentManager() != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flProfileContainer, new ChangePasswordFragment())
                    .commit();
        }
    }
}
