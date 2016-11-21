package tn.enis.model.projet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projet")
public class Projet {
	@Id
	@GeneratedValue
	@Column(name = "id_projet", unique = true, nullable = false)
	private int id_projet;
	@Column(name = "nom_projet", nullable = false, length = 40)
	private String nom_projet;

	public Projet() {
	}

	public int getId_projet() {
		return id_projet;
	}

	public Projet(String nom_projet) {
		super();
		this.nom_projet = nom_projet;
	}

	public Projet(int id_projet, String nom_projet) {
		this.id_projet = id_projet;
		this.nom_projet = nom_projet;
	}

	public void setId_projet(int id_projet) {
		this.id_projet = id_projet;
	}

	public String getNom_projet() {
		return nom_projet;
	}

	public void setNom_projet(String nom_projet) {
		this.nom_projet = nom_projet;
	}

}
