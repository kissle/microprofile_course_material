# MicroProfile Health und Metrics 

In dieser Übung werden wir die MicroProfile Health und Metrics APIs verwenden, um die Gesundheit und Metriken 
unserer Anwendung zu überwachen. Hierzu finden Sie den in den Schulungsunterlagen beschrieben Employees Service als
Beispiel. 

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

Untersuchen Sie die Auswirkungen auf die Anwendung. Welche neuen Endpunkte sind verfügbar?

### Einrichten von Prometheus

Prometheus ist ein Open Source Monitoring System, das Metriken von Anwendungen sammelt und diese in einer Zeitreihe
Datenbank speichert.

Wir werden Prometheus mittels Docker Compose starten. Fügen Sie die Datei `compose.yaml` mit folgendem Inhalt 
zu Ihrem Projekt hinzu: 

```yaml
version: '3.7'

services:
  prometheus:
    image: prom/prometheus
    container_name: prometheus2
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
  - job_name: employees
    static_configs:
      - targets: ['host.docker.internal:8080']
    metrics_path: '/q/metrics'
    scrape_interval: 1s
```

Die Konfiguration enthält zwei Jobs. Der erste Job sammelt Metriken von Prometheus selbst. Der zweite Job sammelt
Metriken von unserem Employees Service.

Sie können die UI von Prometheus unter http://localhost:9090 aufrufen. Stellen Sie sicher, dass der Employees Service
gestartet ist und navigieren Sie zu http://localhost:9090/targets. Sie sollten dort den Employees Service sehen.

### Ergänzen Sie die Anwendung um Metriken

Ergänzen Sie die Anwendung um Ihnen geeignet erscheinende Metriken. Sie können die Metriken, wie in den 
Schulungsunterlagen beschrieben verwenden. Orientieren Sie sich an der MicroProfile Metrics Dokumentation und den 
entsprechenden Dokumentationen von SmallRye Metrics und SmallRye Health.