package infra.boundary;

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

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PayrollResourceTest {

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
        when(employeeService.fetchEmpoyees()).thenReturn(Arrays.asList(
                new Employee(),
                new Employee(),
                new Employee(),
                new Employee()
        ));

        Response response = payrollResource.getPayroll();
        Payroll payroll = (Payroll) response.getEntity();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(payroll).isNotNull();
        assertThat(payroll.getEmployees()).isNotNull();
    }
}