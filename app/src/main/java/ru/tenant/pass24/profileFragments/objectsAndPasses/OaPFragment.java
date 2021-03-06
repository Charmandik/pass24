package ru.tenant.pass24.profileFragments.objectsAndPasses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class OaPFragment extends Fragment {
    private OaPPresenter oaPPresenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_share, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        OaPModel oaPModel = new OaPModel();
        oaPPresenter = new OaPPresenter(oaPModel);
        oaPPresenter.attachView(this);
    }
}