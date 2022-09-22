package com.cm.special_enterprise.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class TestEntity implements Serializable {
    private String name;
    private Integer age;
    private String sex;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
