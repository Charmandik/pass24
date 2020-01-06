package ru.tenant.pass24.helpers;

import ru.tenant.pass24.authorizationFragments.Registration.apiModels.RegistryCheckRequestBody;

public class Constants {
    public static String authToken = "";
    public static String confirmPhoneToken = "";
    public static RegistryCheckRequestBody registryBody;
    public static int objectJoinType = 1;
    public static int passJoinType = 2;
    public static int confidanceType = 3;
    public static int vehicleTypeLight = 1;
    public static int vehicleTypeNormal = 2;
    public static int vehicleTypeHeavy = 3;
    public static int vehicleTypeSuperHeavy = 4;

    public static int SINGLE_USE_PASS = 1;
    public static int TEMPORARY_PASS = 2;

    public static String getAuthToken() {
        return "Bearer " + authToken;
    }
}
