package com.cm.special_enterprise.de.interfaceGeLi;

public class Searcher extends AbstractSearcher{
    public Searcher(IBGirl ibGirl) {
        super(ibGirl);
    }
    @Override
    public void show() {
        System.out.println("信息如下");
        super.ibGirl.goodLooking();
        super.ibGirl.niceFigure();
        super.ibGirl.greatTemperament();
    }






}
