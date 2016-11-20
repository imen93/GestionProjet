package tn.enis.model.projet;

import java.util.List;

import tn.enis.dao.ProjetDAO;

public class ProjetServiceImpl implements ProjetService{
ProjetDAO projetdao;


public ProjetServiceImpl(ProjetDAO projetdao){
	this.projetdao=projetdao;
}
	@Override
	public void ajoutProjet(Projet projet) {
		projetdao.ajouter(projet);
		
	}

	@Override
	public void supprimerProduit(Projet projet) {
		projetdao.supprimer(projet);
		
	}

	@Override
	public void modifierProduit(Projet projet) {
		projetdao.modifier(projet);
		
	}

	@Override
	public void chercherProduit(String nomProjet) {
		projetdao.findByNom(nomProjet);
		
	}

	@Override
	public Projet findByID(Integer id) {
	
		Projet project=null;
		project=projetdao.findByID(Projet.class, id);
		return project;
	}

	@Override
	public List<Projet> findAll() {
		List<Projet> projects=null;
		projects=projetdao.findAll(Projet.class);
		return projects;
	}

}
