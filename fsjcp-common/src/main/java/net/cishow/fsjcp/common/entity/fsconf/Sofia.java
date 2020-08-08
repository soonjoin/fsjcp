package net.cishow.fsjcp.common.entity.fsconf;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sofia extends RootConf{

    private MapItem global_settings;

    public Sofia(String description) {
        super(description);
        this.global_settings = new MapItem();
    }

}