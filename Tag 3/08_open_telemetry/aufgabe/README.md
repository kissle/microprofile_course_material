# MicroProfile OpenTelemetry

Verteilte Systeme sind schwerer zu überwachen und zu debuggen als monolithische Anwendungen. Um dennoch 
Rückschlüsse auf den Systemzustand ziehen zu können, werden in verteilten Systemen häufig Metriken und Trace-Informationen
gesammelt. Diese Informationen werden in einem zentralen System gesammelt und können dort ausgewertet werden.

In diesem Beispiel nutzer wir das Tracing Tool [Jaeger](https://www.jaegertracing.io), 
um Informationen über unsere Services zu sammeln. 

## Aufgabenstellung

### 1. Services um OpenTelemetry erweitern

Fügen Sie die notwendigen Abhängigkeiten zu den Services hinzu, um OpenTelemetry zu nutzen. 

```xml 
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-opentelemetry</artifactId>
</dependency>
```


### 2. Jaeger starten

Wir verwenden Jaeger als Tracing Tool und nutzen für den Betrieb Docker. 
Erweitern Sie Ihre `docker-compose.yml` aus Übung 04 Health und Metrics um einen Jaeger Service. 

```yaml
  jaeger:
    image: jaegertracing/all-in-one
    container_name: jaeger2
    ports:
      - "16686:16686"
      - "6831:6831/udp"
      - "6832:6832/udp"
      - "5775:5775/udp"
      - "14268:14268"
      - "14250:14250"
      - "9411:9411"
      - "4317:4317"
    restart: always
```

Starten Sie Jaeger mit `docker-compose up --build`, um den Container neu zu erstellen und Jaeger mit den 
notwendigen Ports zu starten. Sie können die Jaeger UI unter http://localhost:16686 aufrufen.

Wenn dieser Service läuft und unsere Microservices um OpenTelemetry erweitert sind, sollten diese die Tracing-Informationen
automatisch an Jaeger senden.

### 3. Tracing konfigurieren

Ergänzen Sie Ihre Services, um geeignete Tracing-Informationen zu sammeln. 
