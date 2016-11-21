package tn.enis.dao;

import java.math.BigDecimal;

import org.hibernate.Query;
import org.hibernate.Session;

import tn.enis.model.projet.Projet;

public class ProjetDAOImpl extends GenericDaoImpl<Projet, BigDecimal> implements ProjetDAO{
	public Projet findByNom(String nomProjet){
		Session hibernateSession = this.getSession();
	String hql = "FROM Projet t WHERE t.nomProjet = :nomProjet";
	Query query = hibernateSession.createQuery(hql);
	query.setParameter("description",nomProjet);
	Projet projet = (Projet) query.list().get(0);
	return projet;
}}





