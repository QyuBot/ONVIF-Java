package be.teletask.onvif.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Eric Hwang 12/31/2020
 * Copyright (c) 2020 VIVANS  All rights reserved.
 */
@Data
@NoArgsConstructor
public class PullMessages {

    //Constants
    public static final String TAG = PullMessages.class.getSimpleName();

    //Attributes
    private String currentTime;
    private String terminationTime;

    private List<NotificationMessage> messages = new CopyOnWriteArrayList<>();

    //Constructors

    //Properties
    @Override
    public String toString() {
        return "PullMessagesResponse{" +
                "currentTime='" + currentTime + '\'' +
                ", terminationTime='" + terminationTime + '\'' +
                ", message='" + messages + '\'' +
                '}';
    }

}
