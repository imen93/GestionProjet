package tn.enis.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tn.enis.model.tache.Tache;

public class TacheDAOImpl extends GenericDaoImpl<Tache, BigDecimal> implements
		TacheDAO {

	@Override
	public Tache findByDescription(String description) {
		Session hibernateSession = this.getSession();
		Tache tache = null;
		tache = (Tache) hibernateSession.get(Tache.class, description);
		return tache;
	}

	@Override
	public List<Tache> findByProjet(int id) {
		Session hibernateSession = this.getSession();
		List<Tache> taches = null;
		String hql = "FROM Tache t WHERE t.projet.id_projet = :id_projet";
		Query query = hibernateSession.createQuery(hql);
		query.setParameter("id_projet",id);
		taches = query.list();
		return taches;
	}

}
