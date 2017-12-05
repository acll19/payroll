package domain.services;

import domain.Employee;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@RequestScoped
public class EmployeeService {

    private WebTarget target;

    @Inject
    @ConfigurationValue("employees.service.target")
    String employeesTarget;

    @PostConstruct
    public void init() {
        Client client = ClientBuilder.newBuilder().build();
        this.target = client.target(employeesTarget);
    }

    public List<Employee> fetchEmpoyees() {
        Employee[] employees = target.path("/employees")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(Employee[].class);
        return Arrays.asList(employees);
    }
}
