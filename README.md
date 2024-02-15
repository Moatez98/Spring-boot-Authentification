Projet d'Authentification Spring Boot avec JWT
Description du Projet

Ce projet est une application Spring Boot développée pour un prototype d'authentification sécurisée utilisant Spring Security et JSON Web Tokens (JWT). L'authentification basée sur JWT offre une solution robuste et évolutive pour sécuriser les applications web.
Fonctionnalités Principales

    Spring Security: Intégration de Spring Security pour la gestion de l'authentification et de l'autorisation.
    JSON Web Tokens (JWT): Utilisation de JWT comme mécanisme d'échange sécurisé pour les informations d'authentification.
    Docker: Configuration d'un Dockerfile pour faciliter le déploiement de l'application dans un conteneur Docker.
    Docker Compose: Fourniture d'un fichier Docker Compose pour orchestrer et déployer plusieurs conteneurs liés (par exemple, une base de données) en un seul ensemble.


Prérequis

    Docker installé sur votre machine.

Instructions d'Utilisation

    Clonez le repository sur votre machine locale.

    Assurez-vous que Docker est installé et en cours d'exécution.

    À la racine du projet, exécutez la commande suivante pour construire l'image Docker:

    bash

docker build -t auth-spring-boot-jwt .

Utilisez Docker Compose pour lancer l'application et les éventuelles dépendances (par exemple, une base de données):

bash

    docker-compose up

    L'application sera accessible à l'adresse http://localhost:8081.

Contributions et Retours

Les contributions sous forme de pull requests sont les bienvenues. Pour toute question ou problème, veuillez ouvrir une issue dans le repository.
