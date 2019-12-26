package ru.tenant.pass24.ProfileFragments.requests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tenant.pass24.ProfileFragments.requests.apiModels.CollectionRequestData;
import ru.tenant.pass24.ProfileFragments.requests.apiModels.RequestCollection;
import ru.tenant.pass24.ProfileFragments.requests.apiModels.RequestResponse;
import ru.tenant.pass24.ProfileFragments.requests.apiModels.RequestResponseBody;
import ru.tenant.pass24.R;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestAdapterHolder> {
    private List<RequestCollection> requestResponses;
    public RequestAdapter(List<RequestCollection> requestResponses) {
        this.requestResponses = requestResponses;
    }

    @NonNull
    @Override
    public RequestAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.my_request_item, parent, false);
        return new RequestAdapterHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestAdapterHolder holder, int position) {
        RequestCollection requestCollection = requestResponses.get(position);

        if (requestCollection != null) {
            holder.requestName.setText(requestCollection.getRequestData().getAddress());

            if (requestCollection.getType() == 1) {
                holder.requestType.setText("на присоединение к объекту");
            } else if (requestCollection.getType() == 2) {
                holder.requestType.setText("на новый пропуск");
            } else if (requestCollection.getType() == 3) {
                holder.requestType.setText("на договоренность");
            }

            if (requestCollection.getStatus() == 1) {
                holder.requestStatus.setImageResource(R.drawable.ic_accept_status);
            }   else if (requestCollection.getStatus() == 2) {
                holder.requestStatus.setImageResource(R.drawable.ic_accept_status);
            } else if (requestCollection.getStatus() == 3) {
                holder.requestStatus.setImageResource(R.drawable.ic_accept_status);
            }
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class RequestAdapterHolder extends RecyclerView.ViewHolder {
        public TextView requestName, requestType;
        public ImageView requestStatus;

        public RequestAdapterHolder(ViewGroup viewGroup) {
            super(viewGroup);
            this.requestName = viewGroup.findViewById(R.id.tvMyRequestName);
            this.requestType = viewGroup.findViewById(R.id.tvMyRequestType);
            this.requestStatus = viewGroup.findViewById(R.id.ivMyRequestStatus);
        }
    }
}
