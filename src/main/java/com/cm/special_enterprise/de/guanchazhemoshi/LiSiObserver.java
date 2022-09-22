package com.cm.special_enterprise.de.guanchazhemoshi;

public class LiSiObserver implements Observer{
    @Override
    public void update(String context) {
        System.out.println("kaishi huibao");
        System.out.println(context);
        System.out.println("jishu ....");
    }
}
