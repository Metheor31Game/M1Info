import {
  ATTRIBUTS,
  UNIVERS,
  getCompetence,
  getClasse,
  getUnivers,
} from "./univers.js";

function initialiser(nomUniv = "Médiéval fantastique") {
  const CurrentUnivers = getUnivers(nomUniv);

  // Récupérer le <select> univers
  const selectUnivers = document.getElementById("univers");
  // Supprimer les éléments existants
  selectUnivers.innerHTML = "";

  // Créer les options pour chaque univers
  UNIVERS.forEach((u) => {
    const option = document.createElement("option");
    option.value = u.nom;
    option.textContent = u.nom;
    // Sélectionner l'univers par défaut
    if (u.nom === nomUniv) {
      option.selected = true;
    }
    selectUnivers.appendChild(option);
  });

  // Récupérer le champ classes
  const selectClasses = document.getElementById("classe");

  // Remplir avec les classes disponible pour l'univers courant
  selectClasses.innerHTML = "";
  CurrentUnivers.classes.forEach((c) => {
    const option = document.createElement("option");
    option.value = c;
    option.textContent = c;
    selectClasses.appendChild(option);
  });

  // Récupérer le <ul> des compétences
  const ulCompetences = document.getElementById("competences");
  ulCompetences.innerHTML = "";

  // Remplir avec les compétences de l'univers courant
  CurrentUnivers.competences.forEach((nomComp) => {
    const li = document.createElement("li");

    // Checkbox
    const checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.id = `comp-${nomComp}`;

    // Label
    const label = document.createElement("label");
    label.htmlFor = checkbox.id;
    label.textContent = nomComp + ":";

    // Champ valeur
    const inputVal = document.createElement("input");
    inputVal.id = `val-${nomComp}`;
    inputVal.value = 0;
    inputVal.className = "champ";
    inputVal.readOnly = true;

    li.appendChild(checkbox);
    li.appendChild(label);
    li.appendChild(inputVal);
    ulCompetences.appendChild(li);
  });

  // Récupérer le <ul> des attributs
  const ulAttributs = document.getElementById("attributs");
  ulAttributs.innerHTML = "";

  // Remplir avec les attributs (input type number)
  ATTRIBUTS.forEach((a) => {
    const li = document.createElement("li");

    // Label
    const label = document.createElement("label");
    label.htmlFor = `attr-${a}`;
    label.textContent = a + ":";

    // Champ valeur
    const inputVal = document.createElement("input");
    inputVal.type = "number";
    inputVal.id = `attr-${a}`;
    inputVal.value = 0;
    inputVal.className = "champ";

    li.appendChild(label);
    li.appendChild(inputVal);
    ulAttributs.appendChild(li);
  });
}

export { initialiser };
