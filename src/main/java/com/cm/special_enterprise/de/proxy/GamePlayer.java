package com.cm.special_enterprise.de.proxy;

public class GamePlayer implements IGamePlayer {
    private String name = null;

    public GamePlayer(IGamePlayer iGamePlayer, String name) throws Exception {
        if (iGamePlayer == null) {
            throw new Exception("不能创建角色");
        } else {
            this.name = name;
        }
    }

    @Override
    public void login(String username, String password) {
        System.out.println("denglu");
    }

    @Override
    public void killBoss() {
        System.out.println(name+"杀怪");
    }

    @Override
    public void upgrade() {
        System.out.println(name + "shengji");
    }
}
