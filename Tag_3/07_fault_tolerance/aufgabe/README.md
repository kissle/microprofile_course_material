# MicroProfile Fault Tolerance

MicroProfile Fault Tolerance ist eine Spezifikation für die Behandlung von Fehlern in Microservice-Architekturen.
In dieser Übung werden wir die zwei bestehenden Services um die Fähigkeit erweitern, Fehler zu behandeln.

## Aufgabenstellung

### 1. Fehler Implementieren

Um die Funktionalitäten der Spezifikation zu testen, müssen wir zunächst Fehler in den Services implementieren.
Erweitern Sie die Services um Fehler, die die Nutzung der Services verhindern oder 
beeinträchtigen.

### 2. Fault Tolerance in den Services aktivieren

Erweitern Sie die Dependencies der Services um die Abhängigkeit `smallrye-fault-tolerance` in dem Sie die `pom.xml`
erweitern um `smallrye-fault-tolerance`:

```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-smallrye-fault-tolerance</artifactId>
</dependency>
```

### 3. Fault Tolerance in den Services konfigurieren

Ergreifen Sie Maßnahmen, um die Fehler in den Services zu behandeln. 
Verwenden Sie dabei die Annotationen der Spezifikation.

