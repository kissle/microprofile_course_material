# MicroProfile OpenAPI

OpenApi ist eine Spezifikation für die Dokumentation von REST-Schnittstellen.
In dieser Übung werden wir unsere beiden bestehenden Services mit OpenApi dokumentieren und die Dokumentation mit 
Swagger-UI visualisieren. Dies ermöglicht es uns, die Schnittstellen im Browser zu testen.

## Aufgabenstellung

### 1. OpenApi in den beiden Services aktivieren

Erweitern Sie die beiden Services aus Übung 04 und 05 um die Abhängigkeit `microprofile-openapi` in dem Sie die 
`pom.xml` erweitern um `smallrye-open-api`:

```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-smallrye-openapi</artifactId>
</dependency>
```

### 2. OpenApi in den beiden Services konfigurieren

Erweitern Sie die beiden Services A und B, um angemessene Annotationen, um die Schnittstellen zu 
dokumentieren.
Testen Sie Ihre Schnittstellen mit Swagger-UI (`http://localhost:8080/q/swagger-ui/`) und exportieren Sie die 
Schnittstellenbeschreibung als JSON-Datei über die angebotene Schnittstelle `/q/openapi?format=json`.

Beachten Sie die entsprechende Dokumentation [USING OPENAPI AND SWAGGER UI](https://quarkus.io/guides/openapi-swaggerui)

### 3. Code-Generierung aus der Schnittstellenbeschreibung (Bonus)

Generieren Sie mittels der von Quarkus bereitgestellten Maven-Plugins den Code für die Clients der beiden Services im 
Projects Service.
Implementieren Sie notwendige Funktionalitäten im Projects Service, um die Clients zu verwenden.

Befolgen Sie bitte dazu die Anleitung in der Dokumentation:

https://docs.quarkiverse.io/quarkus-openapi-generator/dev/index.html
