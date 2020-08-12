package net.cishow.fsjcp.common.entity.fsconf.base;

public class Gateway extends MapItem<String> {
    public Gateway(String name) {
        super("gateway", "name=" + name);
    }
}
