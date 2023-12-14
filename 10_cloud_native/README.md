# Cloud-Native Application Development

Moderne Applikationen werden heute in der Regel als Cloud-Native Applikationen entwickelt. 
Dabei sind die Themen Microservices, Container, Kubernetes, Service Meshes, Observability, Resilience, 
Security und DevOps von großer Bedeutung.

In dieser Übung untersuchen wir die Basis-Technologien, die für Cloud-Native Applikationen relevant sind.

## Aufgabenstellung

### 1. Dockerfile 

Erstellen Sie ein `Dockerfile` mit dem Sie in der Lage sind einen eine einfache statische HTML-Seite auszuliefern.

Beachten Sie, dass sie die `nginx.conf` noch ersetzen sollten. Hier finden Sie ein geeignetes Beispiel:

```nginx
server {
    listen       80;
    server_name  localhost;

    location / {
        root   /usr/share/nginx/html;
        index  index.html;
    }

    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   /usr/share/nginx/html;
    }
}
```

Für die HTML-Seite legen Sie bitte in eigenes Beispiel einer `index.html` an und übertragen es in das Image.

### 2. Quarkus und Docker

Bei unseren Services ist Ihnen vielleicht bereits aufgefallen, dass die Quarkus Projekte einen Docker Ordner enthalten.
Dieser Ordner enthält unterschiedliche Dockerfiles, die es ermöglichen, die Quarkus Applikationen als Docker Container
auszuführen.

#### 2.1 Dockerfile.jvm

Untersuchen Sie das Dockerfile.jvm. Welche Schritte werden hier ausgeführt? 
Starten Sie Ihre Applikationen und Testen Sie die Funktionalität. 
Wie lange dauert es, bis die Applikation gestartet ist? 


#### 2.2 Dockerfile.native-micro 

Untersuchen Sie das Dockerfile.native-micro. Welche Schritte werden hier ausgeführt?
Stellen Sie sicher, dass in den application.properties die Option `quarkus.native.container-build=true` gesetzt ist, um 
GraalVM im Container zu nutzen.
Starten Sie Ihre Applikationen und Testen Sie die Funktionalität.
Wie lange dauert es, bis die Applikation gestartet ist?
Was ist eine native Applikation?

#### 2.4 Docker Compose

Kopieren Sie Ihr `compose.yml` Beispiel aus der Übung 04_health_metrics. Ergänzen Sie dieses, um die zuvor gebauten Services.
Achten Sie darauf, dass Sie geeignete Ports für die Services setzen. Überschreiben Sie dabei mittels einer Definition 
von Umgebungsvariablen im `compose.yml` die Werte aus den `application.properties`.

Wenn Sie erfolgreich waren, sehen Sie nun, dass die Services `Prometheus`, `Employees` und `Skills` gestartet wurden. 
Können die Metriken weiterhin in Prometheus gelesen werden?

### Minikube

Minikube ist ein Tool, mit dem Sie Kubernetes lokal ausführen können. Hierbei ist es möglich einen Node zu betreiben 
und die Kubernetes API zu nutzen. Für die Verwaltung können Sie auch eine GUI im Brower nutzen. 

Minikube ist bereits auf Ihrem System installiert.

Orientieren Sie sich an der [Minikube Dokumentation - Kubernetes 101](https://minikube.sigs.k8s.io/docs/tutorials/kubernetes_101/), 
um Ihre Services in Kubernetes zu deployen.