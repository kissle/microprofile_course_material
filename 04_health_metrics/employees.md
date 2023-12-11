# Employees
Mitarbeiter (Employees) sind die zentralen Ressourcen unserer Applikation.
Es soll möglich sein eine Liste von Mitarbeitern zu verwalten.

## Entity Mitarbeiter

Ein Mitarbeiter hat dabei die Attribute

- firstName
- lastName
- skills (Eine Liste von Skills, die jedoch im Skill Service verwaltet werden)

## REST API

Der Employees Service soll ermöglichen mittels REST API

- Neue Mitarbeiter anzulegen
- Einen Mitarbeiter zu entfernen
- Den Namen eines Mitarbeiters zu erfragen
- Die Skills eines Mitarbeiters zu erfragen
- Eine Liste aller Mitarbeiter auszugeben
- Eine Liste aller Mitarbeiter mit einem Skill auszugeben
- Eine Liste aller Projekte eines Mitarbeiters auszugeben
- Einem Mitarbeiter einen Skill beizubringen/verbessern
- Eine Liste aktuell verfügbarer Mitarbeiter ausgeben