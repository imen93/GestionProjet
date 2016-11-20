package tn.enis.dao;

import java.math.BigDecimal;

import tn.enis.model.projet.Projet;

public interface ProjetDAO extends GenericDao<Projet, BigDecimal> {
	public Projet findByNom(String nomProjet); 
}
