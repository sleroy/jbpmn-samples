# Programme de la formation jBPM

## Introduction _OK_

- BPM et orchestration de services : définitions et cas d'utilisation
- Les différents rôles : fonctionnel métier et intégrateur de solution
- Particularités des projets implémentant des processus métier et facteurs de réussite
- Présentation des standards

## Modélisation de processus _OK_

- Programmation orientée processus, graphes orientés et états en attente _OK_
- Représentation graphique des processus : nœuds, transitions et jetons _OK_
- Modèle d'exécution du graphe, variables de processus
- Persistance, transactions et services

## Introduction à jBPM _OK_

- Objectifs du projet _OK_
- Le langage jPDL, comparaison avec BPEL _OK_
- Le moteur de workflow et la gestion de processus _OK_
- Le modeleur graphique _OK_
- La web console _OK_
- Les différentes configurations disponibles _OK_

## Travaux Pratiques

- Installation de jBPM et mise en place de l'environnement Eclipse _OK_

# Premiers pas

## Modélisation avec jBPM Designer et syntaxe XML _OK_

- Responsabilité des nœuds _OK_
- Principaux types de nœuds (tâche, état, décision, fork, join) _OK_
- Les transitions _OK_
- Actions et événements _OK_
- Processus et sous-processus, transfert d'informations _OK_
- Démonstration avec jBPM Designer, commentaires du fichier XML _OK_
- Générer une application web pour le prototypage _OK_

## Problématiques de déploiement

- Librairie jBPM et dépendances _OK_
- Fichiers de configurations (nœuds, actions, calendrier, variables, etc.)
- Base de données jBPM et relation avec Hibernate, configuration du service de persistance _OK_
- Déploiement pour un .war ou .ear _OK_

## Travaux Pratiques

- Prise en main du designer, modélisation d'un processus de validation et exécution du processus dans une application web _OK_

# Programmation client

## Exécution d'un processus

- Instanciation d'un processus et notion de token
- Rôle des états d'attente et la méthode signal()
- Décomposition de l'exécution d'une transition
- Mode asynchrone et démarcation des transactions
- Stockage d'un jeton dans la base de données jBPM
- Le contexte de persistance jbpmContext
- Méthodes de création et de mise à jour d'un jeton
- Le service DbPersistenceService et DbPersistenceServiceFactory
- jbpmContext avec d'autres services de persistance (EJB, Hibernate ou DataSource JDBC)

## L'utilisation des variables de processus _OK_

- Types supportés
- Cycle de vie, persistance et périmètre d'application
- Personnalisation de la persistance avec les convertisseurs

## Utiliser des actions personnalisées

- Configuration et interface ActionHandler
- Les événements et leur propagation
- Scripts

## Gestion des processus

- Déployer des processus programmatiquement
- Versionning et changement à chaud

## Travaux Pratiques

- Exécution d'un processus avec conditions via une application web

## Gestion de tâches

- Introduction
- Définition de tâche et instance
- Affectation de tâche, les todo list
- Cycle de vie d'une tâche
- Fin de tâche et continuation du processus
- Affectation de tâche : acteurs, groupe d'acteurs et couloirs d'activité
- L'interface AssignementHandler
- Variables de tâche et contrôleurs
- Actions associées

## Annuaire

- L'annuaire par défaut de jBPM
- Calcul des affectations
- Utiliser un annuaire existant

## Travaux Pratiques

- Mise en place d'un annuaire et d'une application de gestion de tâches

## Problématiques connexes

- Gestion documentaire
  - Le standard Java Content Repository (JCR) et l'implémentation JackRabbit
  - Variables de processus _OK_
- Timers
  - Principe et déploiement
  - Cas d'utilisation (temporisateur, processus d'escalade, etc.)
  - Calendrier métier
- Notifications via email
  - Implémentation via des actions
  - Modélisation d'une notification
  - Notification lors de l'affectation de tâche
  - Reminders
  - Templating et mise en place
- Gestion des traces
  - Création des traces d'exécution du processus
  - Configuration, mise en place d'entrepôt de données (data warehousing)
  - Analyse des logs et Monitoring (BAM)

## Travaux Pratiques

- Reprise du TP précédent avec ajout de notifications et créations de traces

## Travaux Pratiques

- Utilisation du serveur JBoss et de l'IDE Eclipse

## Liens Utiles

https://github.com/kiegroup/droolsjbpm-integration/blob/main/kie-server-parent/kie-server-maven-plugin/README.md
https://docs.jboss.org/drools/release/6.2.0.CR3/drools-docs/html/KIEChapter.html#KIEModuleIntroductionBuildingIntroductionSection
https://docs.redhat.com/en/documentation/red_hat_process_automation_manager/7.12/html/deploying_and_managing_red_hat_process_automation_manager_services/kie-server-java-api-con_kie-apis#kie-server-java-api-requests-proc_kie-apis
https://porcelli.me/rhba/business-central/git/2018/11/05/business-central-git.html
