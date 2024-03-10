# Testing

Testing ist ein wichtiger Bestandteil der Softwareentwicklung und vor allem im Umfeld von Microservices von großer Bedeutung.

Wie Sie im Kapitel zu OpenTelemetry gesehen haben, ist es schwierig, verteilte Systeme zu debuggen. 
Daher ist es wichtig, dass Sie Ihre Services unter den richtigen Annahmen testen, um im kleinen System die 
Funktionalität sicherzustellen. 

Sie müssen sich bewusst sein, dass Sie in einem verteilten System nicht alle möglichen Fehlerfälle testen können. 
Sie werden darauf angewiesen sein, dass andere Services die im Voraus getroffenen Absprachen einhalten und nur 
gegen diese Absprachen können Sie ihre Tests entwickeln. 

## Aufgabenstellung

### 1. Unit Tests

Implementieren Sie Unit Tests für Ihre Services. Orientieren Sie sich dabei an der Quarkus Dokumentation
[Testing Your Application](https://quarkus.io/guides/getting-started-testing).

### 2. Mocking

Während des Testens können Sie nicht davon ausgehen, dass andere Services verfügbar sind oder ihre Funktionalität
korrekt implementiert haben. Daher müssen Sie die Kommunikation mit anderen Services mocken.

Im Quarkus Guide [Mocking CDI beans in Quarkus](https://quarkus.io/blog/mocking/#using-injectmock) finden Sie hilfreiche
Informationen. 

### 3. Integration Tests

Um Sicherzustellen, dass Ihre angebotenen Schnittstellen die getroffenen Absprachen einhalten, sollten Sie diese ebenfalls
testen. Erstellen Sie Tests für Ihre Rest-Schnittstellen.