package ru.tenant.pass24.profileFragments.requests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.requests.apiModels.RequestCollection;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestAdapterHolder> {
    private List<RequestCollection> requestResponses;

    public RequestAdapter(List<RequestCollection> requestResponses) {
        this.requestResponses = requestResponses;
    }

    @NonNull
    @Override
    public RequestAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_my_request, parent, false);
        return new RequestAdapterHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestAdapterHolder holder, int position) {
        RequestCollection requestCollection = requestResponses.get(position);

        if (requestCollection != null) {
            if (requestCollection.getType() == 1) {
                holder.requestType.setText("Новый адрес");
                if (requestCollection.getRequestData() != null)
                    if (requestCollection.getRequestData().getAddress() != null)
                        holder.requestName.setText(requestCollection.getRequestData().getAddress());
            } else if (requestCollection.getType() == 2) {
                holder.requestType.setText("Постоянный пропуск");
                if (requestCollection.getRequestData() != null)
                    if (requestCollection.getRequestData().getGuestData() != null)
                        if (requestCollection.getRequestData().getGuestData().getPlateNumber() != null) {
                            holder.requestName.setText(requestCollection.getRequestData().getGuestData().getPlateNumber());
                            holder.requestName.setVisibility(View.VISIBLE);
                        }
            } else if (requestCollection.getType() == 3) {
                holder.requestType.setText("Новое доверенное лицо");
                if (requestCollection.getRequestData() != null)
                    if (requestCollection.getRequestData().getConfidant() != null)
                        if (requestCollection.getRequestData().getConfidant().getName() != null) {
                            holder.requestName.setText(requestCollection.getRequestData().getConfidant().getName());
                            holder.requestName.setVisibility(View.VISIBLE);
                        }
            }
            if (requestCollection.getStatus() == 3)
                holder.requestStatus.setBackgroundResource(R.drawable.ic_reject);
        }
    }

    @Override
    public int getItemCount() {
        return requestResponses != null ? requestResponses.size() : 0;
    }

    public static class RequestAdapterHolder extends RecyclerView.ViewHolder {
        public TextView requestName, requestType;
        public ImageView requestStatus;

        public RequestAdapterHolder(ViewGroup viewGroup) {
            super(viewGroup);
            this.requestName = viewGroup.findViewById(R.id.tvMyRequestInfo);
            this.requestType = viewGroup.findViewById(R.id.tvMyRequestType);
            this.requestStatus = viewGroup.findViewById(R.id.ivMyRequestStatus);
        }
    }
}
