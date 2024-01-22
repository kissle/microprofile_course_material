# 01 Basics Übungen

MicroProfile ist eine Spezifikation für die Entwicklung von Microservices auf Basis von Java EE. Damit steht als zentraler Lehrinhalt dieses Kurses die Entwicklung von Microservives im Vordergrund. 

Unter Microservices verstehen wir hierbei eine Architektur, die aus einer Vielzahl von kleinen, unabhängigen Services besteht. Diese Services können in unterschiedlichen Programmiersprachen geschrieben sein und werden über das Netzwerk miteinander verbunden. Für den Betrieb wählt man heute meistens Container Technologien wie Docker oder Kubernetes. Mit diesem Architekturstil verfolgt man üblicherweise das Ziel, die Komplexität der Anwendung zu reduzieren und die Skalierbarkeit zu verbessern. D.h. auch bei spontanen Lastspitzen kann die Anwendung weiterhin performant betrieben werden, ohne dauerhaft Ressourcen zu verschwenden.

Um den Nutzen von MicroProfile bewerten zu können schauen wir uns zunächst den Einsatz bekannter Java Frameworks, die nicht explizit für den Einsatz von MicroServices konzipiert wurden, an und bewerten, ob diese das Ziel einer schnellen Skalierung bei spontanen Lasten erfüllen können.

Dazu bauen wir jeweils eine einfache Web-Applikation, die mittels einer REST-Schnittstelle eine einfache "Hello, World!" nachricht zurückgibt. Diese Applikationen werden wir anschließend bauen und mittels der JVM auf ihrem System ausführen. 

## OpenLiberty Jakarta EE 10

Im Ordner `jakartaee` finden sie ein Beispielprojekt, dass auf `https://openliberty.io/start/` erzeugt wurde.
Hierbei wurde Jakarta EE 10 als Basis mit der Java Version 17 gewählt. MicroProfile wird in diesem Projekt nicht verwendet.

**Aufgabe 1:** Wie groß ist der Projektordner *vor* dem ersten Ausführen des Entwicklungsservers?

Das Projekt beinhaltet bereits die notwendigen Maven Dateien, sodass Sie die Anwendung direkt mit dem Befehl `.\mvnw liberty:dev` als Entwicklungsserver starten können.

Maven wird anschließend zunächst die relevanten Pakete herunterladen und anschließend die Anwendung starten.

Wenn die Anwendung gestartet ist, sollte ihnen eine ähnliche Ausgabe angezeigt werden:

```bash
[INFO] [AUDIT   ] CWWKT0017I: Webanwendung entfernt (default_host): http://localhost:9080/
[INFO] [AUDIT   ] CWWKZ0009I: Die Anwendung jakartaee wurde erfolgreich gestoppt.
[INFO] [AUDIT   ] CWWKT0016I: Webanwendung verfügbar: (default_host): http://localhost:9080/
[INFO] [AUDIT   ] CWWKZ0003I: Die Anwendung jakartaee wurde nach 0,397 Sekunden aktualisiert.
``` 

Sie können die Applikation nun in ihrem Browser unter `http://localhost:9080/api/hello` aufrufen und sollten die Nachricht "Hello, World!" sehen.

**Aufgabe 2:** Wie groß ist der Projektordner *nach* dem ersten Ausführen des Entwicklungsservers?

Erstellen sie als nächstes eine ausführbare `*.jar` Datei, die sie mittels `java -jar` ausführen können.

Zum erstellen der ausführbaren `*.jar` Datei können Sie die folgenden Befehl ausführen.

```bash
.\mvnw liberty:package -Dinclude=runnable
```


**Aufgabe 3:** Wie groß ist die erzeugte Datei `./target/jakartaee.jar`?

Zum Starten der Anwendung können Sie die `*.jar` Datei mittels

```bash 
java -jar target/jakartaee.jar
```

starten. Die Ausgabe unten, gibt ausschluss darüber, wie lange der Start der Applikation gedauert hat.

```bash 
[AUDIT   ] CWWKE0001I: Der Server defaultServer wurde gestartet.
[WARNUNG ] CWWKS3103W: Es sind keine Benutzer für die BasicRegistry-Konfiguration der ID com.ibm.ws.security.registry.basic.config[basic] definiert.
[AUDIT   ] CWWKZ0058I: dropins auf Anwendungen überwachen.
[AUDIT   ] CWWKT0016I: Webanwendung verfügbar: (default_host): http://localhost:9080/
[AUDIT   ] CWWKZ0001I: Die Anwendung jakartaee ist nach 5,243 Sekunden gestartet.

```

**Aufgabe 4:** Wie lange dauert der Start der Anwendung?


## MicroProfile 

Im Ordner microprofile finden sie ein Beispielprojekt, dass auf https://openliberty.io/start/ erzeugt wurde.
Hierbei wurde MicroProfile 6 als Basis mit der Java Version 17 gewählt. 

**Aufgabe 1:** Wie groß ist der Projektordner *vor* dem ersten Ausführen des Entwicklungsservers?

Das Projekt beinhaltet bereits die notwendigen Maven Dateien, sodass Sie die Anwendung direkt mit dem Befehl `.\mvnw liberty:dev` starten können.

Maven wird anschließend zunächst die relevanten Pakete herunterladen und anschließend die Anwendung starten.

Wenn die Anwendung gestartet ist, sollte ihnen eine ähnliche Ausgabe angezeigt werden:

```bash
[INFO] [AUDIT   ] CWWKT0017I: Webanwendung entfernt (default_host): http://localhost:9080/
[INFO] [AUDIT   ] CWWKZ0009I: Die Anwendung jakartaee wurde erfolgreich gestoppt.
[INFO] [AUDIT   ] CWWKT0016I: Webanwendung verfügbar: (default_host): http://localhost:9080/
[INFO] [AUDIT   ] CWWKZ0003I: Die Anwendung jakartaee wurde nach 0,397 Sekunden aktualisiert.
``` 

Sie können die Applikation nun in ihrem Browser unter `http://localhost:9080/` aufrufen und sollten eine Startseite von OpenLiberty sehen.

**Aufgabe 2:** Wie groß ist der Projektordner *nach* dem ersten Ausführen des Entwicklungsservers?

Zum erstellen der ausführbaren `*.jar` Datei können Sie die folgenden Befehl ausführen.

```bash
.\mvnw liberty:package -Dinclude=runnable
```

**Aufgabe 3:** Wie groß ist die erzeugte Datei `./target/microprofile.jar`?

Zum Starten der Anwendung können Sie die `*.jar` Datei mittels

```bash
java -jar target/microprofile.jar
```
starten.

**Aufgabe 4:** Wie lange dauert der Start der Anwendung?

## Quarkus

Im Ordner quarkus finden sie ein Beispielprojekt, dass auf https://code.quarkus.io/ erzeugt wurde.
Hierbei wurden einige Erweiterungen ausgewählt, die die MicroProfile 6 Spezifikationen erfüllen.

**Aufgabe 1:** Wie groß ist der Projektordner *vor* dem ersten Ausführen des Entwicklungsservers?

Das Projekt beinhaltet bereits die notwendigen Maven Dateien, sodass Sie die Anwendung direkt mit dem Befehl `.\mvnw quarkus:dev` starten können.

Maven wird anschließend zunächst die relevanten Pakete herunterladen und anschließend die Anwendung starten.

Wenn die Anwendung gestartet ist, sollte ihnen eine ähnliche Ausgabe angezeigt werden:

```bash
Listening for transport dt_socket at address: 5005
{"timestamp":"2023-12-04T18:56:37.627409+01:00","sequence":2381,"loggerClassName":"org.jboss.logging.Logger","loggerName":"io.quarkus","level":"INFO","message":"quarkus 1.0.0-SNAPSHOT on JVM (powered by Quarkus 3.6.0) started in 2.955s. Listening on: http://localhost:8080","threadName":"Quarkus Main Thread","threadId":129,"mdc":{},"ndc":"","hostName":"alexanders-mbp.fritz.box","processName":"quarkus-dev.jar","processId":45411}
{"timestamp":"2023-12-04T18:56:37.633737+01:00","sequence":2382,"loggerClassName":"org.jboss.logging.Logger","loggerName":"io.quarkus","level":"INFO","message":"Profile dev activated. Live Coding activated.","threadName":"Quarkus Main Thread","threadId":129,"mdc":{},"ndc":"","hostName":"alexanders-mbp.fritz.box","processName":"quarkus-dev.jar","processId":45411}
{"timestamp":"2023-12-04T18:56:37.634336+01:00","sequence":2383,"loggerClassName":"org.jboss.logging.Logger","loggerName":"io.quarkus","level":"INFO","message":"Installed features: [cache, cdi, opentelemetry, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, smallrye-health, smallrye-metrics, smallrye-openapi, spring-cache, swagger-ui, vertx]","threadName":"Quarkus Main Thread","threadId":129,"mdc":{},"ndc":"","hostName":"alexanders-mbp.fritz.box","processName":"quarkus-dev.jar","processId":45411}
``` 

Sie können die Applikation nun in ihrem Browser unter `http://localhost:8080/` aufrufen und sollten eine Startseite von OpenLiberty sehen.

**Aufgabe 2:** Wie groß ist der Projektordner *nach* dem ersten Ausführen des Entwicklungsservers?

Quarkus bietet für Entwickler eine ausführlichere Startseite an, die auch auf die integrierte Dev-UI, dies sie auch unter
`http://localhost:8080/q/dev/` aufrufen können. Schauen Sie sich hier einmal um, um die Funktionen zu erkunden.

Zum erstellen der ausführbaren `*.jar` Datei können Sie die folgenden Befehl ausführen.

```bash
.\mvnw clean package
```

Dies erstellt die `quarkus-run.jar` Datei im `target/quarkus-app/` Verzeichnis. Diese Datei ist jedoch kein _über-jar_, 
da die Abhängigkeiten in das `target/quarkus-app/lib/` Verzeichnis kopiert werden.

**Aufgabe 3:** Wie groß ist die erzeugte Datei `./target/quarkus-app/quarkus-run.jar`?

Zum Starten der Anwendung können Sie die `*.jar` Datei mittels

```bash
java -jar target/quarkus-app/quarkus-run.jar
```
starten.

Zum erzeugen der _über-jar_ Datei können Sie den folgenden Befehl ausführen:

```bash
.\mvnw package -Dquarkus.package.type=uber-jar
```

Die Anwendung lässt sich anschließend mittels

```bash
java -jar target/quarkus-1.0.0-SNAPSHOT-runner.jar
```
starten.
