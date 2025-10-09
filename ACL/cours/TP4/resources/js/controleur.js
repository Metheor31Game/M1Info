import Personnage from "./personnage.js";
import { afficher } from "./affichage.js";

class Controleur {
  constructor() {
    // Chargement depuis localStorage si disponible
    const data = localStorage.getItem("personnage");
    if (data) {
      const obj = JSON.parse(data);
      this.personnage = new Personnage();
      // Remets les propriétés principales
      this.personnage.nom = obj.nom;
      this.personnage.setUnivers(obj.univers);
      this.personnage.setClasse(obj.classe);
      // Remets les attributs
      if (obj.attributs) {
        Object.entries(obj.attributs).forEach(([k, v]) => {
          this.personnage.attributs[k] = v;
        });
      }
      // Remets les compétences
      if (obj.competences) {
        Object.entries(obj.competences).forEach(([k, v]) => {
          this.personnage.competences[k] = v;
        });
      }
    } else {
      this.personnage = new Personnage();
    }
    afficher(this.personnage);
  }

  // Sauvegarde le modèle dans localStorage
  sauvegarder() {
    localStorage.setItem("personnage", JSON.stringify(this.personnage));
  }

  changerNom(nouveauNom) {
    this.personnage.nom = nouveauNom;
    this.sauvegarder();
    afficher(this.personnage);
  }

  changerUnivers(nomUnivers) {
    this.personnage.setUnivers(nomUnivers);
    this.sauvegarder();
    afficher(this.personnage);
  }

  changerClasse(nomClasse) {
    this.personnage.setClasse(nomClasse);
    this.sauvegarder();
    afficher(this.personnage);
  }

  changerAttribut(nomAttribut, valeur) {
    // On vérifie que la valeur est bien dans les bornes autorisées (0 à 4)
    if (valeur < 0) valeur = 0;
    if (valeur > 4) valeur = 4;

    // Calcul du total si on applique la nouvelle valeur
    const attributs = Object.assign({}, this.personnage.attributs);
    attributs[nomAttribut] = valeur;
    const total = Object.values(attributs).reduce((sum, v) => sum + v, 0);

    if (total > 9) {
      // On refuse la modification si le total dépasse 9
      afficher(this.personnage); // On réaffiche pour remettre la bonne valeur
      return false;
    } else {
      this.personnage.attributs[nomAttribut] = valeur;
      this.sauvegarder();
      afficher(this.personnage);
      return true;
    }
  }

  ajouterCompetence(nomCompetence) {
    this.personnage.ajouterCompetence(nomCompetence);
    this.sauvegarder();
    afficher(this.personnage);
  }

  retirerCompetence(nomCompetence) {
    this.personnage.retirerCompetence(nomCompetence);
    this.sauvegarder();
    afficher(this.personnage);
  }
}

const controleur = new Controleur();

export { controleur };
