# MicroProfile JWT

MicroProfile JWT ist eine Spezifikation, die es ermöglicht, JSON Web Tokens (JWT) in MicroProfile-Anwendungen zu nutzen.
JWTs sind eine Möglichkeit, Informationen zwischen zwei Parteien sicher als JSON-Objekt auszutauschen.
Sie können signiert werden, um die Authentizität der Informationen zu gewährleisten, und verschlüsselt werden, um die 
Vertraulichkeit der Informationen zu gewährleisten.

In dieser Übung erstellen wir einen Auth Service, der JWTs ausstellt. 

## Aufgabenstellung

### Auth Service erstellen & RoleBasedAccess

Implementieren Sie Ihre Authentifizierungsmechanismen entsprechend der Quarkus Dokumentationen für den 
Employee Service [Using JWT RBAC](https://quarkus.io/guides/security-jwt).

*Hinweis: Schauen Sie sie sich die Lösung auch gerne beim Quarkus im Unterprojekt `security-jwt-quickstart` ab. 
[Quakrus-Quickstarts](https://github.com/quarkusio/quarkus-quickstarts)

## Bonus: 

Quarkus Quickstart bietet auch ein Beispiel für die Authentifizierung mittels Keycloak an:
[Using Keycloak Authorization Services and Policy Enforcer to Protect JAX-RS Applications](https://github.com/quarkusio/quarkus-quickstarts/tree/main/security-keycloak-authorization-quickstart)