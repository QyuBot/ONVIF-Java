package be.teletask.onvif.requests;

import be.teletask.onvif.listeners.CreatePullPointSubscriptionListener;
import be.teletask.onvif.models.OnvifType;

public class CreatePullSubscriptionRequest implements OnvifRequest {


    //Attributes
    private final CreatePullPointSubscriptionListener listener;

    private String topicExpression;
    private String initialTerminationTime;
    public CreatePullSubscriptionRequest(CreatePullPointSubscriptionListener listener, String topicExpression, String initialTerminationTime) {
        super();
        this.topicExpression = topicExpression;
        this.initialTerminationTime = initialTerminationTime;
        this.listener = listener;
    }

    public CreatePullPointSubscriptionListener getListener() {
        return this.listener;
    }
    @Override
    public String getXml() {
        return  " <CreatePullPointSubscription xmlns=\"http://www.onvif.org/ver10/events/wsdl\">\n" +
                " <Filter>\n" +
                " <TopicExpression\n" +
                " Dialect=\"http://www.onvif.org/ver10/tev/topicExpression/ConcreteSet\" " +
                " xmlns=\"http://docs.oasis-open.org/wsn/b-2\">" +
                this.topicExpression +
                //" tns1:RuleEngine//.\n" +
                "</TopicExpression>\n" +
                " <MessageContent Dialect=\"http://www.onvif.org/ver10/tev/messageContentFilter/ItemFilter\" " +
                " xmlns=\"http://docs.oasis-open.org/wsn/b-2\">\n" +
                " boolean(//tt:SimpleItem[@Name=\"VideoAnalyticsConfigurationToken\"\n" +
                " and @Value=\"2\"] ) and\n" +
                " boolean(//tt:SimpleItem[@Name=\"VideoSourceConfigurationToken\"\n" +
                " and @Value=\"1\"] )\n" +
                " </MessageContent>\n" +
                " </Filter>\n" +
                " <InitialTerminationTime>" +
                this.initialTerminationTime +
                //" PT1M\n" +
                "</InitialTerminationTime>\n" +
                " </CreatePullPointSubscription>";
    }

    @Override
    public OnvifType getType() {
        return OnvifType.CREATE_FULL_POINT_SUBSCRIPTION;
    }

    @Override
    public String getAddHeader() {
        return "<wsa:Action>\n" +
                " http://www.onvif.org/ver10/events/wsdl/EventPortType/CreatePullPointSubscriptionRequest\n" +
                " </wsa:Action>";
    }
}
