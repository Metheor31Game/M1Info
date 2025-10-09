import { controleur } from "./controleur.js";
import { initialiser } from "./initialisation.js";
import { getClasse } from "./univers.js";

/**
 * Ajoute tous les écouteurs nécessaires sur les champs du formulaire.
 * Empêche la modification des compétences fixes et la saisie de plus de 9 points d'attributs.
 */
function ajouterEcouteurs() {
  // Champ nom
  const inputNom = document.getElementById("nom");
  if (inputNom) {
    inputNom.addEventListener("input", function (e) {
      controleur.changerNom(e.target.value);
    });
  }

  // Select univers
  const selectUnivers = document.getElementById("univers");
  if (selectUnivers) {
    selectUnivers.addEventListener("change", function (e) {
      initialiser(e.target.value); // Met à jour le formulaire selon l'univers
      controleur.changerUnivers(e.target.value); // Met à jour le modèle
    });
  }

  // Select classe
  const selectClasse = document.getElementById("classe");
  if (selectClasse) {
    selectClasse.addEventListener("change", function (e) {
      controleur.changerClasse(e.target.value);
    });
  }

  // attributs (ul)
  const ulAttributs = document.getElementById("attributs");
  if (ulAttributs) {
    ulAttributs.addEventListener("input", function (e) {
      if (e.target && e.target.matches("input[type='number']")) {
        const attr = e.target.id.replace("attr-", "");
        const val = parseInt(e.target.value, 10) || 0;
        const ok = controleur.changerAttribut(attr, val);
        if (ok === false) {
          // Affiche une alerte si la limite est dépassée
          alert("Vous ne pouvez pas dépasser 9 points d'attributs.");
        }
      }
    });
  }

  // compétences (ul)
  const ulCompetences = document.getElementById("competences");
  if (ulCompetences) {
    ulCompetences.addEventListener("change", function (e) {
      if (e.target && e.target.matches("input[type='checkbox']")) {
        const nomComp = e.target.id.replace("comp-", "");
        // Vérifie si la compétence est fixe
        let estFixe = false;
        if (getClasse) {
          const objetClasse = getClasse(controleur.personnage.classe);
          if (objetClasse.competences.fixes) {
            estFixe = objetClasse.competences.fixes.includes(nomComp);
          }
        }
        if (estFixe) {
          e.target.checked = true;
          return;
        }
        // Empêche de cocher si le nombre max est atteint
        if (e.target.checked) {
          const nbSelectionnees =
            controleur.personnage.getNbCompetencesSelectionnees();
          const nbMax = controleur.personnage.getNbCompetencesAChoisir();
          if (nbSelectionnees >= nbMax) {
            e.target.checked = false;
            return;
          }
          controleur.ajouterCompetence(nomComp);
        } else {
          controleur.retirerCompetence(nomComp);
        }
      }
    });
  }
}

export { ajouterEcouteurs };
