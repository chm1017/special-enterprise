package com.cm.special_enterprise.de.zuhemoshi;

public abstract class Crop {
    private String name = "";
    private String position = "";
    private Integer salary = 0;

    public Crop(String name, String position, Integer salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getInfo() {
        return this.name + this.position + this.salary;
    }

}
