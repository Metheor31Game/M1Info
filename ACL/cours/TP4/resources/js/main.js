import { initialiser } from "./initialisation.js";
import { ajouterEcouteurs } from "./ecouteurs.js";
import Personnage from "./personnage.js";
import { afficher } from "./affichage.js";

initialiser();
ajouterEcouteurs();

// // Création d'une instance de test et affichage
// const personnageTest = new Personnage();
// personnageTest.nom = "Testeur";
// personnageTest.setUnivers("Médiéval fantastique");
// personnageTest.setClasse("Guerrier");
// personnageTest.attributs["Force"] = 4;
// personnageTest.attributs["Dextérité"] = 2;
// personnageTest.attributs["Constitution"] = 2;
// personnageTest.attributs["Intelligence"] = 1;
// personnageTest.attributs["Sagesse"] = 0;
// personnageTest.attributs["Charisme"] = 0;

// window.addEventListener("DOMContentLoaded", () => {
//   afficher(personnageTest);
// });
