package infra.services;

import domain.Accountant;
import domain.Employee;
import domain.Payroll;
import domain.services.EmployeeService;

import javax.inject.Inject;
import java.util.List;

public class PayrollService {

    @Inject
    private Accountant accountant;

    @Inject
    private EmployeeService employeeService;

    public Payroll prepareMonthPayroll() {
        List<Employee> employees = employeeService.fetchEmpoyees();
        return accountant.getPayroll(employees);
    }
}
