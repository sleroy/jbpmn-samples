# Projet de développment JBPM

Cette page documente un projet

## Étapes de conception

Dans ce projet, nous allons produire une application complète permettant de gérer la demande d'emprunt bancaire.

### 1. Analyse et Définition du Processus

- _Étude du Processus Métier_ : Comprendre les différentes étapes d'une demande de prêt, depuis la soumission de la demande jusqu'à la décision finale.

- _Identification des Acteurs_ : Lister les parties prenantes impliquées, telles que le demandeur, l'agent de crédit, le service de vérification, et le comité d'approbation.

### 2. Modélisation BPMN du Processus

- **Diagramme de Processus** : Utiliser un outil de modélisation BPMN pour créer le diagramme représentant le flux des activités.

- **Événements de Début et de Fin** : Définir le point de départ (soumission de la demande) et le point d'achèvement (décision finale).

- **Activités** : Inclure des tâches telles que la collecte des informations, la vérification des documents, l'évaluation du risque, et l'approbation finale.

- **Passerelles** : Utiliser des passerelles pour représenter les décisions conditionnelles, par exemple, si le score de crédit est suffisant ou si des documents supplémentaires sont requis.

- **Swimlanes** : Organiser le diagramme en couloirs pour attribuer les tâches aux différents acteurs ou départements.

### 3. Intégration de Fonctions Avancées

- _Sous-Processus_ : Modéliser des sous-processus pour des étapes complexes, comme l'évaluation du risque, qui peut inclure plusieurs tâches détaillées.

- _Événements de Message et de Signal_ : Incorporer des événements pour gérer les communications entre le processus et des systèmes externes, tels que l'envoi d'une notification au notaire ou la réception d'une confirmation.

- _Tables de Décision (DMN)_ : Utiliser des tables de décision pour automatiser l'évaluation du risque de crédit en fonction de critères prédéfinis.

### 4. Validation et Simulation

- _Vérification du Modèle_ : S'assurer que le diagramme BPMN est conforme aux standards et qu'il reflète fidèlement le processus métier.

- _Simulation_ : Utiliser des outils de simulation pour tester le processus, identifier les goulots d'étranglement, et optimiser le flux des activités.

### 5. Documentation et Présentation

- **Documentation Complète** : Rédiger une documentation détaillée du processus, incluant les descriptions des tâches, les rôles des acteurs, et les règles de décision.

- **Présentation** : Préparer une présentation pour expliquer le modèle, les choix effectués, et les améliorations potentielles identifiées lors de la simulation.

## Etapes techniques

Le projet doit commencer initialement comme un Projet BPMN classique avec modélisation avec Eclipse ou Business Central depuis l'interface Web.

Nous construisons alors un simple webservice qui recoit les demandes d'emprunt et les soumet au serveur JBPM. Le processus est géré au sein de l'interface Web de JBPM.

Ensuite le projet est extrait comme un projet Maven et nous revoyons comment le déployer automatiquement sur notre serveur KIE dédié.

Enfin, nous utilisons un serveur JBPM dédié dans notre application Spring Boot pour gérer le flux de la demande. Nous créons une API Rest pour simuler les actions humaines.

Nous pouvons également ajouter des API REST pour simuler l'envoi d'évènements (signaux).

Nous pouvons également utiliser des tâches personnalisées pour gérer des notifications.

Nous pouvons également déclarer une connection à une base de donnée dans JBPM afin de persister la demande de prêt et la mettre à jour régulièrement.

### Concepts couverts

- **Utilisation des API REST de jBPM** : jBPM offre une API REST complète permettant de gérer les processus et les tâches à distance. Cette API facilite l'intégration avec des applications externes en utilisant des appels HTTP standard. Les opérations courantes incluent le démarrage de processus, la récupération de l'état des processus, et la gestion des tâches utilisateur.
  jBPM Documentation

- **Gestion des Signaux** : Les signaux dans jBPM sont utilisés pour communiquer des événements asynchrones aux processus en cours d'exécution. Ils permettent de notifier un processus d'un événement externe ou interne, déclenchant ainsi des transitions spécifiques au sein du processus.
  Gautric

* **Handlers de Tâches Personnalisées** : jBPM permet la création de WorkItemHandlers personnalisés pour étendre les fonctionnalités du moteur de processus. Cela inclut l'intégration avec des services externes, tels que des appels REST, en définissant des tâches spécifiques au domaine.

* **Utilisation de JPA** : Nous souhaitons déclarer une unité de persistence dans JBPM pour avoir accès à une base de données qui contient les informations de prêt.

* **Utilisation de CDI**: Nous souhaitons utiliser CDI pour définir les différents composants dans notre projet.

* **Utilisation de Transactions** : Nous souhaitons utiliser le système de transactions pour gérer nos demandes de prêts immobiliers.

* **Utilisation de l'audit** via jbpm-audit

## Conception du projet

Le projet est décomposé en quatre parties :

- Le projet qui contient les ressourcs du processus BPMN ( business process, data objects)
- Un projet **Spring Boot** qui va nous permettre d'interagir avec l'application Frontend
- Un projet **Spring Boot** qui va nous servir de Frontend très simple
- Une base de donnée Mysql que nous démarrons via une commande docker
