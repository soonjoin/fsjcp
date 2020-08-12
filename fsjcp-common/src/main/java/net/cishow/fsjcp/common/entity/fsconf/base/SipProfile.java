package net.cishow.fsjcp.common.entity.fsconf.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SipProfile extends ContainerItem {

    private MapItem<String> aliases;
    private MapItem<Gateway> gateways;
    private MapItem<Domain> domains;
    private MapItem<String> settings;

    public SipProfile(String name) {
        super("profile", "name=" + name);
        aliases = new MapItem<>("aliases");
        gateways = new MapItem<>("gateways");
        domains = new MapItem<>("domains");
        settings = new MapItem<>("settings");

        domains.put("all", new Domain("all", "true", "false"));
    }
}
