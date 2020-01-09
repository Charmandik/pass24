package ru.tenant.pass24.profileFragments.passes;

import android.content.Intent;

import androidx.fragment.app.FragmentManager;

import java.util.List;

import ru.tenant.pass24.MainActivity;
import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.passes.apiModels.PassesCollection;

public class PassesPresenter {
    private final PassesModel model;
    private PassesFragment view;
    private FragmentManager fragmentManager;

    public PassesPresenter(PassesModel model) {
        this.model = model;
        if (model != null)
            model.passesPresenter = this;
    }

    public void attachView(PassesFragment passesFragment) {
        view = passesFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
    }

    public void detachView() {
        view = null;
    }

    public void onDataLoaded(List<PassesCollection> passesResponses) {
        view.setDataForRecycler(passesResponses);
    }

    public void toPassOrderFragment() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flPassesContainer, new PassOrderFragment())
                .addToBackStack("asd")
                .commit();
    }

    public void toPassesFilter() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flPassesContainer, new PassesFilterFragment())
                .addToBackStack("asd")
                .commit();
    }

    public void toLogin() {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        intent.putExtra("toLogin", true);
        view.startActivity(intent);
        if (view.getActivity() != null)
            view.getActivity().finish();
    }
}
