package be.teletask.onvif.requests;

import be.teletask.onvif.listeners.OnvifPresetsListener;
import be.teletask.onvif.models.OnvifMediaProfile;
import be.teletask.onvif.models.OnvifType;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Luke F on 02/12/2020.
 */
@Getter
@NoArgsConstructor
public class GetPresetsRequest implements OnvifRequest {

    //Constants
    public static final String TAG = GetPresetsRequest.class.getSimpleName();

    //Attributes
    private OnvifPresetsListener listener;
    private OnvifMediaProfile mediaProfile;

    //Constructors
    public GetPresetsRequest(OnvifMediaProfile mediaProfile, OnvifPresetsListener listener) {
        this.mediaProfile = mediaProfile;
        this.listener = listener;
    }

    //Properties

    @Override
    public String getXml() {
        return "<GetPresets xmlns=\"http://www.onvif.org/ver20/ptz/wsdl\">" +
                "<ProfileToken>" + mediaProfile.getToken() + "</ProfileToken>" +
                "</GetPresets>";
    }

    @Override
    public OnvifType getType() {
        return OnvifType.GET_PRESETS;
    }

    @Override
    public String getAddHeader() {
        return null;
    }

}
