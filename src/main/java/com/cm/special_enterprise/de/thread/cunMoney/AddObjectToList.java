package com.cm.special_enterprise.de.thread.cunMoney;

import java.util.ArrayList;

public class AddObjectToList implements Runnable {
    private ArrayList<Integer> list;
    private int anInt;
    public AddObjectToList(ArrayList<Integer> list, int i) {
        this.list = list;
        this.anInt = i;
    }
    @Override
    public void run() {
        list.add(anInt);
    }
}
