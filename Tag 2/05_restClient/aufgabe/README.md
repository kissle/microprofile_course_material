# MicroProfile Rest Client

In der vorherigen Übung haben Sie den Service A kennengelernt. In dieser Übung finden Sie zusätzlich 
einen Service B. Ziel dieser Übung ist es eine Kommunikation zwischen den beiden Services aufzubauen, sodass 
diese Nachrichten austauschen können. Beachten Sie, dass die Modelle von `Message` sich unterscheiden. 
Sie müssen daher in beiden Services entsprechende Repräsentation anlegen, um anschließend mit MircoProfile Rest Client die Schnittstellen des jeweils anderen Services anzusprechen. 


## Aufgabenstellung

### RestClient in Quarkus

Untersuchen Sie die `pom.xml` des Skills Service. Welche Abhängigkeiten werden hier verwendet, um den 
MicroProfile Rest Client zu verwenden?


### RestClient implementieren

Implementieren Sie die Klasse ServiceARestClient und ServiceBRestClient in den entsprechenden Services, um die Kommunikation zwischen den Services zu realisieren. 

Egal welchen Service der Nutzer anfragt, soll eine Liste aller Messages als String aus beiden Services zurückgegeben werden.

In beiden Services soll es möglich sein neue Nachrichten egal welchen Formats anzulegen. Der endgültige Speicherort, wird während der Laufzeit anhand der Payload entschieden.
