package qs.mp.control;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import qs.mp.entity.Employee;

import java.util.List;

@Path("/employees")
@RegisterRestClient(baseUri = "http://localhost:8082")
public interface EmployeeClient {

    @GET
    @Path("/skills/{skillId}")
    public List<Employee> getEmployeeBySkillId(int skillId);
}
