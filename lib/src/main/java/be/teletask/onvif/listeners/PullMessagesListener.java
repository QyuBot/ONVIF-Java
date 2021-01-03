package be.teletask.onvif.listeners;

import be.teletask.onvif.models.OnvifDevice;
import be.teletask.onvif.models.PullMessages;

/**
 * Created by Eric Hwang 12/31/2020
 * Copyright (c) 2020 VIVANS  All rights reserved.
 */
public interface PullMessagesListener {
    void onPullMessagesResponseReceived(OnvifDevice device, PullMessages pullMessageResponse);
}
