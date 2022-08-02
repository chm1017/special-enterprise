package com.cm.special_enterprise.de.visit;

import lombok.Data;

@Data
public class CommonEmploee extends Employee {
    private String job;

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.visit(this);
    }
}
