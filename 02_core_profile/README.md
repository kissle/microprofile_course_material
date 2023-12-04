# 02 Jakarta EE Core Profile 

Das Jakarta EE Core Profile definiert eine minimale Menge von Spezifikationen, die für die Entwicklung von 
Enterprise-Anwendungen erforderlich sind. 
Das Core Profile ist für die Entwicklung von Enterprise-Anwendungen gedacht, die auf einem Java EE 8-kompatiblen 
Server ausgeführt werden.

Ein Teil dieser Spezifikation ist Jax-RS, welches wir in diesem Beispiel verwenden werden. Jax-RS ist eine 
Spezifikation für RESTful Webservices.

In unserem Quarkus Beispiel werden wir einen RESTful Webservice implementieren, der eine einfache Hallo Welt 
Schnittstelle bereitstellt.

Auch wenn dieser Service sehr einfach ist, werden wir die wichtigsten Konzepte von Quarkus kennenlernen und auf eine 
saubere und strukturierte Architektur
wert legen. 

Die Entity-control-boundary (ECB) Architektur ist ein Architekturmuster, das die Anwendung in drei Hauptkomponenten unterteilt:
Entitäten, Steuerungen und Grenzen. 

Die Entitäten sind die Daten, die von der Anwendung verarbeitet werden. In den Steuerungsklassen definieren wir die 
Geschäftslogik für den Zugriff auf unsere Entitäten. Die Grenzen sind die Schnittstellen, die von externen Clients 
verwendet werden, um mit der Anwendung zu interagieren. 

## Aufgaben

### 1. Hello-World Endpunkt

Erstellen Sie einen RESTful Webservice, der eine einfache Hallo Welt Schnittstelle bereitstellt. Definieren Sie dazu
die Packages `entity`, `control` und `boundary`. 

Im `entity` Package erstellen Sie eine Klasse `Message` mit den Attributen `heading` und `body` vom Typ String.

Im `control` Package erstellen Sie eine Klasse `MessageService` mit folgenden Methoden. 

* `getHelloWorldMessage()` liefert eine Message mit dem heading "Hello World" und dem body "Hello World from Quarkus"
* `getMessage(String heading, String body)` liefert eine Message mit den übergebenen Parametern
* `getMessageAsString(Message message)` liefert eine Message als String im Format "heading: body"
* `addMessage(Message message)` fügt eine Message der Liste hinzu
* `getAllMessages()` liefert eine Liste aller Messages

Stellen Sie sicher, dass die Klasse `MessageService` als CDI Bean erkannt wird und implementieren Sie geeignete 
Attribute, um die Messages zu speichern. Es ist nicht notwendig, eine Datenbank zu verwenden.

Im `boundary` Package erstellen Sie eine Klasse `MessageResource`. Diese Klasse verwendet über CDI den `MessageService`
und stellt folgende RESTful Endpunkte bereit:

* `GET /messages/hello` liefert eine Message mit dem heading "Hello World" und dem body "Hello World from Quarkus"
* `GET /messages/get` liefert eine Message mit den übergebenen URL-Parametern
* `POST /messages` fügt eine Message der Liste hinzu
* `GET /messages` liefert eine Liste aller Messages
* `GET /messages/string` liefert eine Message als String im Format "heading: body"

Beachten Sie, dass alle Endpunkte eine JSON-Response liefern sollen und die passenden Annotationen verwendet werden.

### 2. POJOs

Erweitern Sie die Beispiele aus Aufgabe 1 so, dass die Endpunkte POJOs statt JSON-Response liefern. 

*Hinweis: Verwenden Sie die Bibliothek `quarkus-resteasy-reactive-jackson` für diese Aufgabe*


### 3. Logging Interceptor

Erstellen Sie einen Logging Interceptor, der alle Requests in der Form "Request: <HTTP-Methode> <URL>" und alle
Responses in der Form "Response: <HTTP-Statuscode>" loggt in die Konsole loggt.

### Fragen

1. Was ist der Vorteil von `quarkus-resteasy-reactive` gegenüber `quarkus-resteasy` (Classic)?
2. Warum benötigen wir `quarkus-resteasy-reactive-jackson` für POJOs?