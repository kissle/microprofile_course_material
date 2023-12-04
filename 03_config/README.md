# MicroProfile Config

In der Übung zuvor haben, wir gesehen, wie wir mit Jakarte EE Core Profiel arbeiten können. 
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

Ziel diese Übung ist es zu verstehen, wie sich die unterschiedlichen Konfigurationsquellen
verhalten und wie über das ordinal gesteuert werden kann, welche Quelle vorrang hat. 

### 2. Konfiguration für Ports setzen

In den nachfolgenden Übungen werden wir mit mehreren Services arbeiten. Damit wir diese
Services parallel ausführen können, müssen wir die Ports konfigurieren. Machen Sie sich
mit den Konfigurationsmöglichkeiten von Quarkus vertraut und konfigurieren Sie den Port
dieses Services, sodass er im Default-Modus auf Port 8085 läuft.