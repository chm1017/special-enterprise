package com.cm.special_enterprise.de.proxy.forceproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlayIH implements InvocationHandler {
    Class c = null;
    Object o = null;

    public GamePlayIH(Object o) {
        this.o = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.o, args);
        if (method.getName().equalsIgnoreCase("login")) {
            System.out.println("有人登录");
        }
        return result;
    }
}
