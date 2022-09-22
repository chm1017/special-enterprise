package com.cm.special_enterprise.de.factorymethord;

public class Client {
    public static void main(String[] args) {
        HumanFactory humanFactory = new HumanFactory();
        Human yelloHuman =humanFactory.creatHuman(YellowHuman.class);
        yelloHuman.color();
        yelloHuman.talk();
    }
}
