package tn.enis.dao;

import java.math.BigDecimal;

import tn.enis.model.ressource.Ressource;

public interface ResourceDao extends GenericDao<Ressource, BigDecimal> {
	public Ressource findByPoste(String poste); 
}