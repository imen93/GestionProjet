package tn.enis.main;



import java.util.HashSet;
import java.util.Set;

import tn.enis.dao.ProjetDAO;
import tn.enis.dao.ProjetDAOImpl;
import tn.enis.dao.ResourceDao;
import tn.enis.dao.ResourceDaoImpl;
import tn.enis.dao.TacheDAO;
import tn.enis.dao.TacheDAOImpl;
import tn.enis.model.projet.Projet;
import tn.enis.model.projet.ProjetService;
import tn.enis.model.projet.ProjetServiceImpl;
import tn.enis.model.ressource.ResourceService;
import tn.enis.model.ressource.ResourceServiceImpl;
import tn.enis.model.ressource.Ressource;
import tn.enis.model.tache.Tache;
import tn.enis.model.tache.TacheService;
import tn.enis.model.tache.TacheServiceImpl;

public class Main {

	public static void main(String[] args) {
  
		//tester RessourceService
		
		ProjetDAO projetDao= new ProjetDAOImpl();
		ProjetService projetService=new ProjetServiceImpl(projetDao);
		Projet projet=new Projet("projet5");
		projetService.ajoutProjet(projet);
		/*Tache tache1=new Tache("tache3", "2jours");
		Tache tache2=new Tache("tache4", "3jours");
		TacheDAO tacheDao=new TacheDAOImpl();
		TacheService tacheService=new TacheServiceImpl(tacheDao);
		tacheService.ajoutTache(tache1);
		tacheService.ajoutTache(tache2);
		Set<Tache> taches = new HashSet<Tache>(0);
		taches.add(tache1);
		taches.add(tache2);*/
		

		/*ResourceDao resourceDao=new ResourceDaoImpl();
		ResourceService resourceService = new ResourceServiceImpl(resourceDao);
		Ressource resource1=new Ressource("ingenieurInfo",3.5,taches);
		Ressource resource3=new Ressource("techn",4.5,taches);
		resourceService.ajoutResource(resource1);
		resourceService.ajoutResource(resource3);*/
		/*resourceService.ajoutResource(resource2);
		resourceService.chercherParId(2);
		Ressource resource1Modifie=new Ressource(1,"ingenieur1Modifie",5.5);
		resourceService.modifierResource(resource1Modifie);
		resourceService.supprimerResource(resource2);*/
		
	}

}
