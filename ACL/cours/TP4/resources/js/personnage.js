import {
  UNIVERS,
  ATTRIBUTS,
  getUnivers,
  getClasse,
  getCompetence,
} from "./univers.js";

class Personnage {
  constructor() {
    this.nom = null;
    this.attributs = {};
    ATTRIBUTS.forEach((attribut) => (this.attributs[attribut] = 0));
    this.setUnivers();
  }

  setUnivers(value) {
    const universObj = getUnivers(value) ?? UNIVERS[0];
    this.univers = universObj.nom;
    this.competences = {};
    universObj.competences.forEach(
      (competence) => (this.competences[competence] = false)
    );
    this.setClasse();
  }

  setClasse(value) {
    const universObj = getUnivers(this.univers);
    const classeObj = getClasse(value) ?? getClasse(universObj.classes[0]);
    this.classe = classeObj.nom;
    for (let competence in this.competences) {
      this.competences[competence] =
        classeObj.competences.fixes.includes(competence);
    }
  }

  getSommeAttributs() {
    return Object.values(this.attributs).reduce((sum, val) => sum + val, 0);
  }

  ajouterCompetence(competence) {
    if (competence in this.competences) {
      this.competences[competence] = true;
    }
  }

  retirerCompetence(competence) {
    if (competence in this.competences) {
      this.competences[competence] = false;
    }
  }

  getBonus(competence) {
    const { attribut } = getCompetence(competence);
    const bonusQualification = this.competences[competence] ? 3 : 0;
    return this.attributs[attribut] + bonusQualification;
  }

  getNbCompetencesSelectionnees() {
    return Object.values(this.competences).filter((value) => value).length;
  }

  getNbCompetencesAChoisir() {
    const classeObj = getClasse(this.classe);
    return classeObj.competences.libres + classeObj.competences.fixes.length; // y compris les compétences fixes
  }
}

export default Personnage;
