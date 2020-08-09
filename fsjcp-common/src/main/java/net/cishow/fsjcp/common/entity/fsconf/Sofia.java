package net.cishow.fsjcp.common.entity.fsconf;

import lombok.Getter;
import lombok.Setter;
import net.cishow.fsjcp.common.entity.fsconf.base.MapItem;
import net.cishow.fsjcp.common.entity.fsconf.base.RootConf;

@Getter
@Setter
public class Sofia extends RootConf {

    private MapItem<String> global_settings;

    public Sofia(String description) {
        super(description);
        this.global_settings = new MapItem<>();
    }

}
