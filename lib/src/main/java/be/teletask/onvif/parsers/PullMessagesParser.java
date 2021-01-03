package be.teletask.onvif.parsers;

import be.teletask.onvif.models.NotificationMessage;
import be.teletask.onvif.models.PullMessages;
import be.teletask.onvif.models.SimpleItem;
import be.teletask.onvif.responses.OnvifResponse;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Eric Hwang 12/31/2020
 * Copyright (c) 2020 VIVANS  All rights reserved.
 */
public class PullMessagesParser extends OnvifParser<PullMessages> {

    //Constants
    public static final String TAG = PullMessagesParser.class.getSimpleName();

    private static final String KEY_CURRENT_TIME = "CurrentTime";
    private static final String KEY_TERMINATION_TIME = "TerminationTime";
    private static final String KEY_NOTIFICATION_ROOT = "NotificationMessage";
    private static final String KEY_NOTI_TOPIC = "Topic";
    private static final String KEY_NOTI_MESSAGE = "Message";
    private static final String KEY_NOTI_ADDRES = "Address";
    private static final String ATTR_UTC_TIME = "UtcTime";
    private static final String ATTR_PROPERTY_OPERATION = "PropertyOperation";
    private static final String KEY_MESSAGE_SOURCE = "Source";
    private static final String KEY_MESSAGE_DATA = "Data";
    private static final String KEY_SIMPLEITEM = "SimpleItem";
    private static final String ATTR_SITEM_NAME = "Name";
    private static final String ATTR_SITEM_VALUE = "Value";

    private SimpleItem parseSimpleItem(String parentTagName, XmlPullParser pullParser) {
        SimpleItem item = new SimpleItem();
        try {
            while (!(eventType == XmlPullParser.END_TAG && pullParser.getName().equals(parentTagName))) {
                if( eventType == XmlPullParser.START_TAG ) {
                    if ( pullParser.getName().equals(KEY_SIMPLEITEM)
                            && pullParser.getAttributeCount() > 0) {
                        for (int i = 0; i < pullParser.getAttributeCount(); i++) {
                            if (pullParser.getAttributeName(i).equals(ATTR_SITEM_NAME)) {
                                item.setName(pullParser.getAttributeValue(i));
                            } else if (pullParser.getAttributeName(i).equals(ATTR_SITEM_VALUE)) {
                                item.setValue(pullParser.getAttributeValue(i));
                            }
                        }
                    }
                }
                eventType = pullParser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    private NotificationMessage parseNotification(XmlPullParser pullParser) {
        NotificationMessage message = new NotificationMessage();
        try {
            while (!(eventType == XmlPullParser.END_TAG && pullParser.getName().equals(KEY_NOTIFICATION_ROOT))) {
                if (eventType == XmlPullParser.START_TAG) {
                    if (pullParser.getName().equals(KEY_NOTI_TOPIC)) {
                        pullParser.next();
                        message.setTopic(pullParser.getText());
                    } else if ( pullParser.getName().equals(KEY_NOTI_ADDRES)) {
                        pullParser.next();
                        message.setAddress(pullParser.getText());
                    } else if ( pullParser.getName().equals(KEY_NOTI_MESSAGE)
                            && pullParser.getAttributeCount() > 0) {
                        for (int i = 0; i < pullParser.getAttributeCount(); i++) {
                            if (pullParser.getAttributeName(i).equals(ATTR_UTC_TIME)) {
                                message.setUtcTime(pullParser.getAttributeValue(i));
                            } else if (pullParser.getAttributeName(i).equals(ATTR_PROPERTY_OPERATION)) {
                                message.setPropertyOperation(pullParser.getAttributeValue(i));
                            }
                        }
                    } else if ( pullParser.getName().equals(KEY_MESSAGE_SOURCE)) {
                        message.setSource(parseSimpleItem(pullParser.getName(), pullParser));
                    } else if ( pullParser.getName().equals(KEY_MESSAGE_DATA)) {
                        message.setData(parseSimpleItem(pullParser.getName(), pullParser));
                    }
                }
                eventType = pullParser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public PullMessages parse(OnvifResponse response) {
        PullMessages pullMessages = new PullMessages();
        try {
            getXpp().setInput(new StringReader(response.getXml()));
            eventType = getXpp().getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if( eventType == XmlPullParser.START_TAG ) {
                    if ( getXpp().getName().equals(KEY_CURRENT_TIME)) {
                        getXpp().next();
                        pullMessages.setCurrentTime(getXpp().getText());
                    } else if ( getXpp().getName().equals(KEY_TERMINATION_TIME)) {
                        getXpp().next();
                        pullMessages.setTerminationTime(getXpp().getText());
                    } else if ( getXpp().getName().equals(KEY_NOTIFICATION_ROOT)) {
                        NotificationMessage message = parseNotification(getXpp());
                        pullMessages.getMessages().add(message);
                    }
                }
                eventType = getXpp().next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return pullMessages;
    }

}
