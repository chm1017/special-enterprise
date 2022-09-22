package com.cm.special_enterprise.de.factorymethord;

public class HumanFactory extends AbstractHumanFactory {

    @Override
    public <T extends Human> T creatHuman(Class<T> c) {
        Human human = null;

        try {
            human = (T)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("生产错误");
        }
        return (T)human;
    }
}
