package com.cm.special_enterprise.de.guanchazhemoshi.twodai;

import java.util.Observable;

public class Hanfeizi extends Observable {
    public void haveEat() {
        System.out.println("han kaishi  eat");
        super.setChanged();
        super.notifyObservers("hanfeizi   kai chi!!!");
    }
}
