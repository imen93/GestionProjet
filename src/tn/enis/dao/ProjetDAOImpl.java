package tn.enis.dao;

import java.math.BigDecimal;

import org.hibernate.Session;

import tn.enis.model.projet.Projet;

public class ProjetDAOImpl extends GenericDaoImpl<Projet, BigDecimal> implements ProjetDAO{
	public Projet findByNom(String nomProjet){
		Session hibernateSession = this.getSession();
	Projet projet = null;
	projet = (Projet) hibernateSession.get(Projet.class,nomProjet);
	return projet ;}
}





