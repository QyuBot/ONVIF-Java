package be.teletask.onvif.requests;

import be.teletask.onvif.listeners.OnvifPresetListener;
import be.teletask.onvif.listeners.OnvifStatusListener;
import be.teletask.onvif.models.OnvifMediaProfile;
import be.teletask.onvif.models.OnvifType;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Luke F on 17/12/2020.
 */
@Getter
@NoArgsConstructor
public class SetPresetRequest implements OnvifRequest {

    //Constants
    public static final String TAG = SetPresetRequest.class.getSimpleName();

    //Attributes
    private OnvifPresetListener listener;
    private OnvifMediaProfile mediaProfile;

    /**
     * Optional
     *
     * If the PresetToken parameter is absent, the device shall create a new preset. Otherwise it shall
     * update the stored position and optionally the name of the given preset. If creation is successful,
     * the response contains the PresetToken which uniquely identifies the preset. An existing preset
     * can be overwritten by specifying the PresetToken of the corresponding preset. In both cases
     * (overwriting or creation) an optional PresetName can be specified.
     *
     * We ignore the response from setPreset
     *
     */
    private String name = "", token = "";

    //Constructors
    public SetPresetRequest(OnvifMediaProfile mediaProfile, String name, String token, OnvifPresetListener listener) {
        this.mediaProfile = mediaProfile;
        this.name = name;
        this.token = token;
        this.listener = listener;
    }

    //Properties

    private StringBuilder sb = new StringBuilder();

    @Override
    public String getXml() {

        sb.setLength(0);
        sb.append("<SetPreset xmlns=\"http://www.onvif.org/ver20/ptz/wsdl\">");
        sb.append("<ProfileToken>" + mediaProfile.getToken() + "</ProfileToken>" );
        if (name != null && !name.isEmpty()) {
            sb.append("<PresetName>" + name + "</PresetName>" );
        }
        if (token != null && !token.isEmpty()) {
            sb.append("<PresetToken>" + token + "</PresetToken>" );
        }
        sb.append("</SetPreset>");

        return sb.toString();
    }

    @Override
    public OnvifType getType() {
        return OnvifType.SET_PRESET;
    }

    @Override
    public String getAddHeader() {
        return null;
    }

}
