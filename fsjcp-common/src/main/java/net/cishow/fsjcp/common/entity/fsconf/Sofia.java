package net.cishow.fsjcp.common.entity.fsconf;

import lombok.Getter;
import lombok.Setter;
import net.cishow.fsjcp.common.entity.fsconf.base.ContainerItem;
import net.cishow.fsjcp.common.entity.fsconf.base.MapItem;

@Getter
@Setter
public class Sofia extends ContainerItem {

    private MapItem<String> global_settings;
    private MapItem<String> profiles;

    public Sofia() {
        super("configuration", "name=\"sofia.conf\" description=\"sofia Endpoint\"");
        this.global_settings = new MapItem<>("global_settings");
        this.profiles = new MapItem<>("profiles");
    }

}
