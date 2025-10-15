package classes;

import java.util.List;
import inerface.FormationInterface;

public class Diplome implements FormationInterface {
	private String nom;
	private String contact;
	private List<FormationInterface> enfants;
	private FormationInterface parent = null;

	public Diplome(String nom, String contact, List<FormationInterface> enfants) {
		this.nom = nom;
		this.contact = contact;
		this.enfants = enfants;
		if (enfants != null) {
			for (FormationInterface enfant : enfants) {
				if (enfant instanceof classes.Semestre) {
					((classes.Semestre) enfant).setParent(this);
				}
			}
		}
	}

	public void setParent(FormationInterface parent) {
		this.parent = parent;
	}

	public void afficher(String prefix, inerface.Calculateur calculateur) {
		System.out.println(prefix + getNom() + " - Contact: " + (getContact() != null ? getContact() : "N/A") + ", nombre UEs: " + getNombreUE());
		System.out.println(prefix + "Charge: " + calculateur.calculPonderation(this));
		if (enfants != null) {
			for (FormationInterface enfant : enfants) {
				if (enfant != null) {
					if (enfant instanceof Diplome) {
						((Diplome) enfant).afficher(prefix + "  ", calculateur);
					} else if (enfant instanceof Semestre) {
						Semestre s = (Semestre) enfant;
						s.afficher(prefix + "  ", calculateur);
					} else {
						System.out.println(prefix + "  " + enfant.getNom());
					}
				}
			}
		}
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public String getContact() {
		if (contact != null && !contact.isEmpty()) {
			return contact;
		}
		if (parent != null) {
			return parent.getContact();
		}
		return null;
	}

	@Override
	public String getNombreUE() {
		java.util.Set<UE> uniqueUEs = new java.util.HashSet<>();
		if (enfants != null) {
			for (FormationInterface enfant : enfants) {
				Module m = enfant.getModule();
				if (m != null && m.UEs != null) {
					uniqueUEs.addAll(m.UEs);
				}
			}
		}
		return String.valueOf(uniqueUEs.size());
	}

	@Override
	public List<FormationInterface> getEnfants() {
		return enfants;
	}

	@Override
	public Module getModule() {
		return null;
	}
}
