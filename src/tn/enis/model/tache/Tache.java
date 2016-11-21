package tn.enis.model.tache;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tn.enis.model.projet.Projet;

@Entity
@Table(name = "tache")
public class Tache {
	@Id
	@GeneratedValue
	@Column(name = "id_tache")
	private int id_tache;
	@Column(name = "description", nullable = false, length = 40)
	private String description;
	@Column(name = "duree", nullable = false, length = 40)
	private String duree;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_projet")
	private Projet projet;
	public Tache(){}
	public Tache(int id_tache, String description, String duree, Projet projet) {
		super();
		this.id_tache = id_tache;
		this.description = description;
		this.duree = duree;
	   this.projet = projet;
	}

	// public Tache(String description, String duree, Projet projet,
	// Set<Ressource> ressources) {
	// super();
	// this.description = description;
	// this.duree = duree;
	// this.projet = projet;
	// this.ressources = ressources;
	// }

	public Tache(String description, String duree, Projet projet) {
		super();
		this.description = description;
		this.duree = duree;
		// this.projet = projet;
	}

	public int getId_tache() {
		return id_tache;
	}

	public void setId_tache(int id_tache) {
		this.id_tache = id_tache;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}
	 public Projet getProjet() {
	 return projet;
	 }
	 public void setProjet(Projet projet) {
	 this.projet = projet;
	 }
	

//	 public Set<Ressource> getRessources() {
//	 return ressources;
//	 }
//	
//	
//	
//	
//	 public void setRessources(Set<Ressource> ressources) {
//	 this.ressources = ressources;
//	 }

}
