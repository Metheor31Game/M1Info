import { controleur } from "./controleur.js";
import { initialiser } from "./initialisation.js";

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
        if (e.target.checked) {
          controleur.ajouterCompetence(nomComp);
        } else {
          controleur.retirerCompetence(nomComp);
        }
      }
    });
  }
}

export { ajouterEcouteurs };
