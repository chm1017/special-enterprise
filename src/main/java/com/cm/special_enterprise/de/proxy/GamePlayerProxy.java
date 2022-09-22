package com.cm.special_enterprise.de.proxy;

public class GamePlayerProxy implements IGamePlayer {
    private IGamePlayer iGamePlayer = null;

    public GamePlayerProxy(String name) {
        try {
            iGamePlayer=new GamePlayer(this, name);
        } catch (Exception e) {

        }
    }
    @Override
    public void login(String username, String password) {
        this.iGamePlayer.login(username, password);
    }

    @Override
    public void killBoss() {
        this.iGamePlayer.killBoss();

    }

    @Override
    public void upgrade() {
        this.iGamePlayer.upgrade();
    }

    public void run() {
        killBoss();
        upgrade();
    }
}
