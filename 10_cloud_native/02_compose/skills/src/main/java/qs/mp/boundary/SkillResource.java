package qs.mp.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import qs.mp.control.SkillService;
import qs.mp.entity.Employee;
import qs.mp.entity.Skill;

import java.util.List;

@Path("/skills")
public class SkillResource {

    @Inject
    SkillService skillService;

    @GET
    @Operation(summary = "Get all skills")
    @APIResponse(responseCode = "200", description = "List of skills",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Skill.class)))
    @APIResponse(responseCode = "204", description = "No skills")
    public List<Skill> getAll() {
        return skillService.getAll();
    }

    @POST
    @Operation(summary = "Create a new skill")
    @APIResponse(responseCode = "201", description = "Skill created",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Skill.class)))
    @APIResponse(responseCode = "400", description = "Invalid skill")
    public void create(Skill skill) {
        skillService.create(skill);
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get a skill by id")
    @APIResponse(responseCode = "200", description = "Skill",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Skill.class)))
    public Skill getById(@PathParam("id") int id) {
        return skillService.getById(id);
    }

    @GET
    @Path("/{id}/employees")
    @Operation(summary = "Get employees by skill id")
    @APIResponse(responseCode = "200", description = "List of employees",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)))
    public List<Employee> getEmployees(@PathParam("id") int id) throws InterruptedException {
       return skillService.getEmployeesBySkillId(id);
    }
}
