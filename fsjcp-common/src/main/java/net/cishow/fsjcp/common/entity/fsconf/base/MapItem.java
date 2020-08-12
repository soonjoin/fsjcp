package net.cishow.fsjcp.common.entity.fsconf.base;

import org.springframework.util.StringUtils;

import java.util.HashMap;

public class MapItem<T> extends HashMap<String, T> {

    private final String tag;
    private final String attributes;
    private final String itemTag;
    private final String itemAttributeKey;
    private final String itemAttributeValue;

    public MapItem(String tag) {
        this.tag = tag;
        this.attributes = "";
        this.itemTag = "param";
        this.itemAttributeKey = "name";
        this.itemAttributeValue = "value";
    }

    public MapItem(String tag, String attributes) {
        this.tag = tag;
        this.attributes = attributes;
        this.itemTag = "param";
        this.itemAttributeKey = "name";
        this.itemAttributeValue = "value";
    }

    public MapItem(String tag, String attributes, String itemTag, String itemAttributeKey, String itemAttributeValue) {
        this.tag = tag;
        this.attributes = attributes;
        this.itemTag = itemTag;
        this.itemAttributeKey = itemAttributeKey;
        this.itemAttributeValue = itemAttributeValue;
    }

    @Override
    public String toString() {
        StringBuilder xmlString = new StringBuilder();

        xmlString.append("<").append(tag).append(StringUtils.isEmpty(attributes) ? "" : " " + attributes).append(">\n");

        forEach((k, v) -> {
            if (v == null) {
                xmlString.append("<").append(itemTag).append(" ").append(itemAttributeKey).append("=\"").append(k).append("\"/>\n");
            } else if (v instanceof String) {
                xmlString.append("<").append(itemTag).append(" ").append(itemAttributeKey).append("=\"").append(k).append("\" ").append(itemAttributeValue).append("=\"").append(v).append("\"/>\n");
            } else {
                xmlString.append(v.toString());
            }
        });

        xmlString.append("</").append(tag).append(">\n");

        return xmlString.toString();
    }
}
