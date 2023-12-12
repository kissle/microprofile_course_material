package qs.mp.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.jboss.resteasy.reactive.common.NotImplementedYet;
import qs.mp.control.SkillService;
import qs.mp.entity.Employee;
import qs.mp.entity.Skill;

import java.util.List;

@Path("/skills")
public class SkillResource {

    @Inject
    SkillService skillService;

    @GET
    public List<Skill> getAll() {
        return skillService.getAll();
    }

    @POST
    public void create(Skill skill) {
        skillService.create(skill);
    }

    @GET
    @Path("/{id}")
    public Skill getById(@PathParam("id") int id) {
        return skillService.getById(id);
    }

    @GET
    @Path("/{id}/employees")
    public List<Employee> getEmployees(@PathParam("id") int id) {
       return skillService.getEmployeesBySkillId(id);
    }
}
