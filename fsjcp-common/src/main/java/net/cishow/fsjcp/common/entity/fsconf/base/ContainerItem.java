package net.cishow.fsjcp.common.entity.fsconf.base;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ContainerItem {

    private final String tag;
    private final String attributes;

    public ContainerItem(String tag, String attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    @Override
    public String toString() {

        StringBuilder xmlString = new StringBuilder();
        xmlString.append("<").append(tag).append(StringUtils.isEmpty(attributes) ? "" : " " + attributes).append(">\n");

        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                Method method = this.getClass().getMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
                Object member = method.invoke(this);
                xmlString.append(member.toString());
            } catch (Exception ignore) {
            }
        }

        xmlString.append("</").append(tag).append(">\n");

        return xmlString.toString();
    }

}
