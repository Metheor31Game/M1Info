/* Liste des attributs. */
const ATTRIBUTS = [
  "Force",
  "Dextérité",
  "Constitution",
  "Intelligence",
  "Sagesse",
  "Charisme",
];

/* Liste des compétences. Un univers peut n'en utiliser qu'une partie. */
const COMPETENCES = [
  { nom: "Acrobaties", attribut: "Dextérité" },
  { nom: "Arcanes", attribut: "Intelligence" },
  { nom: "Artisanat", attribut: "Intelligence" },
  { nom: "Athlétisme", attribut: "Force" },
  { nom: "Connaissance", attribut: "Intelligence" },
  { nom: "Diplomatie", attribut: "Charisme" },
  { nom: "Discrétion", attribut: "Dextérité" },
  { nom: "Duperie", attribut: "Charisme" },
  { nom: "Informatique", attribut: "Intelligence" },
  { nom: "Intimidation", attribut: "Charisme" },
  { nom: "Larcin", attribut: "Dextérité" },
  { nom: "Médecine", attribut: "Sagesse" },
  { nom: "Nature", attribut: "Sagesse" },
  { nom: "Occultisme", attribut: "Intelligence" },
  { nom: "Pilotage", attribut: "Dextérité" },
  { nom: "Religion", attribut: "Sagesse" },
  { nom: "Représentation", attribut: "Charisme" },
  { nom: "Société", attribut: "Intelligence" },
  { nom: "Survie", attribut: "Sagesse" },
];

/* Liste des classes. Un univers peut n'en utiliser qu'une partie. */
const CLASSES = [
  {
    nom: "Barde",
    attribut: "Charisme",
    competences: { libres: 4, fixes: ["Occultisme", "Représentation"] },
  },
  {
    nom: "Druide",
    attribut: "Sagesse",
    competences: { libres: 3, fixes: ["Nature"] },
  },
  {
    nom: "Guerrier",
    attribut: "Force",
    competences: { libres: 2, fixes: ["Acrobaties", "Athlétisme"] },
  },
  {
    nom: "Magicien",
    attribut: "Intelligence",
    competences: { libres: 2, fixes: ["Arcanes"] },
  },
  {
    nom: "Prêtre",
    attribut: "Sagesse",
    competences: { libres: 3, fixes: ["Religion"] },
  },
  {
    nom: "Rôdeur",
    attribut: "Dextérité",
    competences: { libres: 4, fixes: ["Nature", "Survie"] },
  },
  {
    nom: "Roublard",
    attribut: "Dextérité",
    competences: { libres: 8, fixes: ["Discrétion"] },
  },
  {
    nom: "Sorcier",
    attribut: "Intelligence",
    competences: { libres: 4, fixes: [] },
  },
  {
    nom: "Agent",
    attribut: "Dextérité",
    competences: { libres: 4, fixes: [] },
  },
  {
    nom: "Distordeur",
    attribut: "Intelligence",
    competences: { libres: 4, fixes: [] },
  },
  {
    nom: "Émissaire",
    attribut: "Charisme",
    competences: {
      libres: 7,
      fixes: ["Diplomatie", "Duperie", "Intimidation"],
    },
  },
  {
    nom: "Mystique",
    attribut: "Sagesse",
    competences: { libres: 4, fixes: [] },
  },
  {
    nom: "Solarien",
    attribut: "Force",
    competences: { libres: 4, fixes: ["Athlétisme"] },
  },
  {
    nom: "Soldat",
    attribut: "Constitution",
    competences: { libres: 3, fixes: ["Intimidation"] },
  },
];

const MED_FAN = {
  nom: "Médiéval fantastique",
  competences: [
    "Acrobaties",
    "Arcanes",
    "Artisanat",
    "Athlétisme",
    "Connaissance",
    "Diplomatie",
    "Discrétion",
    "Duperie",
    "Intimidation",
    "Larcin",
    "Médecine",
    "Nature",
    "Occultisme",
    "Religion",
    "Représentation",
    "Société",
    "Survie",
  ],
  classes: [
    "Barde",
    "Druide",
    "Guerrier",
    "Magicien",
    "Prêtre",
    "Rôdeur",
    "Roublard",
    "Sorcier",
  ],
};

const SCI_FI = {
  nom: "Science-fiction",
  competences: [
    "Acrobaties",
    "Arcanes",
    "Artisanat",
    "Athlétisme",
    "Connaissance",
    "Diplomatie",
    "Discrétion",
    "Duperie",
    "Informatique",
    "Intimidation",
    "Larcin",
    "Médecine",
    "Nature",
    "Occultisme",
    "Pilotage",
    "Religion",
    "Représentation",
    "Société",
    "Survie",
  ],
  classes: [
    "Agent",
    "Distordeur",
    "Émissaire",
    "Mystique",
    "Solarien",
    "Soldat",
  ],
};

const UNIVERS = [MED_FAN, SCI_FI];

/* Paramètres pour la création de personnage. */
const PARAMS = {
  attributsLibres: 9,
  attributMin: 0,
  attributMax: 4,
};

/* Trouve le premier objet dans array dont la propriété nom correspond au paramètre nom. */
function trouverParNom(array, nom) {
  return array.find((data) => data.nom === nom);
}

/* Renvoie l'objet univers à partir de son nom. */
function getUnivers(nomUnivers) {
  return trouverParNom(UNIVERS, nomUnivers);
}

/* Renvoie l'objet competence à partir de son nom. */
function getCompetence(nomCompetence) {
  return trouverParNom(COMPETENCES, nomCompetence);
}

/* Renvoie l'objet classe à partir de son nom. */
function getClasse(nomClasse) {
  return trouverParNom(CLASSES, nomClasse);
}

export { ATTRIBUTS, UNIVERS, PARAMS, getUnivers, getClasse, getCompetence };
