package com.cm.special_enterprise.de.zhuangshimoshi;

public class HighScoreDecorator extends Decorator {

    public HighScoreDecorator(SchoolReport sr) {
        super(sr);
    }

    private void reportHighScore() {
        System.out.println("zuigaofen...");
    }

    @Override
    public void report() {
        reportHighScore();
        super.report();
    }
}
