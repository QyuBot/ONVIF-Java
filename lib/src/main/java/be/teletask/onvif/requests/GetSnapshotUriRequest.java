package be.teletask.onvif.requests;

import be.teletask.onvif.listeners.OnvifSnapshotURIListener;
import be.teletask.onvif.models.OnvifMediaProfile;
import be.teletask.onvif.models.OnvifType;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Luke F on 07/08/2020.
 */
@Getter
@NoArgsConstructor
public class GetSnapshotUriRequest implements OnvifRequest {

    //Constants
    public static final String TAG = GetSnapshotUriRequest.class.getSimpleName();

    //Attributes
    private OnvifSnapshotURIListener listener;
    private OnvifMediaProfile mediaProfile;

    //Constructors
    public GetSnapshotUriRequest(OnvifMediaProfile mediaProfile, OnvifSnapshotURIListener listener) {
        this.mediaProfile = mediaProfile;
        this.listener = listener;
    }

    //Properties

    @Override
    public String getXml() {
        return "<GetSnapshotUri xmlns=\"http://www.onvif.org/ver10/media/wsdl\">" +
                "<ProfileToken>" + mediaProfile.getToken() + "</ProfileToken>" +
                "</GetSnapshotUri>";
    }

    @Override
    public OnvifType getType() {
        return OnvifType.GET_SNAPSHOT_URI;
    }

    @Override
    public String getAddHeader() {
        return null;
    }

}
