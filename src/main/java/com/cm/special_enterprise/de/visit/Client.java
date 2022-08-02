package com.cm.special_enterprise.de.visit;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        ITotalVisitor totalSalaryVisitor = new TotalSalaryVisitor();
        for (Employee employee : mockEmpolyee()) {
            employee.accept(totalSalaryVisitor);
        }
        totalSalaryVisitor.totalSalary();
    }
    public static List<Employee> mockEmpolyee() {
        ArrayList<Employee> employees = new ArrayList<>();
        CommonEmploee one = new CommonEmploee();
        one.setName("one");
        one.setSalary(10000);
        one.setJob("吃饭");
        CommonEmploee two = new CommonEmploee();
        two.setSalary(20000);
        two.setName("two");
        two.setJob("睡觉");
        Manager manager = new Manager();
        manager.setName("manager");
        manager.setPerformance("拍马");
        manager.setSalary(90000);
        employees.add(one);
        employees.add(two);
        employees.add(manager);
        return employees;
    }
}
