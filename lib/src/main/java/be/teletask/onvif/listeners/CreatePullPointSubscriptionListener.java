package be.teletask.onvif.listeners;

import be.teletask.onvif.models.CreatePullPointSubscription;
import be.teletask.onvif.models.OnvifDevice;

/**
 * Created by Eric Hwang 12/31/2020
 * Copyright (c) 2020 VIVANS  All rights reserved.
 */
public interface CreatePullPointSubscriptionListener {
    void onCreatePullPointSubscriptionResponseReceived(OnvifDevice device, CreatePullPointSubscription createPullPointSubscriptionResponse);
}
