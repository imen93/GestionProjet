package tn.enis.dao;

import java.math.BigDecimal;

import org.hibernate.Session;

import tn.enis.model.ressource.Ressource;

public class ResourceDaoImpl extends GenericDaoImpl<Ressource, BigDecimal>
		implements ResourceDao {

	@Override
	public Ressource findByPoste(String poste) {
		Session hibernateSession = this.getSession();
		Ressource ressource = null;
		ressource = (Ressource) hibernateSession.get(Ressource.class, poste);
		return ressource;
	}

}
