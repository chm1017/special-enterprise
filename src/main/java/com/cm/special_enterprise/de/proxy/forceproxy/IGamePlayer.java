package com.cm.special_enterprise.de.proxy.forceproxy;

public interface IGamePlayer {
    public void login(String username, String password);

    public void killBoss();

    public void upgrade();

    public IGamePlayer getProxy();
}
