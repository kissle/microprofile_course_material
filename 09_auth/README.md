# MicroProfile JWT

MicroProfile JWT ist eine Spezifikation, die es ermöglicht, JSON Web Tokens (JWT) in MicroProfile-Anwendungen zu nutzen.
JWTs sind eine Möglichkeit, Informationen zwischen zwei Parteien sicher als JSON-Objekt auszutauschen.
Sie können signiert werden, um die Authentizität der Informationen zu gewährleisten, und verschlüsselt werden, um die 
Vertraulichkeit der Informationen zu gewährleisten.

In dieser Übung erstellen wir einen Auth Service, der JWTs ausstellt. 

## Aufgabenstellung

### 1. Auth Service erstellen

Implementieren Sie relevante Funktionalitäten Ihres Auth Services entsprechend der Quarkus Dokumentationen 
[Build, Sign and Encrypt JSON Web Tokens](https://quarkus.io/guides/security-jwt-build).

### 2. RoleBasedAccess

Implementieren Sie Ihre Authentifizierungsmechanismen entsprechend der Quarkus Dokumentationen 
[Using JWT RBAC](https://quarkus.io/guides/security-jwt).

