package tn.enis.dao;

import java.math.BigDecimal;

import org.hibernate.Session;

import tn.enis.model.tache.Tache;

public class TacheDAOImpl extends GenericDaoImpl<Tache, BigDecimal> implements TacheDAO{

	@Override
	public Tache findByDescription(String description) {
		Session hibernateSession = this.getSession();
		Tache tache = null;
		tache = (Tache) hibernateSession.get(Tache.class,description);
		return tache ;
	}

}
