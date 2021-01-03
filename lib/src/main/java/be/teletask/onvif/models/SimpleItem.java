package be.teletask.onvif.models;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Eric Hwang 12/31/2020
 * Copyright (c) 2020 VIVANS  All rights reserved.
 */
@Data
@NoArgsConstructor
public class SimpleItem {

    //Constants
    public static final String TAG = SimpleItem.class.getSimpleName();

    //Attributes
    private String name;
    private String value;
    //Constructors
    //Properties
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
