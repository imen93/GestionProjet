package tn.enis.model.projet;

import java.util.List;


public interface ProjetService {
	public void ajoutProjet(Projet projet);
	public void supprimerProjet(Projet projet);
	public boolean modifierProjet(Projet projet);
	public void chercherProjet(String nomProjet);
	public Projet findByID(Integer id);
    public List<Projet> findAll();
}
