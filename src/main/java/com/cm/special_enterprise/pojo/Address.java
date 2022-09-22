package com.cm.special_enterprise.pojo;

import lombok.Data;

@Data
public class Address implements Cloneable {

    private Long id;
    private String describe;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
