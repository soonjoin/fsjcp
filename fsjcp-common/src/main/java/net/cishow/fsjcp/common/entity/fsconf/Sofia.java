package net.cishow.fsjcp.common.entity.fsconf;

import lombok.Getter;
import lombok.Setter;
import net.cishow.fsjcp.common.entity.fsconf.base.ContainerItem;
import net.cishow.fsjcp.common.entity.fsconf.base.MapItem;
import net.cishow.fsjcp.common.entity.fsconf.base.SipProfile;

@Getter
@Setter
public class Sofia extends ContainerItem {

    private MapItem<String> global_settings;
    private MapItem<SipProfile> profiles;

    public Sofia() {
        super("configuration", "name=\"sofia.conf\" description=\"sofia Endpoint\"");
        this.global_settings = new MapItem<>("global_settings");
        this.profiles = new MapItem<>("profiles");

        // set default value
        global_settings.put("log-level", "0");
        global_settings.put("debug-presence", "0");
    }

    @Override
    public String toString() {
        return "<document type=\"freeswitch/xml\">\n"
                + "<section name=\"configuration\">\n"
                + super.toString()
                + "</section>\n"
                + "</document>\n";
    }
}
