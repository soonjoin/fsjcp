package net.cishow.fsjcp.common.entity.fsconf.base;

public class Domain {
    private final String name;
    private final String alias;
    private final String parse;

    public Domain(String name, String alias, String parse) {
        this.name = name;
        this.alias = alias;
        this.parse = parse;
    }

    @Override
    public String toString() {
        return "<domain " +
                "name=\"" + name + '\"' +
                " alias=\"" + alias + '\"' +
                " parse=\"" + parse + '\"' +
                "/>\n";
    }
}
