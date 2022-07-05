package com.cm.special_enterprise.de.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SubjectDymicProxy extends DymicProxy{
    public static <T> T newProxyInstance(Subject subject) {
        ClassLoader classLoader = subject.getClass().getClassLoader();
        Class<?>[] interfaces = subject.getClass().getInterfaces();
        InvocationHandler handler = new MyInvocationHandler(subject);
        return (T)Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
