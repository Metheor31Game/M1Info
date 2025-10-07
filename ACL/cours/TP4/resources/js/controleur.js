import Personnage from "./personnage.js";
import { afficher } from "./affichage.js";

class Controleur {
  constructor() {
    this.personnage = new Personnage();
    afficher(this.personnage);
  }

  changerNom(nouveauNom) {
    this.personnage.nom = nouveauNom;
    afficher(this.personnage);
  }

  changerUnivers(nomUnivers) {
    this.personnage.setUnivers(nomUnivers);
    afficher(this.personnage);
  }

  changerClasse(nomClasse) {
    this.personnage.setClasse(nomClasse);
    afficher(this.personnage);
  }

  changerAttribut(nomAttribut, valeur) {
    // On vérifie que la valeur est bien dans les bornes autorisées (0 à 4)
    if (valeur < 0) valeur = 0;
    if (valeur > 4) valeur = 4;

    // Calcul du total si on applique la nouvelle valeur
    const attributs = { ...this.personnage.attributs };
    attributs[nomAttribut] = valeur;
    const total = Object.values(attributs).reduce((sum, v) => sum + v, 0);

    if (total > 9) {
      // On refuse la modification si le total dépasse 9
      afficher(this.personnage); // On réaffiche pour remettre la bonne valeur
      return false;
    } else {
      this.personnage.attributs[nomAttribut] = valeur;
      afficher(this.personnage);
      return true;
    }
  }

  ajouterCompetence(nomCompetence) {
    this.personnage.ajouterCompetence(nomCompetence);
    afficher(this.personnage);
  }

  retirerCompetence(nomCompetence) {
    this.personnage.retirerCompetence(nomCompetence);
    afficher(this.personnage);
  }
}

const controleur = new Controleur();

export { controleur };
