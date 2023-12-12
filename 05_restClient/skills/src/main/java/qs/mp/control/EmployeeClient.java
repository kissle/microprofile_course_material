package qs.mp.control;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import qs.mp.entity.Employee;

@Path("/employees")
@RegisterRestClient(configKey = "employees")
public interface EmployeeClient {

    @GET
    @Path("/skills/{skillId}")
    public Employee getEmployeeBySkillId(int skillId);
}
