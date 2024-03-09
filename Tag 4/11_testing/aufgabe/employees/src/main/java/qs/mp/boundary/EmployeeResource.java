package qs.mp.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
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
    @Operation(summary = "Get all employees")
    @APIResponse(responseCode = "200", description = "List of employees",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Employee.class, type = SchemaType.ARRAY)))
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add an employee")
    @APIResponse(responseCode = "204", description = "Employee added")
    @APIResponse(responseCode = "400", description = "Invalid employee data")
    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get an employee by id")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Employee found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Employee.class))),
            @APIResponse(responseCode = "404", description = "Employee not found")
    })
    public Employee getEmployeeById(int id) {
        return employeeService.getEmployeeById(id);
    }

    @GET
    @Path("/{id}/skills")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get employee skills")
    @APIResponse(responseCode = "200", description = "Employee skills",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Skill.class, type = SchemaType.ARRAY)))
    public List<Integer> getEmployeeSkills(int id) {
        return employeeService.getEmployeeSkills(id);
    }

    @POST
    @Path("/{id}/skills")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add employee skill")
    @APIResponse(responseCode = "204", description = "Employee skill added")
    @APIResponse(responseCode = "400", description = "Invalid employee skill data")
    public void addEmployeeSkill(@PathParam("id") int id, Integer skillId) {
        employeeService.addEmployeeSkill(id, skillId);
    }

    @GET
    @Path("/skills/{skillId}")
    @Operation(summary = "Get employees by skill id")
    @APIResponse(responseCode = "200", description = "Employees with skill",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Employee.class, type = SchemaType.ARRAY)))
    public List<Employee> getEmployeeBySkillId(@PathParam("skillId") int skillId) throws InterruptedException {
        return employeeService.getEmployeeBySkillId(skillId);
    }
}

