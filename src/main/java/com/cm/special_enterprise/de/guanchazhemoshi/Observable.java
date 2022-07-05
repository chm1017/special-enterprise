package com.cm.special_enterprise.de.guanchazhemoshi;

public interface Observable {
    public void addObserver(Observer observer);

    public void delObserver(Observer observer);

    public void notifyObservers(String context);
}
