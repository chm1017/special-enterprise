package com.cm.special_enterprise.de.visit;

public class Visitor implements IVisitor {

    @Override
    public void visit(CommonEmploee commonEmploee) {
        System.out.println(this.getCommonInfo(commonEmploee));
    }

    @Override
    public void visit(Manager manager) {
        System.out.println(this.getManagerInfo(manager));

    }

    public String getBasicInfo(Employee employee) {
        String info = "";
        info = employee.getName() + employee.getSalary();
        return info;
    }

    public String getManagerInfo(Manager manager) {
        String basicInfo = getBasicInfo(manager);
        return basicInfo + manager.getPerformance();
    }

    public String getCommonInfo(CommonEmploee commonEmploee) {
        return getBasicInfo(commonEmploee) + commonEmploee.getJob();
    }

}
