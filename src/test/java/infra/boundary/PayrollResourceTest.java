package infra.boundary;

import domain.Accountant;
import domain.Employee;
import domain.Payroll;
import domain.services.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PayrollResourceTest {

    @Mock
    private Accountant accountant;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private PayrollResource payrollResource;

    @Before
    public void setUp() throws Exception {
        payrollResource = new PayrollResource();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPayrollShouldReturnOkAndPayrollWithListOfEmployees() throws Exception {
        List<Employee> rawEmployees = Arrays.asList(new Employee(), new Employee(), new Employee());
        Payroll expectedPayroll = new Payroll(rawEmployees);
        when(employeeService.fetchEmpoyees()).thenReturn(rawEmployees);
        when(accountant.getPayroll(rawEmployees)).thenReturn(expectedPayroll);

        Response response = payrollResource.getPayroll();
        Payroll payroll = (Payroll) response.getEntity();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(payroll).isNotNull();
        assertThat(payroll.getEmployees()).isNotNull();
    }
}