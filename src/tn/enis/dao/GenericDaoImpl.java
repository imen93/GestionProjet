package tn.enis.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tn.enis.util.HibernateUtil;

public class GenericDaoImpl<T, ID extends Serializable> implements
		GenericDao<T, ID> {

	protected Session getSession() {
		return HibernateUtil.getSession().openSession();
	}

	@Override
	public void ajouter(T entity) {
		Session hibernateSession = this.getSession();
		Transaction transaction = hibernateSession.beginTransaction();
		hibernateSession.save(entity);
		transaction.commit();
		hibernateSession.close();
	}

	@Override
	public void supprimer(T entity) {
		Session hibernateSession = this.getSession();
		Transaction transaction = hibernateSession.beginTransaction();
		hibernateSession.delete(entity);
		transaction.commit();
		hibernateSession.close();
	}

	@Override
	public void modifier(T entity) {
		Session hibernateSession = this.getSession();
		Transaction transaction = hibernateSession.beginTransaction();
		hibernateSession.update(entity);
		transaction.commit();
		hibernateSession.close();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public T findByID(Class clazz, Integer id) {
		Session hibernateSession = this.getSession();
		T t = null;
		t = (T) hibernateSession.get(clazz, id);
		return t;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> findAll(Class clazz) {
		Session hibernateSession = this.getSession();
		List<T> T = null;
		Query query = hibernateSession.createQuery("from " + clazz.getName());
		T = (List<T>) query.list();
		return T;
	}

}