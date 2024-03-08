package qs.mp.control;

import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.baggage.BaggageBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import qs.mp.entity.Employee;
import qs.mp.entity.Skill;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SkillService {

        List<Skill> skills = new ArrayList<>();

        @Inject
        Tracer tracer;

        @Inject
        @RestClient
        EmployeeClient employeeClient;

        public List<Skill> getAll() {
            return skills;
        }

        public Skill getById(int id){
            return skills.stream().filter(skill -> skill.getId() == id).findFirst().orElse(null);
        }

        public void create(Skill skill) {
            skills.add(skill);
        }

        public Boolean isMoreExperiencedThan(Skill skill1, Skill skill2) {
            return skill1.isMoreExperiencedThan(skill2);
        }

        public List<Skill> getEmployees(int id) {
            return skills;
        }


        @WithSpan("Skills: getEmployeesBySkillId")
        public List<Employee> getEmployeesBySkillId(int id) throws InterruptedException {
                List<Employee> employees = employeeClient.getEmployeeBySkillId(id);

                doSomeTracing(id);
                return employees;
        }

    private void doSomeTracing(int skillId) throws InterruptedException {
        Span span = tracer.spanBuilder("My custom Skill span")
                .setAttribute("service", "Skills")
                .setAttribute("skillId", skillId)
                .setParent(Context.current().with(Span.current()))
                .setSpanKind(SpanKind.INTERNAL)
                .startSpan();

        Thread.sleep(100);

        // Create or retrieve existing Baggage
        BaggageBuilder baggageBuilder = Baggage.current().toBuilder();

        // Add key-value pairs to the Baggage
        baggageBuilder.put("skills", "Service");

        // Build the Baggage
        Baggage baggage = baggageBuilder.build();


        // Make the Baggage available for the current context
        try (Scope scope = Context.current().with(baggage).makeCurrent()) {
            // Your logic here; the baggage is now available in this context

            baggage.forEach((key, value) -> {
                span.setAttribute(key, value.getValue());
            });
        }

        // Outside of the try-with-resources block, the previous context (without the baggage) is restored

        span.end();
    }
}
