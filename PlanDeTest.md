Liste des exigences
===============
- TP. 1: L’utilisateur a comme choix d’entrer `—english` comme premier paramètre si celui-ci veut que le programme soit en anglais.
- TP. 2: L’utilisateur doit obligatoirement entrer en ligne de commande le chemin du fichier d’entrée et le chemin du fichier de sortie.
- TP. 3: Cette étape est la première dans le cas où l’utilisateur
  garde le programme français, celle-ci devient la deuxième en cas contraire.
- TP. 4: Un fichier de sortie sera alors créé. Pour afficher le contenu de celui-ci,
  l’utilisateur doit utiliser la commande `cat` suivit du chemin du fichier de sortie. 

| N. | Fonctionnalité | Résultat attendu                                     | Description | Données |
|----|-----------------|------------------------------------------------------|-------------|---------|
| 1  | Test de champ manquant | Message d'erreur approprié                           | Vérifier le message d'erreur pour un champ manquant. | Un fichier avec un champ manquant à une ligne spécifique. |
| 2  | Test du nombre de champs inattendus | Message d'erreur approprié                           | Vérifier le message d'erreur pour un nombre de colonnes incorrect. | Un fichier avec un nombre de colonnes en trop ou en moins. |
| 3  | Test de l'arrondissement invalide | Message d'erreur approprié                           | Vérifier le message d'erreur pour un arrondissement invalide. | Un fichier avec un arrondissement non reconnu. |
| 4  | Test de la description d'intervention invalide | Message d'erreur approprié                           | Vérifier le message d'erreur pour une description invalide. | Un fichier avec une description non valide. |
| 5  | Test du format d'heure invalide | Lance une exception `InformationInvalideDansLeFichier` | Vérifier le message d'erreur pour un format d'heure invalide. | Un fichier avec une heure d'intervention au format incorrect. |
| 6  | Test de la date invalide | Lance une exception `InformationInvalideDansLeFichier`                          | Vérifier le message d'erreur pour une date invalide. | Un fichier avec une date postérieure à la date actuelle. |
| 7  | Test d'écriture dans le fichier invalide | Message d'erreur approprié                           | Vérifier le message d'erreur pour une erreur d'écriture dans le fichier. | Tenter d'écrire dans un fichier avec un chemin incorrect. |
| 8  | Test de lecture de fichier invalide | Message d'erreur approprié                           | Vérifier le message d'erreur pour une erreur de lecture de fichier. | Tenter de lire un fichier inaccessible. |
| 9  | Test de lecture d'array JSON invalide | Message d'erreur approprié                           | Vérifier le message d'erreur pour une exception JSON. | Tenter de manipuler un JSON avec un nom d'array non valide. |
| 10 | Test du nombre de paramètres invalide | Message d'erreur approprié                           | Vérifier le message d'erreur pour un nombre incorrect de paramètres. | Lancer l'application sans spécifier les emplacements des fichiers d'entrée et de sortie. |
