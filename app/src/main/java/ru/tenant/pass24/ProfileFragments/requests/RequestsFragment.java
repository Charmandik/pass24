package ru.tenant.pass24.ProfileFragments.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tenant.pass24.R;

public class RequestsFragment extends Fragment {
    private RequestsPresenter passesPresenter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tools, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        RequestsModel requestsModel = new RequestsModel();
        passesPresenter = new RequestsPresenter(requestsModel);
        passesPresenter.attachView(this);
    }
}