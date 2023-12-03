# INF2050 - Sprint

## Introduction

Bienvenue dans le projet du cours INF2050 ! Ce projet vise à développer un logiciel qui effectuera des statistiques sur les interventions policières dans les parcs de la ville de Montréal. L'objectif principal de ce projet est de créer un moteur de règles d'affaires pour analyser les données d'interventions policières et générer des statistiques utiles.

## Objectif du Projet
L'objectif principal de ce projet est de créer un logiciel capable d'analyser des données sur les interventions policières dans les parcs de Montréal. Le logiciel prendra en entrée un fichier de données et générera un fichier de résultat contenant une liste des arrondissements de la ville, triés en ordre alphabétique, avec le nombre d'interventions policières enregistrées dans chaque arrondissement.
Ce logiciel ne comporte pas d'interface utilisateur propre, mais il est conçu pour être invoqué à partir d'une application web.
## Guide d'utilisation

    1. Veuillez cloner le projet à l'aide de la commande suivante:
        
        git clone https://gitlab.info.uqam.ca/clervil.eglantine_anne/Sprint-inf2050.git

    2. Ouvrez votre terminal et dirigez-vous dans le dossier où vous avez utilisé la commande 
        `git clone` à l'aide de la commande `cd`.

        - Sur macOS et Linux, utilisez :
            cd Chemin/Vers/Votre/Dossier
    
        - Sur Windows, utilisez :
            cd Chemin\Vers\Votre\Dossier
    
        Veillez à remplacer "Chemin/Vers/Votre/Dossier" par le chemin réel vers le dossier 
        où vous avez cloné le dépôt Git.


    3. Pour garantir un état de projet cohérent, avant de travailler sur ce projet Maven, 
        utilisez la commande suivante dans votre terminal :
            `mvn clean install`
    
    4. Vous allez ensuite pouvoir bien exécuter votre fichier jar suivant la commande suivante:

        java -jar target/inf2050-sprint-1.0-jar-with-dependencies.jar <chemin_fichier_entree> <chemin_fichier_sortie> 
        
        Remplacez <chemin_fichier_entree> par le chemin absolu ou relatif, sans espace, de votre fichier CSV d'entrée 
        et <chemin_fichier_sortie> par le chemin absolu ou relatif de votre fichier CSV de sortie.
        
        4.1. Il vous est aussi, d'autant plus de travaillez avec la version anglaise du logiciel, 
             Utiliserez alors la commande suivante : 

             java -jar target/inf2050-sprint-1.0-jar-with-dependencies.jar --english <chemin_fichier_entree> <chemin_fichier_sortie> 

    5. S'il n'y a aucun message d'erreur, le logiciel a bel et bien produit la statistique des interventions policieres par arrondissement.
    
    6. Afin d'afficher le résultat dans le fichier de sortie, vous devez utiliser la commande suivante:
        Sur macOS : cat <chemin_fichier_sortie>
        Sur Windows : type <chemin_fichier_sortie>
        
        
## Contribution

    @Auteur: Églantine Clervil,  Minh Ha,  Farah Bouaiche,  Suzanne Kamdem
    * @Courriel: clervil.eglantine_anne@courrier.uqam.ca, ha.le_minh@courrier.uqam.ca, bouaiche.farah@courrier.uqam.ca, 
        kamdem_pouomogne.suzanne_leocadie@courrier.uqam.ca
    * @Code-permanent: CLEE89530109, HAXL19089505, BOUF06379700, KAMS17628009
    * @Groupe: 30
    * Classes concernées : Arrondissement.java, Intervention Policiere.java, InterventionsPolicieresReader.java, 
                            InterventionsPolicieresStats.java, InterventionsPolicieresWriter.java, ListeArrondissementsInterventionsPolicieres.java,
                            ListeDescriptionInterventionPoliciere.java, ListeParcsParArrondissement.java, Main.java
    * Université Du Quebec à Montréal (UQAM)

    Veuillez cependant noter que le reste du travail est au nom de Églantine Clervil.

## Structure du fichier d'entrée

    Le fichier d'entrée doit être au format CSV et doit contenir la structure de données suivante:

    Date, Heure, Parc, Arrondissement, Description

    Date : La date de l'intervention policière, en format ISO 8601.
    Heure : L'heure de l'intervention policière.
    Parc : Le nom du parc où l'intervention a eu lieu.
    Arrondissement : Le nom de l'arrondissement contenant ce parc. 
    Description : Une description de l'évènement.

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

    Arrondissement,Nombre d'interventions,Nombre de parcs
    Ahuntsic-Cartierville,4,1
    Lachine,1,1
    Pierrefonds-Roxboro,1,1
    LaSalle,4,2
    
    Si votre programme est lancé avec le paramètre '--english' :
    
    Borough,Number of interventions,Number of parks
    Ahuntsic-Cartierville,4,1
    Lachine,1,1
    Pierrefonds-Roxboro,1,1
    LaSalle,4,2

## Données invalides
    En cas d'erreur dans les données fournies, le programme se terminera et générera des messages d'erreur 
    spécifiques pour vous aider à identifier celles-ci. Voici des exemples de messages d'erreur 
    correspondant à différentes situations :

    1- Erreur de nombre de champs inattendus

        Si le nombre de colonnes dans une ligne est incorrect, 
        le programme se terminera et signalera une erreur comme suit :

        Erreur lors de la lecture du fichier 'nom_du_fichier'. Assurez-vous que le fichier existe 
        et est accessible. Vérifiez les autorisations du fichier et réessayez.
        
        Si votre programme est lancé avec le paramètre '--english' :
        Error reading file 'nom_du_fichier'. Make sure the file exists and is accessible. Check the file permissions and try again.
        
        Où 'nom_du_fichier' désigne le nom du fichier d'entrée csv ayant lancer une exception.

    2- Erreur de nombre de champs inattendus

        Si le nombre de colonnes dans une ligne est incorrect, le programme signalera une erreur comme suit :
        
        Le nombre de colonnes est, soit en trop, soit en moins : vous devez avoir 'nombre_de_colonnes' 
        colonnes remplies à la ligne : 'numero_ligne'.
        
        Si votre programme est lancé avec le paramètre '--english' :
        
        The number of columns is either too many or too few: you must have 'nombre_de_colonnes' 
        columns filled on the line: 'numero_de_ligne'.
        
        Où 'nombre_de_colonnes' désigne le nombre de colonnes attendu dans 
        le fichier csv d'entrée et 'numero_de_ligne', la ligne où s'est déroulée cette erreur.
        
    3- Erreur d'arrondissement invalide 

        Si un arrondissement de Montréal n'est pas reconnu, 
        l'erreur sera indiquée de la manière suivante :
        
        
    4- Erreur de description d'intervention invalide
    
        Si la description d'une intervention policière n'est pas reconnue, 
        le message d'erreur sera formulé comme suit :
    
    
    5- Erreur de format d'heure invalide
    
        En cas d'un format d'heure incorrect, 
        le programme affichera l'erreur suivante :
    
    
    6- Erreur de date invalide
    
        Si la date d'intervention est postérieure à la date actuelle, 
        le message d'erreur sera comme suit :
    
    
    7- Erreur de format de date invalide
    
        En cas d'un format de date incorrect, 
        le programme affichera l'erreur suivante :
    
    
    8- Erreur d'écriture dans le fichier de sortie
    
        Si une erreur survient lors de la sauvegarde des statistiques dans 
        le fichier de sortie, le message sera formulé comme suit :
    
    
    9- Erreur de lecture du fichier
    
        En cas d'erreur lors de la lecture du fichier, le programme 
        affichera le message suivant :

    
    11- Erreur de nombre de paramètres invalides
    
        En cas d'omission des emplacements des fichiers d'entrée et de sortie
        lors de l'exécution du logiciel, le programme affichera le message suivant :
        
    
## Conclusion


En résumé, nous sommes convaincus que cette documentation vous a fourni toutes les informations nécessaires pour optimiser 
l'utilisation de notre logiciel de remboursement des réclamations d'assurance santé. Si vous rencontrez des difficultés 
ou si des questions persistent, n'hésitez pas à contacter notre service d'assistance, disponible pour vous offrir son soutien avec plaisir.
