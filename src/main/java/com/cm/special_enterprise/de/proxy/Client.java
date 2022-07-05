package com.cm.special_enterprise.de.proxy;

public class Client {
    public static void main(String[] args) {
        GamePlayerProxy proxy = new GamePlayerProxy("张三");
        proxy.login("11", "1111");
        proxy.run();

    }

}
