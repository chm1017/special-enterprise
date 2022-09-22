package com.cm.special_enterprise.de.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;

public class Client {
    public static void main(String[] args) {
//        Subject realSubject = new RealSubject();
//        InvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
//        Subject proxy = DymicProxy.newProxyInstance(realSubject.getClass().getClassLoader(),
//                realSubject.getClass().getInterfaces(),
//                myInvocationHandler);
//        proxy.doSomething("66");

        Subject proxy = SubjectDymicProxy.newProxyInstance(new RealSubject());
        proxy.doSomething("aike");
    }
}
