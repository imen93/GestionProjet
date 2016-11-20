package tn.enis.model.ressource;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import tn.enis.model.tache.Tache;

@Entity
@Table(name = "ressource")
public class Ressource {
	
	@Id
	@GeneratedValue
	@Column(name = "id_ressource", nullable = false, unique=true)
	private int id_ressource;
	@Column(name = "poste", nullable = false)
	private String poste;
	@Column(name = "salaire", nullable = false)
	private Double salaire;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ressource_tache", joinColumns = { @JoinColumn(name = "id_ressource") }, inverseJoinColumns = { @JoinColumn(name = "id_tache") })
	private Set<Tache> taches = new HashSet<Tache>(0);


	public Ressource( String poste, Double salaire,
			Set<Tache> taches) {
		super();
		this.poste = poste;
		this.salaire = salaire;
		this.taches = taches;
	}


	public Set<Tache> getTaches() {
		return taches;
	}


	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}


	public Ressource() {
	};

	
	public Ressource(int id_ressource, String poste, Double salaire) {
		super();
		this.id_ressource = id_ressource;
		this.poste = poste;
		this.salaire = salaire;
	}

	public Ressource(String poste, Double salaire) {
		super();
		
		this.poste = poste;
		this.salaire = salaire;
	}
	public void setId_ressource(int id_ressource) {
		this.id_ressource = id_ressource;
	}
	public int getId_ressource() {
		return id_ressource;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
}
