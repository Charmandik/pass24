package ru.tenant.pass24.profileFragments.trustedPeople;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.trustedPeople.apiModels.ConfidanceCollection;

public class TrustedPeopleFragment extends Fragment {
    private TrustedPeoplePresenter trustedPeoplePresenter;
    private ImageView ivTrustAdd;
    private RecyclerView rvTrustPeople;
    private RecyclerView.LayoutManager layoutManager;
    private ConfidanceAdapter mAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trust_people, container, false);
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
        trustedPeopleModel.getConfidances();

        ivTrustAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void setDataForRecycler(List<ConfidanceCollection> confidanceCollections) {
        layoutManager = new LinearLayoutManager(getContext());
        rvTrustPeople.setLayoutManager(layoutManager);
        mAdapter = new ConfidanceAdapter(confidanceCollections,getFragmentManager());
        rvTrustPeople.setAdapter(mAdapter);
    }
}