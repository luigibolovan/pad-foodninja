

## Enunt

Build from scratch a distributed application on Java EE or another platform of choice.
The application consists of several distributed, interconnected software components, that work together for a common goal. There are a minimum of two types of components that must be implemented:

- **Servers**, that maintain the global status of the application and provides its main functionality. Servers may serve a different geographical area, and/or follow a specific purpose within the application. Servers communicate with each other in order to update the status, maintain consistency, syncronize data, and so on.
- **Clients**. They provide the users with a lightweight and possibly mobile interface, and communicate with the servers. There can be several types of clients: standard standalone applications featuring a platform-specific UI, Web applications, mobile, etc.

Clients and servers may communicate through technologies and techniques of choice, such as: HTTP, REST, RMI, etc.

## Tools
 - **Visual Studio** -- [APIs](Api's)
 - **Android Studio** -- [app](android)
 - **Visual Studio Code** -- [aplicatie web](WebClients)
 
 
## Descriere
Sistemul nostru are ca scop oferirea unei solutii pentru a putea calcula valorile nutritionale ale unor alimente.

Backend-ul este format din doua api-uri, fiecare api avand baza de date. Api-urile si bazele de date sunt deployed pe platforma Microsoft Azure, acestea avand posibilitatea de a fi accesate de oriunde.
    
Clientii sunt reprezentati de o aplicatie web si o aplicatie mobile pentru Android.

## Team
- _Bercea Bogdan_
- _Bolovan Luigi Ionut_
- _Borozan Ionut Pavel_
- _Bosca Alexandru_
