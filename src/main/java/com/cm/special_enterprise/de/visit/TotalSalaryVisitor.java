package com.cm.special_enterprise.de.visit;

public class TotalSalaryVisitor implements ITotalVisitor {
    private int commonTotalSalary = 0;
    private int managerTotalSalary = 0;
    public void visit(CommonEmploee commonEmploee) {
        this.commonTotalSalary = this.commonTotalSalary + commonEmploee.getSalary();
    }

    public void visit(Manager manager) {
        this.managerTotalSalary = this.managerTotalSalary + manager.getSalary();
    }

    @Override
    public void totalSalary() {
        System.out.println("总额是：" + (this.commonTotalSalary + this.managerTotalSalary));
    }
}
