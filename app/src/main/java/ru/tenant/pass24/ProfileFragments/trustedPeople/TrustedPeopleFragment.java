package ru.tenant.pass24.ProfileFragments.trustedPeople;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import ru.tenant.pass24.R;

public class TrustedPeopleFragment extends Fragment {
    private TrustedPeoplePresenter trustedPeoplePresenter;
    private ImageView ivTrustAdd;
    private RecyclerView rvTrustPeople;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trust_people_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        TrustedPeopleModel trustedPeopleModel = new TrustedPeopleModel();
        trustedPeoplePresenter = new TrustedPeoplePresenter(trustedPeopleModel);
        trustedPeoplePresenter.attachView(this);

        ivTrustAdd = view.findViewById(R.id.ivTrustAdd);
        rvTrustPeople = view.findViewById(R.id.rvTrustPeople);
    }
}