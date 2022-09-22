package com.cm.special_enterprise.de.guanchazhemoshi;

import java.util.ArrayList;

public class HanFeiZi implements Observable{
    ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(String context) {
        for (Observer o : observers) {
            o.update(context);
        }
    }

    public void haveBreakfast() {
        System.out.println("han chifan l ");
        this.notifyObservers("韩非子在吃饭");
    }
}
