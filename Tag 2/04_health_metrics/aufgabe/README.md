# MicroProfile Health und Metrics 

In dieser Übung werden wir die MicroProfile Health und Metrics APIs verwenden, um die Gesundheit und Metriken 
unserer Anwendung zu überwachen. 

Dazu betrachten wir den Service A, der eine Erweiterung unseres bisherigen Service zum Senden und Empfangen noch `Messages` ist. 

Wie in den vorherigen Übungen verwenden wir das entity-control-boundary Pattern. 

## Aufgaben 

### Erweitern Sie die Anwendung um die Health und Metrics APIs

Fügen Sie die folgenden Abhängigkeiten zu Ihrer Quarkus Anwendung hinzu: 

```xml
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-smallrye-health</artifactId>
</dependency>
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-smallrye-metrics</artifactId>
</dependency>
```

Wie Sie sehen nutzen wir nicht direct die MicroProfile Health und Metrics APIs, sondern die entsprechenden
Implementierungen von [SmallRye Health](https://quarkus.io/guides/smallrye-health) sowie 
[SmallRye Metrics](https://quarkus.io/guides/smallrye-metrics). 

Untersuchen Sie die Auswirkungen auf die Anwendung. 
- Welche neuen Endpunkte sind verfügbar? 
- Wie unterscheiden sich diese im Vergleich zur Spezifikation genannten Endpunkte? 
- Welche Metriken werden standardmäßig gesammelt und hilft Ihnen diese Ansicht bei der Auswertung?
- Welche zusätzlichen Tools finden Sie in der Dev-UI?

Beachten Sie, dass Sie hierzu den Service mittels `.\mvnw quarkus:dev` starten müssen.


### Einrichten von Prometheus

Prometheus ist ein Open Source Monitoring System, das Metriken von Anwendungen sammelt und diese in einer Zeitreihen
Datenbank speichert.

Wir werden Prometheus mittels Docker Compose starten. Fügen Sie die Datei `compose.yml` mit folgendem Inhalt 
zu Ihrem Projekt hinzu: 

```yaml
version: '3.7'

services:
  prometheus:
    image: prom/prometheus
    container_name: prometheus
    volumes:
      - ./prometheus.yml:/etc/prometheus/prometheus.yml
    command:
      - '--config.file=/etc/prometheus/prometheus.yml'
    ports:
      - "9090:9090"
    restart: always
```

Zusätzlich benötigen Sie eine Konfigurationsdatei für Prometheus. Fügen Sie die Datei `prometheus.yml` mit folgendem
Inhalt zu Ihrem Projekt hinzu: 

```yaml
scrape_configs:
  - job_name: prometheus
    static_configs:
      - targets: ['host.docker.internal:9090']
  - job_name: service_a
    static_configs:
      - targets: ['host.docker.internal:8080']
    metrics_path: '/q/metrics'
    scrape_interval: 1s
```

Die Konfiguration enthält zwei Jobs. Der erste Job sammelt Metriken von Prometheus selbst. Der zweite Job sammelt
Metriken von unseres `service_a` Service.

Beachten Sie, dass für die Docker Engine gestartet sein muss. Starten Sie dazu Docker Desktop.

Starten Sie nun Prometheus mittels `docker compose up`, um die das Docker Image von Docker Hub zu 
laden und den Container mit der spezifizierten Configuration zu starten.

Sie können die UI von Prometheus unter http://localhost:9090 aufrufen. 
Stellen Sie sicher, dass der Employees Service gestartet ist und navigieren Sie zu http://localhost:9090/targets.
Wenn der Service mit den korrekten Dependencies für Health und Metrics gestartet wurde,
sollte der Status des Targets `service_a` sowie `prometheus` `UP` sein.

Auf der Startseite können Sie die Metriken des Employees Service abfragen. Prometheus verwendet hierbei 
eine eigene Abfragesprache. Als Hilfestellung können die Verfügbaren in der Suchleiste über das Globus Symbol
angezeigt werden. In dieser Liste sollten Sie Metriken zu Prometheus sowie, Ihres Employees Service
finden. Schauen Sie sich auch die Darstellung als Graph an. 

Beachten Sie, dass die Metriken für beide Services entsprechend der Konfiguration unterschiedlich
häufig abgefragt werden.

### Ergänzen Sie die Anwendung um Metriken

Ergänzen Sie die Anwendung um Ihnen geeignet erscheinende Metriken. 
Sie können die Metriken, wie in den Schulungsunterlagen beschrieben verwenden.
Orientieren Sie sich an der MicroProfile Metrics Dokumentation und den entsprechenden 
Dokumentationen von SmallRye Metrics und SmallRye Health.

Verwenden Sie an passenden Stellen die Annotation `@Counted` um die Anzahl der Aufrufe zu zählen.
Verwenden Sie an passenden Stellen die Annotation `@Timed` um die Dauer von Aufrufen zu messen.
Verwenden Sie an passenden Stellen die Annotation `@Gauge` um einen Wert zu messen.

Inspizieren Sie die Metriken mittels Prometheus. Welche Auswirkungen haben Ihre Aufrufe der 
Endpunkte des Employees Service auf die Metriken?