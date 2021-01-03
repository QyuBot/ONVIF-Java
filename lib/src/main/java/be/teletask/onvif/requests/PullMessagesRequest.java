package be.teletask.onvif.requests;

import be.teletask.onvif.listeners.PullMessagesListener;
import be.teletask.onvif.models.OnvifType;

public class PullMessagesRequest implements OnvifRequest {

    //Constants
    public static final String TAG = PullMessagesRequest.class.getSimpleName();

    //Attributes
    private final PullMessagesListener listener;

    private String subscriptionUrl;
    private String messageLimit;
    private String timeout;
    public PullMessagesRequest(PullMessagesListener listener, String subscriptionUrl, String messageLimit, String timeout) {
        super();
        this.subscriptionUrl = subscriptionUrl;
        this.messageLimit = messageLimit;
        this.timeout = timeout;
        this.listener = listener;
    }

    //Properties
    public PullMessagesListener getListener() {
        return listener;
    }

    @Override
    public String getAddHeader() {
        return " <Action xmlns=\"http://www.w3.org/2005/08/addressing\">" +
                "http://www.onvif.org/ver10/events/wsdl/PullPointSubscription/PullMessagesRequest" +
                "</Action>\n" +
                "<To xmlns:wsa=\"http://www.w3.org/2005/08/addressing\">" +
                subscriptionUrl +
                "</To>";
    }

    @Override
    public String getXml() {        return
                " <PullMessages xmlns=\"http://www.onvif.org/ver10/events/wsdl\" >\n" +
                " <Timeout>" + timeout +"</Timeout>\n" +
                " <MessageLimit>" + messageLimit + "</MessageLimit>\n" +
                " </PullMessages>";
    }

    @Override
    public OnvifType getType() {
        return OnvifType.PULL_MESSAGE;
    }
}
