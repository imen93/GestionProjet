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
	public void supprimerProjet(Projet projet) {
		projetdao.supprimer(projet);
		
	}

	@Override
	public boolean modifierProjet(Projet projet) {
		if (projetdao.findByID(Projet.class, projet.getId_projet())!=null)
		{
			projetdao.modifier(projet);
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public void chercherProjet(String nomProjet) {
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
