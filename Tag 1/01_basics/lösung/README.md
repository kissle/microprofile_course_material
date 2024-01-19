# Lösungen 01_basics 

## Jakartaee 10 mit OpenLiberty

### Wie groß ist der Projektordner vor dem ersten Ausführen des Entwicklungsservers?

~ 82kB

### Wie groß ist der Projektordner nach dem ersten Ausführen des Entwicklungsservers?

~ 173 MB

### Wie groß ist die erzeugte `./target/jakartaee.jar` Datei?

~ 13,4 MB

### Wie lange dauert der Start der Anwendung?

~ 0,833 Sekunden

## MicroProfile 6 mit OpenLiberty

### Wie groß ist der Projektordner vor dem ersten Ausführen des Entwicklungsservers?

~ 88kB

### Wie groß ist der Projektordner nach dem ersten Ausführen des Entwicklungsservers?

~ 29 MB

### Wie groß ist die erzeugte `./target/jakartaee.jar` Datei?

~ 13,4 MB

### Wie lange dauert der Start der Anwendung?

~ 0,826 Sekunden


## MicroProfile mit Quarkus

### Wie groß ist der Projektordner vor dem ersten Ausführen des Entwicklungsservers?

~ 352kB

### Wie groß ist der Projektordner nach dem ersten Ausführen des Entwicklungsservers?

~ 690 kB

### Wie groß ist die erzeugte `./target/quarkus-app/quarkus-run.jar` Datei?

~ 1 kB

### Wie lange dauert der Start der Anwendung?

~ 5 Millisekunden

## Final Thoughts

Die Jakarta Applikation mit OpenLiberty ist die größte der drei Applikationen, was sich an der größe des Projektordners nach dem Starten des Entwicklungsservers zeigt.

In diesem Beispiel scheinen die kompilierten OpenLiberty Applikationen eine gleiche Größe zu erreichen. In der Praxis wird sich jedoch zeigen, dass MicroProfile entsprechend des Namens einen kleinen Fußabdruck hinterlässt, da nur die benötigten Bibliotheken mitgeliefert und packetiert werden. 

Quarkus ist in diesem Beispiel die kleinste Applikation, wenn dies auch einen unfairen vergleich darstellt. Es läst sich jedoch feststellen, dass Quarkus einen anderen Ansatz verfolgt und für den Betrieb von Microservices optimiert wird. In einer späteren Übung werden wir noch die Möglichkeit von Quarkus eine native Applikation zu erzeugen betrachten.