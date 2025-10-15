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
