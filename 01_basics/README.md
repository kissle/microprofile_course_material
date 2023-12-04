# 01 Basics Übungen

In diesem Verzeichnis finden Sie die Ordner für die Übungen des ersten Teils des Kurses.

Ziel der Übungen ist es ihnen ein erstes Grundverständnis der Bedeutung von MicroProfile zu vermitteln. 
Dazu schauen wir uns unterschiedliche Frameworks an und bewerten diese hinsichtlich ihrer Eignung für eine Microservice Architektur.

## OpenLiberty Jakarta EE 10

Im Ordner jakartaee finden sie ein Beispielprojekt, dass auf https://openliberty.io/start/ erzeugt wurde. 
Hierbei wurde Jakarta EE 10 als Basis mit der Java Version 17 gewählt. MicroProfile wird in diesem Projekt nicht verwendet.

Das Projekt beinhaltet bereits die notwendigen Maven Dateien, sodass Sie die Anwendung direkt mit dem Befehl `mvnw liberty:dev` starten können.

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
mvnw clean package
```

Anschließend können Sie die ausführbare `*.jar` Datei mittels
```
mvnw liberty:package -Dinclude=runnable
```
erzeugen. 

Zum Starten der Anwendung können Sie die `*.jar` Datei mittels
```
java -jar target/jakartaee.jar
```
starten.

Beantworten Sie folgende Fragen:
* Wie groß ist die erzeugte `*.jar` Datei?
* Wie lange dauert der Start der Anwendung?
* Wie lange dauert es die Ausführbare `*.jar` Datei zu erzeugen?
* Wie lange dauert der Start der Anwendung, wenn Sie die Anwendung mittels `mvnw liberty:dev` starten?
