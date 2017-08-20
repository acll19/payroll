package domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PayrollTest {

    @Test
    public void shouldReturnEmployeesSallaryWhenEmployeeListIsNotEmpty() {
        Accountant accountant = new Accountant();
        Employee aEmployee = new Employee();
        List<Employee> Employees = Collections.singletonList(aEmployee);

        Payroll payroll = accountant.getPayroll(Employees);

        payroll.getEmployees().forEach(e -> {
            BigDecimal sallary = e.getSallary();
            assertThat(sallary).isNotNull();
            assertThat(sallary).isInstanceOf(BigDecimal.class);
        });
    }
}