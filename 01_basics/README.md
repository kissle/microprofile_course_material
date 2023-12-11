# 01 Basics Übungen

In diesem Verzeichnis finden Sie die Ordner für die Übungen des ersten Teils des Kurses.

Ziel der Übungen ist es ihnen ein erstes Grundverständnis der Bedeutung von MicroProfile zu vermitteln. 
Dazu schauen wir uns unterschiedliche Frameworks an und bewerten diese hinsichtlich ihrer Eignung für eine Microservice Architektur.

## OpenLiberty Jakarta EE 10

Im Ordner jakartaee finden sie ein Beispielprojekt, dass auf https://openliberty.io/start/ erzeugt wurde.
Hierbei wurde Jakarta EE 10 als Basis mit der Java Version 17 gewählt. MicroProfile wird in diesem Projekt nicht verwendet.

Das Projekt beinhaltet bereits die notwendigen Maven Dateien, sodass Sie die Anwendung direkt mit dem Befehl `.\mvnw liberty:dev` starten können.

Maven wird anschließend zunächst die relevanten Pakete herunterladen und anschließend die Anwendung starten.

Wenn die Anwendung gestartet ist, sollte ihnen eine ähnliche Ausgabe angezeigt werden:

```
[INFO] [AUDIT   ] CWWKT0017I: Webanwendung entfernt (default_host): http://localhost:9080/jakartaee/
[INFO] [AUDIT   ] CWWKZ0009I: Die Anwendung jakartaee wurde erfolgreich gestoppt.
[INFO] [AUDIT   ] CWWKT0016I: Webanwendung verfügbar: (default_host): http://localhost:9080/jakartaee/
[INFO] [AUDIT   ] CWWKZ0003I: Die Anwendung jakartaee wurde nach 0,397 Sekunden aktualisiert.
``` 

Sie können die Applikation nun in ihrem Browser unter `http://localhost:9080/` aufrufen und sollten eine Startseite von OpenLiberty sehen.

Für den Betrieb eines Microservices ist diese Applikation jedoch nicht geeignet, da sie nicht als Microservice konzipiert wurde.
Dies zeigt sich unter anderem daran, dass die erzeugte `*.jar` Datei über 100 MB groß ist und ein dynamisches Deployment dadurch beeinträchtigt wird.

Zum erstellen der ausführbaren `*.jar` Datei können Sie die folgenden Befehl ausführen.

Erstellen Sie eine `*.war` Datei mittels:
```
.\mvnw clean package
```

Anschließend können Sie die ausführbare `*.jar` Datei mittels
```
.\mvnw liberty:package -Dinclude=runnable
```
erzeugen. 

Zum Starten der Anwendung können Sie die `*.jar` Datei mittels
```
java -jar target/jakartaee.jar
```
starten.

### Beantworten Sie folgende Fragen:

* Wie groß ist die erzeugte `*.jar` Datei?
* Wie lange dauert der Start der Anwendung?
* Wie lange dauert es die ausführbare `*.jar` Datei zu erzeugen?
* Wie lange dauert der Start der Anwendung, wenn Sie die Anwendung mittels `.\mvnw liberty:dev` starten?

## MicroProfile 

Im Ordner microprofile finden sie ein Beispielprojekt, dass auf https://openliberty.io/start/ erzeugt wurde.
Hierbei wurde MicroProfile 6 als Basis mit der Java Version 17 gewählt. 

Das Projekt beinhaltet bereits die notwendigen Maven Dateien, sodass Sie die Anwendung direkt mit dem Befehl `.\mvnw liberty:dev` starten können.

Maven wird anschließend zunächst die relevanten Pakete herunterladen und anschließend die Anwendung starten.

Wenn die Anwendung gestartet ist, sollte ihnen eine ähnliche Ausgabe angezeigt werden:

```
[INFO] [AUDIT   ] CWWKT0017I: Webanwendung entfernt (default_host): http://localhost:9080/microprofile/
[INFO] [AUDIT   ] CWWKZ0009I: Die Anwendung jakartaee wurde erfolgreich gestoppt.
[INFO] [AUDIT   ] CWWKT0016I: Webanwendung verfügbar: (default_host): http://localhost:9080/microprofile/
[INFO] [AUDIT   ] CWWKZ0003I: Die Anwendung jakartaee wurde nach 0,397 Sekunden aktualisiert.
``` 

Sie können die Applikation nun in ihrem Browser unter `http://localhost:9080/` aufrufen und sollten eine Startseite von OpenLiberty sehen.

Zum erstellen der ausführbaren `*.jar` Datei können Sie die folgenden Befehl ausführen.

Erstellen Sie eine `*.war` Datei mittels:
```
.\mvnw clean package
```

Anschließend können Sie die ausführbare `*.jar` Datei mittels
```
.\mvnw liberty:package -Dinclude=runnable
```
erzeugen.

Zum Starten der Anwendung können Sie die `*.jar` Datei mittels
```
java -jar target/microprofile.jar
```
starten.

### Beantworten Sie folgende Fragen:

* Wie groß ist die erzeugte `*.jar` Datei?
* Wie lange dauert der Start der Anwendung?
* Wie lange dauert es die ausführbare `*.jar` Datei zu erzeugen?
* Wie lange dauert der Start der Anwendung, wenn Sie die Anwendung mittels `mvnw liberty:dev` starten?


## Quarkus

Im Ordner quarkus finden sie ein Beispielprojekt, dass auf https://code.quarkus.io/ erzeugt wurde.
Hierbei wurden einige Erweiterungen ausgewählt, die die MicroProfile 6 Spezifikationen erfüllen.

Das Projekt beinhaltet bereits die notwendigen Maven Dateien, sodass Sie die Anwendung direkt mit dem Befehl `.\mvnw quarkus:dev` starten können.

Maven wird anschließend zunächst die relevanten Pakete herunterladen und anschließend die Anwendung starten.

Wenn die Anwendung gestartet ist, sollte ihnen eine ähnliche Ausgabe angezeigt werden:

```
Listening for transport dt_socket at address: 5005
{"timestamp":"2023-12-04T18:56:37.627409+01:00","sequence":2381,"loggerClassName":"org.jboss.logging.Logger","loggerName":"io.quarkus","level":"INFO","message":"quarkus 1.0.0-SNAPSHOT on JVM (powered by Quarkus 3.6.0) started in 2.955s. Listening on: http://localhost:8080","threadName":"Quarkus Main Thread","threadId":129,"mdc":{},"ndc":"","hostName":"alexanders-mbp.fritz.box","processName":"quarkus-dev.jar","processId":45411}
{"timestamp":"2023-12-04T18:56:37.633737+01:00","sequence":2382,"loggerClassName":"org.jboss.logging.Logger","loggerName":"io.quarkus","level":"INFO","message":"Profile dev activated. Live Coding activated.","threadName":"Quarkus Main Thread","threadId":129,"mdc":{},"ndc":"","hostName":"alexanders-mbp.fritz.box","processName":"quarkus-dev.jar","processId":45411}
{"timestamp":"2023-12-04T18:56:37.634336+01:00","sequence":2383,"loggerClassName":"org.jboss.logging.Logger","loggerName":"io.quarkus","level":"INFO","message":"Installed features: [cache, cdi, opentelemetry, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, smallrye-health, smallrye-metrics, smallrye-openapi, spring-cache, swagger-ui, vertx]","threadName":"Quarkus Main Thread","threadId":129,"mdc":{},"ndc":"","hostName":"alexanders-mbp.fritz.box","processName":"quarkus-dev.jar","processId":45411}

--
Tests paused
Press [e] to edit command line args (currently ''), [r] to resume testing, [o] Toggle test output, [:] for the terminal, [h] for more options>

``` 

Sie können die Applikation nun in ihrem Browser unter `http://localhost:8080/` aufrufen und sollten eine Startseite von OpenLiberty sehen.

Quarkus bietet für Entwickler eine ausführlichere Startseite an, die auch auf die integrierte Dev-UI, dies sie auch unter
`http://localhost:8080/q/dev/` aufrufen können. Schauen Sie sich hier einmal um, um die Funktionen zu erkunden.

Zum erstellen der ausführbaren `*.jar` Datei können Sie die folgenden Befehl ausführen.

```
.\mvnw clean package
```

Dies erstellt die `quarkus-run.jar` Datei im `target/quarkus-app/` Verzeichnis. Diese Datei ist jedoch kein _über-jar_, 
da die Abhängigkeiten in das `target/quarkus-app/lib/` Verzeichnis kopiert werden.

Zum Starten der Anwendung können Sie die `*.jar` Datei mittels
```
java -jar target/quarkus-app/quarkus-run.jar
```
starten.

Zum erzeugen der _über-jar_ Datei können Sie den folgenden Befehl ausführen:
```
.\mvnw package -Dquarkus.package.type=uber-jar
```

Die Anwendung lässt sich anschließend mittels
```
java -jar target/quarkus-1.0.0-SNAPSHOT-runner.jar
```
starten.

### Beantworten Sie folgende Fragen:

* Wie groß sind die erzeugten `*.jar` und _über-jar_ Dateien?
* Wie lange dauert der Start der Anwendung?
* Wie lange dauert es die ausführbare `*.jar` Datei zu erzeugen?
* Wie lange dauert der Start der Anwendung, wenn Sie die Anwendung mittels `.\mvnw quarkus:dev` starten?