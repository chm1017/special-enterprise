package com.cm.special_enterprise.de.proxy.jdkproxy;

public class RealSubject implements Subject {

    @Override
    public void doSomething(String str) {
        System.out.println("dosomething"+str);
    }
}
