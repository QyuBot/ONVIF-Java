package be.teletask.onvif.requests;

import be.teletask.onvif.listeners.OnvifResponseListener;
import be.teletask.onvif.models.OnvifMediaProfile;
import be.teletask.onvif.models.OnvifType;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Luke F on 07/08/2020.
 */
@Getter
@NoArgsConstructor
public class AbsoluteMoveRequest implements OnvifRequest {

    //Constants
    public static final String TAG = AbsoluteMoveRequest.class.getSimpleName();

    //Attributes
    private OnvifResponseListener listener;
    private OnvifMediaProfile mediaProfile;
    private double pan = 0, tilt = 0, zoom = 0;

    //Constructors
    public AbsoluteMoveRequest(OnvifMediaProfile mediaProfile, double pan, double tilt, double zoom) {
        this.mediaProfile = mediaProfile;
        this.pan = pan;
        this.tilt = tilt;
        this.zoom = zoom;
    }

    public AbsoluteMoveRequest(OnvifMediaProfile mediaProfile, double pan, double tilt, double zoom, OnvifResponseListener listener) {
        this.mediaProfile = mediaProfile;
        this.pan = pan;
        this.tilt = tilt;
        this.zoom = zoom;
        this.listener = listener;
    }

    //Properties

    @Override
    public String getXml() {
        return "<AbsoluteMove xmlns=\"http://www.onvif.org/ver20/ptz/wsdl\">" +
                "<ProfileToken>" + mediaProfile.getToken() + "</ProfileToken>" +
                "<Position> " +
                "<PanTilt x=\"" + pan + "\" y=\"" + tilt + "\" xmlns=\"http://www.onvif.org/ver10/schema\" />" +
                "<Zoom x=\"" + zoom + "\" xmlns=\"http://www.onvif.org/ver10/schema\" />" +
                "</Position>" +
                "</AbsoluteMove>";
    }

    @Override
    public OnvifType getType() {
        return OnvifType.ABSOLUTE_MOVE;
    }

    @Override
    public String getAddHeader() {
        return null;
    }

}
