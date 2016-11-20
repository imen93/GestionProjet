package tn.enis.model.projet;

import java.util.List;


public interface ProjetService {
	public void ajoutProjet(Projet projet);
	public void supprimerProduit(Projet projet);
	public void modifierProduit(Projet projet);
	public void chercherProduit(String nomProjet);
	public Projet findByID(Integer id);
    public List<Projet> findAll();
}
