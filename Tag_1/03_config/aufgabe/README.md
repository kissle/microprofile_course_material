# MicroProfile Config

In der Übung zuvor haben, wir gesehen, wie wir mit Jakarte EE Core Profile arbeiten können. 
In dieser Übung werden wir uns mit MicroProfile Config beschäftigen. MicroProfile Config ist eine Spezifikation, 
die es uns ermöglicht, Konfigurationsparameter aus unterschiedlichen Quellen zu laden und in unsere Anwendung 
zu injizieren.

Je nach Framework kann die Implementierung etwas unterschiedlich aussehen. 

Die Quarkus Dokumentation [Configuring Your Application](https://quarkus.io/guides/config) beschreibt die 
Besonderheiten von Quarkus. 

## Aufgaben

### 1. Konfigurationsparameter aus einer Datei laden

Erstellen Sie Konfigurationen entsprechend der Quarkus Dokumentation, um die Antworten
unseres MessageService aus dem vorherigen Beispiel zu konfigurieren. Ihrer Kreativität 
sind dabei keine Grenzen gesetzt. 

Ziel dieser Übung ist es zu verstehen, wie sich die unterschiedlichen Konfigurationsquellen
verhalten und wie über das ordinal gesteuert werden kann, welche Quelle vorrang hat. 

Als Inspiration können sie im MessageService einen Switch Case aufbauen, um die verschiedenen Konfigurationsquellen zu testen. 

- Lesen Sie die Werte für heading und body als String aus der Konfiguration aus.
- Lesen Sie die direkt eine Message mittels einem Interface und @ConfigMapping aus.
- Lesen Sie Konfigurationswerte aus einer `.env` Datei aus.
- Legen Sie Profile für dev und test in der `application.properties` an und lesen Sie die Werte aus. Beachten Sie, dass Quarkus mittels dem Befehl `quarkus:dev` das dev Profil lädt. Zum testen des test Profils müssen Sie die Anwendung mit `quarkus:dev -D"quarkus.profile"=test` starten oder die Application vorher bauen und mit passendem Profil starten.
- Legen Sie ein Profile in einer `application-prod.properties` an und beobachten Sie die geänderten Rückgabewerte.
- Legen Sie eine Custom ConfigSource an und laden Sie die Werte aus dieser Quelle.