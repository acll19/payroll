package infra.services;


import domain.Accountant;
import domain.Employee;
import domain.Payroll;
import domain.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PayrollServiceTest {

    @Mock
    private Accountant accountant;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private PayrollService payrollService;

    @Test
    public void shouldReturnPayrollWithListOfEmployees() throws Exception {
        List<Employee> rawEmployees = Arrays.asList(new Employee(), new Employee(), new Employee());
        Payroll expectedPayroll = new Payroll(rawEmployees);
        when(employeeService.fetchEmpoyees()).thenReturn(rawEmployees);
        when(accountant.getPayroll(rawEmployees)).thenReturn(expectedPayroll);

        Payroll payroll = payrollService.prepareMonthPayroll();

        assertThat(payroll).isNotNull();
        assertThat(payroll.getEmployees()).isNotNull();
        assertThat(payroll.getEmployees()).isNotEmpty();
    }
}
