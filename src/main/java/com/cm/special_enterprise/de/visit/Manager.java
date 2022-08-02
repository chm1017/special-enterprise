package com.cm.special_enterprise.de.visit;

import lombok.Data;

@Data
public class Manager extends Employee{
    private String performance;

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.visit(this);
    }
}
