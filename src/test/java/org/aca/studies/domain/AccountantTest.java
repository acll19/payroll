package org.aca.studies.domain;

import domain.Accountant;
import domain.Employee;
import domain.Payroll;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AccountantTest {

    private Accountant accountant;

    @Before
    public void setUp() throws Exception {
        accountant = new Accountant();
    }

    @Test
    public void shouldRetornAPayroll() {
        List<Employee> employees = Collections.singletonList(new Employee());

        assertThat(accountant.getPayroll(employees)).isInstanceOf(Payroll.class);
    }

    @Test
    public void shouldRetornAPayrollWithAListOfEmployees() {
        List<Employee> Employees = Collections.singletonList(new Employee());

        Payroll payroll = accountant.getPayroll(Employees);
        List<Employee> employees = payroll.getEmployees();

        assertThat(employees).isInstanceOf(List.class);
        employees.forEach(em -> assertThat(em).isInstanceOf(Employee.class));
    }

    @Test
    public void shouldReturnPayrollWithEmployeesWhenEmployeeListIsNotEmpty() throws Exception {
        Employee aEmployee = new Employee();
        List<Employee> Employees = Collections.singletonList(aEmployee);

        Payroll payroll = accountant.getPayroll(Employees);

        assertThat(payroll.getEmployees()).isNotEmpty();
    }
}
