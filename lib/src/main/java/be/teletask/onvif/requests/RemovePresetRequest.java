package be.teletask.onvif.requests;

import be.teletask.onvif.models.OnvifMediaProfile;
import be.teletask.onvif.models.OnvifType;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Luke F on 17/12/2020.
 */
@Getter
@NoArgsConstructor
public class RemovePresetRequest implements OnvifRequest {

    //Constants
    public static final String TAG = RemovePresetRequest.class.getSimpleName();

    //Attributes
    private OnvifMediaProfile mediaProfile;

    private String token = "";

    //Constructors
    public RemovePresetRequest(OnvifMediaProfile mediaProfile, String token) {
        this.mediaProfile = mediaProfile;
        this.token = token;
    }

    //Properties

    @Override
    public String getXml() {

        return "<RemovePreset xmlns=\"http://www.onvif.org/ver20/ptz/wsdl\">" +
                "<ProfileToken>" + mediaProfile.getToken() + "</ProfileToken>" +
                "<PresetToken>" + token + "</PresetToken>" +
                "</RemovePreset>";
    }

    @Override
    public OnvifType getType() {
        return OnvifType.REMOVE_PRESET;
    }

    @Override
    public String getAddHeader() {
        return null;
    }

}
