package tn.enis.model.resource;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resource")
public class Resource {
	
	@Id
	@GeneratedValue
	@Column(name = "id_ressource", nullable = false, unique=true)
	private int id_ressource;
	@Column(name = "poste", nullable = false)
	private String poste;
	@Column(name = "salaire", nullable = false)
	private Double salaire;


	public Resource() {
	};

	public Resource(int id_ressource, String poste, Double salaire) {
		super();
		this.id_ressource = id_ressource;
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
