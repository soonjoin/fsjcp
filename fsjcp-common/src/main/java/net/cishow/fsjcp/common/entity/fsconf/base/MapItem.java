package net.cishow.fsjcp.common.entity.fsconf.base;

import java.util.HashMap;

public class MapItem<T> extends HashMap<String, T> {

    private final String tag;
    private final String keyName;
    private final String valueName;

    public MapItem() {
        this.tag = "param";
        this.keyName = "name";
        this.valueName = "value";
    }

    public MapItem(String tag, String keyName, String valueName) {
        this.tag = tag;
        this.keyName = keyName;
        this.valueName = valueName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        forEach((k,v)-> {
            sb.append("<").append(tag).append(" ").append(keyName).append("=\"").append(k).append("\" ").append(valueName).append("=\"").append(v).append("\"/>\n");
        });
        return sb.toString();
    }
}
