package com.cm.special_enterprise.de.guanchazhemoshi;

public class Client {
    public static void main(String[] args) {
        LiSiObserver lisi = new LiSiObserver();
        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(lisi);
        hanFeiZi.haveBreakfast();
    }
}
