package tn.enis.dao;

import java.math.BigDecimal;
import java.util.List;

import tn.enis.model.tache.Tache;

public interface TacheDAO extends GenericDao<Tache, BigDecimal> {
	public Tache findByDescription(String description);
	public List<Tache> findByProjet(int id); 

}
