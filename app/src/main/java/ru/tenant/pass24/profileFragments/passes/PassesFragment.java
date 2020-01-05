package ru.tenant.pass24.profileFragments.passes;

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
import ru.tenant.pass24.profileFragments.passes.apiModels.PassesCollection;

public class PassesFragment extends Fragment {
    private PassesPresenter passesPresenter;
    private PassesAdapter mAdapter;
    private RecyclerView rvMyPass;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView ivPassAdd, ivPassSetting;
    private Navigation_clicks navigation_clicks;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_pass, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    public void registerCallBack(Navigation_clicks navigation_clicks){
        this.navigation_clicks = navigation_clicks;
    }

    private void init(View view) {
        PassesModel passesModel = new PassesModel();
        passesPresenter = new PassesPresenter(passesModel);
        passesPresenter.attachView(this);

        rvMyPass = view.findViewById(R.id.rvMyPass);
        ivPassAdd = view.findViewById(R.id.ivPassAdd);
        ivPassSetting = view.findViewById(R.id.ivPassSetting);
        rvMyPass.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        rvMyPass.setLayoutManager(layoutManager);
        passesModel.getPasses();


        ivPassAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passesPresenter.toPassOrderFragment();
//                navigation_clicks.toPassOrder();
            }
        });

        ivPassSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void setDataForRecycler(List<PassesCollection> passesResponses) {
        mAdapter = new PassesAdapter(passesResponses);
        rvMyPass.setAdapter(mAdapter);
    }
}