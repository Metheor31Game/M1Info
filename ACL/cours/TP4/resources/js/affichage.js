/**
 * Met à jour l'affichage du formulaire avec les données du personnage.
 *
 * @param {Personnage} personnage - Instance du modèle Personnage à afficher.
 * Remplit les champs nom, univers, classe, attributs et compétences.
 * Désactive les cases à cocher des compétences fixes.
 */
function afficher(personnage) {
  // Indicateur attributs
  const indicateurAttributs = document.getElementById("enteteAttributs");
  if (indicateurAttributs) {
    const N = personnage.getSommeAttributs();
    const K = 9;
    indicateurAttributs.textContent = `Attributs : ${N}/${K}`;
  }

  // Indicateur compétences
  const indicateurCompetences = document.getElementById("enteteCompetences");
  if (indicateurCompetences) {
    const N = personnage.getNbCompetencesSelectionnees();
    const K = personnage.getNbCompetencesAChoisir();
    indicateurCompetences.textContent = `Compétences : ${N}/${K}`;
  }
  // Champ nom
  const inputNom = document.getElementById("nom");
  if (inputNom) inputNom.value = personnage.nom ?? "";

  // Select univers
  const selectUnivers = document.getElementById("univers");
  if (selectUnivers) selectUnivers.value = personnage.univers;

  // Select classe
  const selectClasse = document.getElementById("classe");
  if (selectClasse) selectClasse.value = personnage.classe;

  // Attributs
  Object.entries(personnage.attributs).forEach(([attr, val]) => {
    const inputAttr = document.getElementById(`attr-${attr}`);
    if (inputAttr) inputAttr.value = val;
  });

  // Compétences
  Object.entries(personnage.competences).forEach(function ([
    nomCompetence,
    estSelectionnee,
  ]) {
    // Récupère la case à cocher et le champ de valeur pour la compétance
    const caseCompetence = document.getElementById("comp-" + nomCompetence);
    const champValeur = document.getElementById("val-" + nomCompetence);

    // Met à jour la case à cocher
    if (caseCompetence) {
      caseCompetence.checked = estSelectionnee;

      // Vérifie si la compétence est fixe (imposée par la classe)
      let estFixe = false;
      if (window.getClasse) {
        const objetClasse = window.getClasse(personnage.classe);
        if (
          objetClasse &&
          objetClasse.competences &&
          objetClasse.competences.fixes
        ) {
          estFixe = objetClasse.competences.fixes.includes(nomCompetence);
        }
      }
    }

    // Mettre à jour la valeur de la compétence
    if (champValeur) {
      if (typeof personnage.getBonus === "function") {
        champValeur.value = personnage.getBonus(nomCompetence);
      }
    }
  });
}

export { afficher };
