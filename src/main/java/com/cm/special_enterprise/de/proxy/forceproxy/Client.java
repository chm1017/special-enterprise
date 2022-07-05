package com.cm.special_enterprise.de.proxy.forceproxy;

public class Client {
    public static void main(String[] args) throws Exception {
        IGamePlayer player = new GamePlayer("珂");
        IGamePlayer proxy = player.getProxy();
//        proxy.login("9", "999");
        proxy.killBoss();
        proxy.upgrade();

    }

}
