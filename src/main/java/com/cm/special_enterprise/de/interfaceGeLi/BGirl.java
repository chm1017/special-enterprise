package com.cm.special_enterprise.de.interfaceGeLi;

public class BGirl implements IBGirl {
    private String name;

    public BGirl(String name) {
        this.name = name;
    }

    @Override
    public void goodLooking() {
        System.out.println(name+"好看的脸蛋儿");
    }

    @Override
    public void niceFigure() {
        System.out.println(name + "苗条的身材");
    }

    @Override
    public void greatTemperament() {
        System.out.println(name+"高雅的气质");
    }
}
