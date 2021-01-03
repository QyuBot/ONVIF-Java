package be.teletask.onvif.models;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Eric Hwang 12/31/2020
 * Copyright (c) 2020 VIVANS  All rights reserved.
 */
@Data
@NoArgsConstructor
public class NotificationMessage {

    //Constants
    public static final String TAG = NotificationMessage.class.getSimpleName();

    //Attributes
    private String topic;
    private String address;

    /*Message*/
    private String utcTime;
    private String propertyOperation;

    /*Item*/
    private String key;
    private SimpleItem source;
    private SimpleItem data;

    //Constructors

    //Properties

    @Override
    public String toString() {
        return "NotificationMessage{" +
                "topic='" + topic + '\'' +
                ", utcTime='" + utcTime + '\'' +
                ", address='" + address + '\'' +
                ", propertyOperation='" + propertyOperation + '\'' +
                ", key='" + key + '\'' +
                ", source='" + source + '\'' +
                ", data='" + data + '\'' +
                '}';
    }



}
