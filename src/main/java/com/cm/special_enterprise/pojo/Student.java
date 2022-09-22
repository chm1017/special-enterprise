package com.cm.special_enterprise.pojo;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Data
public class Student implements Cloneable, Serializable {

    private String name;
    private Integer age;
    private Address address;


    @Override
    public Object clone() throws CloneNotSupportedException {
        Student clone = (Student) super.clone();
        clone.address = (Address) this.address.clone();
        return clone;
    }
}
