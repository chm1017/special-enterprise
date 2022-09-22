package com.cm.special_enterprise.de.proxy.forceproxy;

public class GamePlayer implements IGamePlayer {
    private String name = null;
    private IGamePlayer proxy = null;

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String username, String password) {
        if (isProxy()) {
            System.out.println(name + username + password);
        }

    }

    @Override
    public void killBoss() {
        if (isProxy()) {
            System.out.println(name+"killboss");
        }
    }

    @Override
    public void upgrade() {
        if (isProxy()) {
            System.out.println(name+"upgrade");

        }
    }

    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    public boolean isProxy() {
        if (this.proxy == null) {
            return false;
        } else {
            return true;
        }
    }
}
