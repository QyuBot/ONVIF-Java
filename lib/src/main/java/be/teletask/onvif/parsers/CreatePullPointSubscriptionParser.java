package be.teletask.onvif.parsers;

import be.teletask.onvif.models.CreatePullPointSubscription;
import be.teletask.onvif.models.OnvifDeviceInformation;
import be.teletask.onvif.responses.OnvifResponse;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Eric Hwang 12/31/2020
 * Copyright (c) 2020 VIVANS  All rights reserved.
 */
public class CreatePullPointSubscriptionParser extends OnvifParser<CreatePullPointSubscription> {

    //Constants
    public static final String TAG = CreatePullPointSubscriptionParser.class.getSimpleName();
    private static final String KEY_ADDRESS = "Address";
    private static final String KEY_SUBSCRIPTION_ID = "SubscriptionId";
    private static final String KEY_CURRENT_TIME = "CurrentTime";
    private static final String KEY_TERMINATION_TIME = "TerminationTime";

    @Override
    public CreatePullPointSubscription parse(OnvifResponse response) {
        CreatePullPointSubscription subscription = new CreatePullPointSubscription();

        try {
            getXpp().setInput(new StringReader(response.getXml()));
            eventType = getXpp().getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if ( eventType == XmlPullParser.START_TAG ) {
                    if (getXpp().getName().equals(KEY_ADDRESS)) {
                        getXpp().next();
                        subscription.setAddress(getXpp().getText());
                    } else if (getXpp().getName().equals(KEY_SUBSCRIPTION_ID)) {
                        getXpp().next();
                        subscription.setCurrentTime(getXpp().getText());
                    } else if (getXpp().getName().equals(KEY_CURRENT_TIME)) {
                        getXpp().next();
                        subscription.setCurrentTime(getXpp().getText());
                    } else if (getXpp().getName().equals(KEY_TERMINATION_TIME)) {
                        getXpp().next();
                        subscription.setTerminationTime(getXpp().getText());
                    }
                }
                eventType = getXpp().next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return subscription;
    }

}
