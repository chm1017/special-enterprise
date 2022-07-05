package com.cm.special_enterprise.de.proxy.forceproxy;

import org.checkerframework.checker.units.qual.C;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client2 {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("珂");
        InvocationHandler handler = new GamePlayIH(gamePlayer);
        ClassLoader c = gamePlayer.getClass().getClassLoader();
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(c, gamePlayer.getClass().getInterfaces(), handler);
//        newProxyInstance(c, new Class[]{IGamePlayer.class}, handler);
//        proxy.login("9", "(((");
        proxy.killBoss();
        proxy.upgrade();
    }
}
