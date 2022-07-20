package com.cm.special_enterprise.de.guanchazhemoshi.twodai;

import java.util.Observable;
import java.util.Observer;

public class Client {
    public static void main(String[] args) {
        Hanfeizi hanfeizi = new Hanfeizi();
        LiSiObserver liSiObserver = new LiSiObserver();
        liSiObserver.update((Observable) hanfeizi,"666");

        hanfeizi.haveEat();
    }
}
