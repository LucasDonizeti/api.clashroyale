package com.supercellapi.clashroyaleapi.models;

/**
 * author LucasDonizeti
 */
public class Clan {
    String name;
    String tag;

    @Override
    public String toString() {
        return "Clan{" +
                "name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
