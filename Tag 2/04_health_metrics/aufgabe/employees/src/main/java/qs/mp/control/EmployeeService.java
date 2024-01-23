package qs.mp.control;

import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.baggage.BaggageBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import qs.mp.entity.Employee;
import qs.mp.entity.Skill;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ApplicationScoped
public class EmployeeService {

    @Inject
    Tracer tracer;

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Employee with id " + id + " not found"));
    }

    public List<Integer> getEmployeeSkills(int id) {
        return getEmployeeById(id).getSkillIds();
    }

    public void addEmployeeSkill(int id, Integer skillId) {
        getEmployeeById(id).addSkill(skillId);
    }

    @WithSpan(value = "Employees: Hallo Employee", kind = SpanKind.CLIENT)
    public List<Employee> getEmployeeBySkillId(@SpanAttribute(value = "skillId") int skillId) throws InterruptedException {
        List<Integer> ids = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        ids.add(skillId);
        Employee employee = new Employee("Max", "Mustermann", ids);
        employees.add(employee);

        doSomeTracing(skillId);

        return employees;
    }

    private void doSomeTracing(int skillId) throws InterruptedException {
        Span span = tracer.spanBuilder("My custom span")
                .setAttribute("service", "Skills")
                .setAttribute("skillId", skillId)
                .setParent(Context.current().with(Span.current()))
                .setSpanKind(SpanKind.INTERNAL)
                .startSpan();

        Thread.sleep(1000);

        // Create or retrieve existing Baggage
        BaggageBuilder baggageBuilder = Baggage.current().toBuilder();

        // Add key-value pairs to the Baggage
        baggageBuilder.put("key1", "Hallo");
        baggageBuilder.put("key2", "Baggage");

        // Build the Baggage
        Baggage baggage = baggageBuilder.build();

        // Make the Baggage available for the current context
        try (Scope scope = Context.current().with(baggage).makeCurrent()) {
            // Your logic here; the baggage is now available in this context
            String result = performOperation();

            Baggage updatedBaggage = Baggage.current().toBuilder().put("operationResult", result).build();
            span.setAttribute("operationResult", result);
            span.setAttribute("baggage", baggage.toString());

        }

        // Outside of the try-with-resources block, the previous context (without the baggage) is restored

    }

    private String performOperation() {
        // Placeholder for an operation
        // Return a result that will be added to the Baggage
        return "success";
    }

}
