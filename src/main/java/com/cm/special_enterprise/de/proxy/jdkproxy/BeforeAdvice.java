package com.cm.special_enterprise.de.proxy.jdkproxy;

public class BeforeAdvice implements IAdvice {

    @Override
    public void exec() {
        System.out.println("qianzhitongzhizhixing l");
    }
}
