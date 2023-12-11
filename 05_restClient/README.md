# MicroProfile Rest Client

In der vorherigen Übung haben Sie den Employee Service kennengelernt. In dieser Übung ist es an Ihnen den 
[Skills Service](../04_health_metrics/skills.md aus Übung 04_health_metrics zu implementieren 
und die Kommunikation zum Employee Service mittels MicroProfile Rest Client zu realisieren.
Bedenken Sie, dass sie auch in diesem Service die Repräsentationen der Employee Klasse pflegen müssen.

## Aufgabenstellung

### RestClient in Quarkus

Untersuchen Sie die `pom.xml` des Skills Service. Welche Abhängigkeiten werden hier verwendet, um den 
MicroProfile Rest Client zu verwenden?

### Skills Service erstellen

Erstellen Sie die notwendigen Klassen, um den Skills Service zu implementieren. Die Klasse `Skill` soll die
folgenden Attribute besitzen:

* id
* name
* level

Die Klasse `SkillResource` soll die folgenden Methoden besitzen:

* `@GET` `@Path("/skills")` `List<Skill> getSkills()`
* `@GET` `@Path("/skills/{id}")` `Skill getSkill(@PathParam("id") Long id)`
* `@POST` `@Path("/skills")` `Skill createSkill(Skill skill)`
* `@PUT` `@Path("/skills/{id}")` `Skill updateSkill(@PathParam("id") Long id, Skill skill)`
* `@GET` `@Path("/skills/{id}/employees")` `List<Employee> getEmployeesWithSkill(@PathParam("id") Long id)`

### RestClient implementieren

Implementieren Sie die Klasse EmployeeRestClient, um die Kommunikation zum Employee Service zu 
realisieren. Die Klasse soll relevanten Methoden besitzen, um die oben genannten Aufgaben zu erfüllen. 
Ergänzen Sie dazu falls notwendig den Employee Service um die notwendigen Methoden.

*Hinweis: Definieren Sie geeignete Ports, um die beiden Services parallel laufen zu lassen.*

