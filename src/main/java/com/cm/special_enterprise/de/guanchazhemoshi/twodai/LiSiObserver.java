package com.cm.special_enterprise.de.guanchazhemoshi.twodai;

import com.cm.special_enterprise.de.guanchazhemoshi.Observer;

import java.util.Observable;

public class LiSiObserver {

    public void update(Observable observable,Object o) {
        System.out.println("kaishi huibao "+o.toString());
    }
}
