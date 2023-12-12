package qs.mp.control;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import qs.mp.entity.Employee;

@Path("/employees")
@RegisterRestClient(baseUri = "http://localhost:8082")
public interface EmployeeClient {

    @GET
    @Path("/skills/{skillId}")
    public Employee getEmployeeBySkillId(int skillId);
}
