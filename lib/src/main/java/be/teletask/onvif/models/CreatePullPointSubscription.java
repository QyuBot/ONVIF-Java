package be.teletask.onvif.models;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Eric Hwang 12/31/2020
 * Copyright (c) 2020 VIVANS  All rights reserved.
 */
@Data
@NoArgsConstructor
public class CreatePullPointSubscription {

    //Constants
    public static final String TAG = CreatePullPointSubscription.class.getSimpleName();

    //Attributes
    private String address;
    private String subscriptionId;
    private String currentTime;
    private String terminationTime;

    //Constructors
    //Properties
    @Override
    public String toString() {
        return "CreatePullPointSubscriptionResponse{" +
                "address='" + address + '\'' +
                ", subscriptionId='" + subscriptionId + '\'' +
                ", currentTime='" + currentTime + '\'' +
                ", terminationTime='" + terminationTime + '\'' +
                '}';
    }


}
