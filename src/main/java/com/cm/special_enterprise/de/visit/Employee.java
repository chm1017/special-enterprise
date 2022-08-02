package com.cm.special_enterprise.de.visit;

import lombok.Data;

@Data
public abstract class Employee{
    private String name;
    private int salary;
    public abstract void accept(IVisitor iVisitor);
}
