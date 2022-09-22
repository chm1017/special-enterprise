package com.cm.special_enterprise.de.zhuangshimoshi;

public class SortDecorator extends Decorator {

    public SortDecorator(SchoolReport sr) {
        super(sr);
    }

    private void reprotSort() {
        System.out.println("paiming....");
    }

    @Override
    public void report() {
        reprotSort();
        super.report();
    }
}
