<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Authentification Spring Boot avec JWT</title>
</head>

<body>

    <h1>Projet d'Authentification Spring Boot avec JWT</h1>

    <h2>Description du Projet</h2>

    <p>Ce projet est une application Spring Boot développée pour un prototype d'authentification sécurisée utilisant Spring Security et JSON Web Tokens (JWT). L'authentification basée sur JWT offre une solution robuste et évolutive pour sécuriser les applications web.</p>

    <h2>Fonctionnalités Principales</h2>

    <ul>
        <li><strong>Spring Security:</strong> Intégration de Spring Security pour la gestion de l'authentification et de l'autorisation.</li>
        <li><strong>JSON Web Tokens (JWT):</strong> Utilisation de JWT comme mécanisme d'échange sécurisé pour les informations d'authentification.</li>
        <li><strong>Docker:</strong> Configuration d'un Dockerfile pour faciliter le déploiement de l'application dans un conteneur Docker.</li>
        <li><strong>Docker Compose:</strong> Fourniture d'un fichier Docker Compose pour orchestrer et déployer plusieurs conteneurs liés (par exemple, une base de données) en un seul ensemble.</li>
    </ul>



    <h2>Prérequis</h2>

    <p><a href="https://www.docker.com/">Docker</a> installé sur votre machine.</p>

    <h2>Instructions d'Utilisation</h2>

    <ol>
        <li>Clonez le repository sur votre machine locale.</li>
        <li>Assurez-vous que Docker est installé et en cours d'exécution.</li>
        <li>À la racine du projet, exécutez la commande suivante pour construire l'image Docker:</li>
    </ol>

    <code>docker build -t auth-spring-boot-jwt .</code>

    <ol start="4">
        <li>Utilisez Docker Compose pour lancer l'application et les éventuelles dépendances (par exemple, une base de données):</li>
    </ol>

    <code>docker-compose up</code>

    <p>L'application sera accessible à l'adresse <a href="http://localhost:8081">http://localhost:8081</a>.</p>

    <h2>Contributions et Retours</h2>

    <p>Les contributions sous forme de pull requests sont les bienvenues. Pour toute question ou problème, veuillez ouvrir une issue dans le repository.</p>

</body>

</html>
