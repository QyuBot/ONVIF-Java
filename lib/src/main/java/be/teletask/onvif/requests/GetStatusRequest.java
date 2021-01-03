package be.teletask.onvif.requests;

import be.teletask.onvif.listeners.OnvifStatusListener;
import be.teletask.onvif.models.OnvifMediaProfile;
import be.teletask.onvif.models.OnvifType;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Luke F on 07/08/2020.
 */
@Getter
@NoArgsConstructor
public class GetStatusRequest implements OnvifRequest {

    //Constants
    public static final String TAG = GetStatusRequest.class.getSimpleName();

    //Attributes
    private OnvifStatusListener listener;
    private OnvifMediaProfile mediaProfile;

    //Constructors
    public GetStatusRequest(OnvifMediaProfile mediaProfile, OnvifStatusListener listener) {
        this.mediaProfile = mediaProfile;
        this.listener = listener;
    }

    //Properties

    @Override
    public String getXml() {
        return "<GetStatus xmlns=\"http://www.onvif.org/ver20/ptz/wsdl\">" +
                "<ProfileToken>" + mediaProfile.getToken() + "</ProfileToken>" +
                "</GetStatus>";
    }

    @Override
    public OnvifType getType() {
        return OnvifType.GET_STATUS;
    }

    @Override
    public String getAddHeader() {
        return null;
    }

}
