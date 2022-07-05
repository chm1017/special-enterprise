package com.cm.special_enterprise.de.proxy.forceproxy;

public class GamePlayerProxy implements IGamePlayer,IProxy {

    private IGamePlayer iGamePlayer = null;

    public GamePlayerProxy(IGamePlayer iGamePlayer) {
        this.iGamePlayer = iGamePlayer;
    }
    @Override
    public void login(String username, String password) {
        this.iGamePlayer.login(username,password);
    }

    @Override
    public void killBoss() {
        this.iGamePlayer.killBoss();

    }

    @Override
    public void upgrade() {
        this.iGamePlayer.upgrade();
        this.count();
    }

    @Override
    public IGamePlayer getProxy() {
        return this;
    }

    @Override
    public void count() {
        System.out.println("升级费用999");
    }
}
