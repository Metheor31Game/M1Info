package classes;

import java.util.List;
import inerface.FormationInterface;

public class Semestre implements FormationInterface {
	private String nom;
	private String contact;
	private Module module;
	private FormationInterface parent = null;

	public Semestre(String nom, String contact, Module module) {
		this.nom = nom;
		this.contact = contact;
		this.module = module;
	}

	public void setParent(FormationInterface parent) {
		this.parent = parent;
	}

	public void afficher(String prefix, inerface.Calculateur calculateur) {
		System.out.println(prefix + "Semester " + getNom() + " (Contact: " + (getContact() != null ? getContact() : "N/A") + ")");
		if (getModule() != null && getModule().UEs != null) {
			System.out.print(prefix + "  Modules: [");
			boolean first = true;
			for (classes.UE ue : getModule().UEs) {
				if (!first) System.out.print(", ");
				System.out.print(ue.nom);
				first = false;
			}
			System.out.println("]");
		}
		System.out.println(prefix + "  Charge: " + calculateur.calculPonderation(this));
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
		if (module != null && module.UEs != null) {
			return String.valueOf(module.UEs.size());
		}
		return "0";
	}

	@Override
	public List<FormationInterface> getEnfants() {
		return null;
	}

	@Override
	public Module getModule() {
		return module;
	}
}
