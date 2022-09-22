package com.cm.special_enterprise.de.zhuangshimoshi;

public class Client {
    public static void main(String[] args) {
        SchoolReport sr;
        sr = new FouthGradeSchoolReport();
        sr = new HighScoreDecorator(sr);
        sr = new SortDecorator(sr);
        sr.report();
        sr.sign("ake");
    }
}
