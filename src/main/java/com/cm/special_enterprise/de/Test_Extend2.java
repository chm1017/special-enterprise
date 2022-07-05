package com.cm.special_enterprise.de;

public class Test_Extend2 extends Test_Extend{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void run() {
        System.out.println("快跑");
    }
}
