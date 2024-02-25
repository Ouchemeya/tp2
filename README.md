# tp2



# Démarche de l'Exercice 2 - Échange d'Objets Voiture avec des Sockets UDP

## Objectif
L'objectif de cet exercice est de créer un système client-serveur en Java permettant l'échange d'objets de la classe "Voiture" via des sockets UDP. Le client crée une instance de la classe "Voiture", fixe la quantité de carburant à l'aide de la méthode `setCarburant()`, puis envoie cet objet au serveur.

## Architecture
L'application se compose de deux parties : le serveur et le client.

### Partie Serveur
- Le serveur crée un socket UDP et attend les messages provenant des clients.
- Lorsqu'un message est reçu, le serveur désérialise l'objet "Voiture" à partir des données reçues et affiche les informations de la voiture, telles que la marque, le modèle et la quantité de carburant.

### Partie Client
- Le client crée un objet "Voiture", appelle la méthode `setCarburant()` pour fixer la quantité de carburant, puis sérialise l'objet en bytes.
- Les données sérialisées sont envoyées au serveur via le socket UDP.

## Classes Principales
### Voiture
- La classe "Voiture" est une classe simple représentant une voiture avec des attributs tels que la marque, le modèle et la quantité de carburant.
- Elle implémente l'interface `Serializable` pour permettre la sérialisation et la désérialisation.

### ServeurUDP
- La classe `ServeurUDP` représente le serveur UDP.
- Elle crée un socket UDP, écoute les messages des clients, désérialise les objets "Voiture" et affiche les informations.

### ClientUDP
- La classe `ClientUDP` représente le client UDP.
- Elle crée un objet "Voiture", appelle `setCarburant()`, sérialise l'objet et envoie les données au serveur.

## Exécution
1. Exécuter le serveur en premier.
2. Ensuite, exécuter le client.
3. Observer les informations affichées par le serveur pour vérifier la réception et la désérialisation correctes de l'objet "Voiture".

## Tests
- Testez l'application sur la même machine.
- Testez l'application sur deux machines reliées par un réseau.

## Remarques
- Assurez-vous que les ports utilisés ne sont pas bloqués par un pare-feu.
- La classe "Voiture" doit implémenter l'interface `Serializable` pour permettre la sérialisation et la désérialisation.










# Exercice 3 - Serveur UDP Date et Heure

## Objectif
L'objectif de cet exercice est de créer un serveur UDP en Java qui écoute sur le port 1250. Pour chaque datagramme reçu, peu importe leur contenu, le serveur renvoie un datagramme contenant la date et l'heure courante.

## Architecture
L'application se compose d'une seule partie : le serveur.

### Partie Serveur
- Le serveur crée un socket UDP et écoute les datagrammes sur le port 1250.
- À chaque datagramme reçu, le serveur extrait l'adresse IP et le port de l'émetteur.
- Le serveur génère la date et l'heure courante, les convertit en bytes, puis envoie un datagramme contenant cette information à l'émetteur.

## Classes Principales
### ServeurUDP
- La classe `ServeurUDP` représente le serveur UDP.
- Elle crée un socket UDP, écoute les datagrammes des émetteurs, extrait l'adresse IP et le port de l'émetteur, génère la date et l'heure courante, puis renvoie un datagramme contenant cette information.

## Exécution
1. Compilez et exécutez la classe `ServeurUDP`.
2. Utilisez un client UDP pour envoyer des datagrammes au port 1250 du serveur.

## Tests
- Utilisez des outils tels que netcat, socat ou un script Python pour envoyer des datagrammes au serveur.
- Vérifiez que le serveur répond avec la date et l'heure courante à chaque datagramme reçu.

## Remarques
- Assurez-vous que le port 1250 est disponible et non bloqué par un pare-feu.
- Vous pouvez personnaliser le format de la date et de l'heure selon vos besoins en modifiant la classe `SimpleDateFormat` dans le code.
