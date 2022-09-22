package com.cm.special_enterprise.de;

public class Test_Extend {
    protected String name;
    protected String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    protected void run() {
        System.out.println("跑");
    }
}
