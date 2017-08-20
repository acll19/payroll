package domain;

import java.util.List;

public class Accountant {

    private static final int SALLARY_BASE = 1000;

    public Payroll getPayroll(List<Employee> employees) {
        employees.forEach(e -> {
            double baseSallary = Math.random() * SALLARY_BASE;
            e.calculateSallary(baseSallary);
        });

        return new Payroll(employees);
    }
}
