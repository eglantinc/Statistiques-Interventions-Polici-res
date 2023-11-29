# INF2050 - Sprint

## Introduction

Bienvenue dans le projet du cours INF2050 ! Ce projet vise à développer un logiciel qui effectuera des statistiques sur les interventions policières dans les parcs de la ville de Montréal. L'objectif principal de ce projet est de créer un moteur de règles d'affaires pour analyser les données d'interventions policières et générer des statistiques utiles.

## Objectif du Projet
L'objectif principal de ce projet est de créer un logiciel capable d'analyser des données sur les interventions policières dans les parcs de Montréal. Le logiciel prendra en entrée un fichier de données et générera un fichier de résultat contenant une liste des arrondissements de la ville, triés en ordre alphabétique, avec le nombre d'interventions policières enregistrées dans chaque arrondissement.
Ce logiciel ne comporte pas d'interface utilisateur propre, mais il est conçu pour être invoqué à partir d'une application web.
## Guide d'utilisation

    1. Veuillez cloner le projet à l'aide de la commande suivante:
        
        git clone https://gitlab.info.uqam.ca/ha.le_minh/inf2050-sprint.git

    2. Ouvrez votre terminal et dirigez vous dans le dossier où que vous avez utilisé la commmande git clone à l'aide de la commande cd.    
    
        Par exemple:

        cd Desktop/INF2050/inf2050-sprint/Java/

    3. Vous allez compiler le classe main avec la commande suivante:

        javac Main.java

    4. Vous allez par la suite exécuter la classe Main et ajouter un fichier d'entrée comme test ainsi qu'un fichier de sortie pour 
        le résultat.

        java Main.java ../Test/test1.csv FichierOutput.csv

    5. S'il y a aucun message d'erreur, cela veut dire que tout s'est bien passé. 
        Vous allez ensuite afficher le résultat dans le fichier de sortie à l'aide de la commande suivante:

        cat FichierOutput.csv
        
## Contribution

    @Auteur: Eglantine Clervil,  Minh Ha,  Farah Bouaiche,  Suzanne Kamdem
    * @Courriel: clervil.eglantine_anne@courrier.uqam.ca, ha.le_minh@courrier.uqam.ca, bouaiche.farah@courrier.uqam.ca, 
        kamdem_pouomogne.suzanne_leocadie@courrier.uqam.ca
    * @Code-permanent: CLEE89530109, HAXL19089505, BOUF06379700, KAMS17628009
    * @Groupe: 30
    * Université Du Quebec à Montréal (UQAM)

## Structure du fichier d'entrée

    Le fichier d'entrée doit être au format CSV et doit contenir la structure de données suivante:

        Date, Heure, Parc, Arrondissement, Description

    Date: La date de l'intervention policière, en format ISO 8601.
    Heure: L'heure de l'intervention policière.
    Le nom du parc où l'intervention a eu lieu.
    Le nom de l'arrondissement contenant ce parc. 
    Une description de l'énevement.


    Voici un exemple de fichier d'entrée:

    Date,Heure,Parc,Arrondissement,Description
    2023-04-15,0:00,Parc du Mont-Royal,Outremont,Vente de drogues
    2023-09-28,3:45,Parc Angrignon,Le Sud-Ouest,Bagarre
    2023-08-07,7:30,Parc La Fontaine,Le Plateau-Mont-Royal,Manifestation illégale
    2023-06-12,11:15,Parc Angrignon,Le Sud-Ouest,Vol de véhicule à moteur
    2023-09-24,14:20,Parc Angrignon,Le Sud-Ouest,Port d'arme prohibée
    2023-02-19,18:05,Parc des Rapides,LaSalle,Possession / consommation de stupéfiant
    2023-01-20,21:50,Parc des Rapides,LaSalle,Possession / consommation de stupéfiant
    2023-04-12,2:25,Parc La Fontaine,Le Plateau-Mont-Royal,Méfait

    Voici un exemple de fichier de sortie:

    Arrondissement, Nombre d'interventions, Nombre de parcs
    Outremont, 1, 1
    Le Sud-Ouest, 3, 1
    Le Plateau-Mont-Royal, 2, 1
    LaSalle, 2, 1

## Données invalides

    Si vous rentrez un nom de fichier qui n'existe pas, le message d'erreur suivant va sortir:

        Fichier introuvable. Assurez-vous que le chemin du fichier existe.

        Erreur lors de la lecture du fichier. Assurez-vous de vérifier sa validité.

    Si vous rentrez un fichier qui manque une donnée, le message d'erreur suivant va sortir:

        Information manquante dans au moins une ligne du fichier, dont celle-ci:
    
## Conclusion

En résumé, nous croyons fermement que cette documentation vous a fourni toutes les informations requises pour tirer profit de   notre logiciel de remboursement des réclamations d'assurance santé. Si vous faites face à des problèmes ou si des questions vous préoccupent, ne tardez pas à prendre contact avec notre service d'assistance, qui est là pour vous apporter son soutien avec plaisir.
