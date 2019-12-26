package ru.tenant.pass24.ProfileFragments.passes;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.ProfileFragments.passes.apiModels.PassesResponseBody;

public class PassesAdapter extends RecyclerView.Adapter<PassesAdapter.PassesAdapterHolder> {
    private List<PassesResponseBody> passesResponses;

    public PassesAdapter(List<PassesResponseBody> passesResponses) {
        this.passesResponses = passesResponses;
    }

    @NonNull
    @Override
    public PassesAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PassesAdapterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class PassesAdapterHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public PassesAdapterHolder(TextView v) {
            super(v);
            textView = v;
        }
    }
}
