package ru.tenant.pass24.ProfileFragments.passes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.ProfileFragments.passes.apiModels.PassesCollection;
import ru.tenant.pass24.R;

public class PassesFragment extends Fragment {
    private PassesPresenter passesPresenter;
    private PassesAdapter mAdapter;
    private RecyclerView rvMyPass;
    private RecyclerView.LayoutManager layoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_pass, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        PassesModel passesModel = new PassesModel();
        passesPresenter = new PassesPresenter(passesModel);
        passesPresenter.attachView(this);

        rvMyPass = view.findViewById(R.id.rvMyPass);
        rvMyPass.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        rvMyPass.setLayoutManager(layoutManager);
        passesModel.getPasses();
    }

    public void setDataForRecycler(List<PassesCollection> passesResponses) {
        mAdapter = new PassesAdapter(passesResponses);
        rvMyPass.setAdapter(mAdapter);
    }
}