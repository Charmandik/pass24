package ru.tenant.pass24.profileFragments.requests;

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
import ru.tenant.pass24.profileFragments.requests.apiModels.RequestCollection;

public class RequestsFragment extends Fragment {
    private RequestsPresenter passesPresenter;
    private ImageView ivRequestSetting;
    private ImageView ivRequestAdd;
    private RecyclerView rvMyRequest;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_request, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        RequestsModel requestsModel = new RequestsModel();
        passesPresenter = new RequestsPresenter(requestsModel);
        passesPresenter.attachView(this);

        ivRequestSetting = view.findViewById(R.id.ivRequestSetting);
        ivRequestAdd = view.findViewById(R.id.ivRequestAdd);

        rvMyRequest = view.findViewById(R.id.rvMyRequest);
        rvMyRequest.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        rvMyRequest.setLayoutManager(layoutManager);
        requestsModel.getRequest();

        ivRequestAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passesPresenter.toRequestsAdd();
            }
        });

        ivRequestSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passesPresenter.toRequestsFilter();
            }
        });

    }

    public void setDataForRecycler(List<RequestCollection> requestResponses) {
        RequestAdapter requestAdapter = new RequestAdapter(requestResponses);
        rvMyRequest.setAdapter(requestAdapter);
    }
}