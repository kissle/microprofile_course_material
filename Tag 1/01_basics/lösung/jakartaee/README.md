# Lösungen 01_basics jakartaee

## Wie groß ist der Projektordner vor dem ersten Ausführen des Entwicklungsservers?

~ 82kB

## Wie groß ist der Projektordner nach dem ersten Ausführen des Entwicklungsservers?

~ 173 MB

## Wie groß ist die erzeugte `./target/jakartaee.jar` Datei?

~ 13,4 MB

## Wie lange dauert der Start der Anwendung?

~ 0,833 Sekunden


## Final Thoughts

Für den Betrieb eines Microservices ist diese Applikation jedoch nicht geeignet, da sie nicht als Microservice konzipiert wurde.
Dies zeigt sich unter anderem daran, dass die erzeugte `*.jar` Datei über 100 MB groß ist und ein dynamisches Deployment dadurch beeinträchtigt wird.