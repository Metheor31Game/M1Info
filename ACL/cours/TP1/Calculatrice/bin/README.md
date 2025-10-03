Lancement :
Compilé en java 21, mais normalement compatible en java 17.
se placer dans le dossier src


Ajouts :
Nouvelle fenêtre hexadécimale, exterieure à la fenêtre décimale.
fenêtres hexadécimales et décimales fonctionnelles.
la vue hexadécimale est séparée de la vue décimale.

Modifications :
ajout d une library "HexaConverter" permettant de passer du decimal à l hexadécimal, et inversement.
ajout de la compatibilité entre le controleur et la vue hexadécimale.
légère modification du modèle, dans ajouterInt, différent si c est un nombre Hexa ou décimal.


Idée d amélioration :
classe abstraite "calculatrice", afin que ClasicViewDigit et HexaView hérite de méthodes et paramètres communs.
possibilité d ajouter une vue avec n importe quelle because
ajouts des nombres négatifs.