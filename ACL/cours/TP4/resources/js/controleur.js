import Personnage from "./personnage.js";

class Controleur {
  constructor() {
    this.personnage = new Personnage();
  }
}

const controleur = new Controleur();

export { controleur };
