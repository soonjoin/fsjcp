package net.cishow.fsjcp.common.entity.fsconf;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RootConf {

    private final String description;

    public RootConf(String description) {
        this.description = description;
    }

    @Override
    public String toString() {

        String className = this.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);

        StringBuilder xmlString = new StringBuilder();
        xmlString.append("<configuration name=\"").append(className.toLowerCase())
                .append("\" description=\"").append(description).append("\">\n");

        for (Field field : this.getClass().getDeclaredFields()) {
            xmlString.append("<").append(field.getName()).append(">\n");
            try {
                Method method = this.getClass().getMethod("get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1));
                Object member = method.invoke(this);
                xmlString.append(member.toString());
            } catch (Exception ignore) {
            }
            xmlString.append("</").append(field.getName()).append(">\n");
        }

        xmlString.append("</configuration>\n");

        return xmlString.toString();
    }

}
