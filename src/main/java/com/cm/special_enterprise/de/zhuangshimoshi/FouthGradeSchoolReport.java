package com.cm.special_enterprise.de.zhuangshimoshi;

public class FouthGradeSchoolReport extends SchoolReport {

    @Override
    public void report() {
        System.out.println("chengjidanshizheyangde");
    }

    @Override
    public void sign(String name) {
        System.out.println("jiazhangqianming"+name);
    }
}
