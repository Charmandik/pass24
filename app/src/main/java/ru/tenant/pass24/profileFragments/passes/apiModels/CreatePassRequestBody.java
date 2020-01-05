package ru.tenant.pass24.profileFragments.passes.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels.CreateVehiclePassRequest;

public class CreatePassRequestBody {
    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("requestData")
    @Expose
    private CreateVehiclePassRequest requestData;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public CreateVehiclePassRequest getRequestData() {
        return requestData;
    }

    public void setRequestData(CreateVehiclePassRequest requestData) {
        this.requestData = requestData;
    }
}
