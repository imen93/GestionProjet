package tn.enis.dao;

import java.math.BigDecimal;

import tn.enis.model.tache.Tache;

public interface TacheDAO extends GenericDao<Tache, BigDecimal> {
	public Tache findByDescription(String description); 
}
