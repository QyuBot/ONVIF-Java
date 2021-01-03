package be.teletask.onvif.requests;

import be.teletask.onvif.listeners.OnvifResponseListener;
import be.teletask.onvif.models.OnvifMediaProfile;
import be.teletask.onvif.models.OnvifPreset;
import be.teletask.onvif.models.OnvifType;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * Created by Luke F on 02/12/2020.
 */
@Getter
@NoArgsConstructor
public class GotoPresetRequest implements OnvifRequest {

    //Constants
    public static final String TAG = GotoPresetRequest.class.getSimpleName();

    //Attributes
    private OnvifResponseListener listener;
    private OnvifMediaProfile mediaProfile;
    private OnvifPreset preset;

    //Constructors
    public GotoPresetRequest(OnvifMediaProfile mediaProfile, OnvifPreset preset) {
        this.mediaProfile = mediaProfile;
        this.preset = preset;
    }

    public GotoPresetRequest(OnvifMediaProfile mediaProfile, OnvifPreset preset, OnvifResponseListener listener) {
        this.mediaProfile = mediaProfile;
        this.preset = preset;
        this.listener = listener;
    }

//Properties

    @Override
    public String getXml() {
        return "<GotoPreset xmlns=\"http://www.onvif.org/ver20/ptz/wsdl\">" +
                "<ProfileToken>" + mediaProfile.getToken() + "</ProfileToken>" +
                "<PresetToken>" + preset.getToken() + "</PresetToken>" +
                "</GotoPreset>";
    }

    @Override
    public OnvifType getType() {
        return OnvifType.GOTO_PRESET;
    }

    @Override
    public String getAddHeader() {
        return null;
    }

}
