package qs.mp.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import qs.mp.control.EmployeeService;
import qs.mp.entity.Employee;
import qs.mp.entity.Skill;

import java.util.List;

@Path("/employees")
public class EmployeeResource {

    @Inject
    EmployeeService employeeService;

    @GET
    @Timed(name = "getEmployeesTimer")
    @Counted(name = "getEmployeesCounter")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeById(int id) {
        return employeeService.getEmployeeById(id);
    }

    @GET
    @Path("/{id}/skills")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Skill> getEmployeeSkills(int id) {
        return employeeService.getEmployeeSkills(id);
    }

    @POST
    @Path("/{id}/skills")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEmployeeSkill(@PathParam("id") int id, Skill skill) {
        employeeService.addEmployeeSkill(id, skill);
    }

}
