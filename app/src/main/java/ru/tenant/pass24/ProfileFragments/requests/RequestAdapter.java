package ru.tenant.pass24.ProfileFragments.requests;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestAdapterHolder> {

    @NonNull
    @Override
    public RequestAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RequestAdapterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class RequestAdapterHolder extends RecyclerView.ViewHolder {

        public RequestAdapterHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
