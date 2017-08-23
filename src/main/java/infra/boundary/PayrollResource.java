package infra.boundary;

import domain.Accountant;
import domain.Employee;
import domain.Payroll;
import domain.services.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("payroll")
public class PayrollResource {

    @Inject
    private Accountant accountant;

    @Inject
    private EmployeeService employeeService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayroll() {
        List<Employee> employees = employeeService.fetchEmpoyees();
        Payroll payroll = accountant.getPayroll(employees);
        return Response.ok(payroll).build();
    }
}
