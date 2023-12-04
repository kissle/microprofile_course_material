# MicroProfile OpenAPI

OpenApi ist eine Spezifikation für die Dokumentation von REST-Schnittstellen.
In dieser Übung werden wir unsere beiden bestehenden Services mit OpenApi dokumentieren und die Dokumentation mit 
Swagger-UI visualisieren. Dies ermöglicht es uns, die Schnittstellen im Browser zu testen.

## Aufgabenstellung

### 1. OpenApi in den beiden Services aktivieren

Erweitern Sie die beiden Services um die Abhängigkeit `microprofile-openapi` in dem Sie die `pom.xml` erweitern um 
`smallrye-open-api`:

```xml
<dependency>
    <groupId>io.smallrye</groupId>
    <artifactId>smallrye-open-api</artifactId>
</dependency>
```

### 2. OpenApi in den beiden Services konfigurieren

Erweitern Sie die beiden Services Skills und Employees, um angemessene Annotationen, um die Schnittstellen zu dokumentieren.
Testen Sie Ihre Schnittstellen mit Swagger-UI und exportieren Sie die Schnittstellenbeschreibung als JSON-Datei.

### 3. Code-Generierung aus der Schnittstellenbeschreibung

Generieren Sie mittels der von Quarkus bereitgestellten Maven-Plugins den Code für die Clients der beiden Services im 
Projects Service.
Implementieren Sie notwendige Funktionalitäten im Projects Service, um die Clients zu verwenden.

