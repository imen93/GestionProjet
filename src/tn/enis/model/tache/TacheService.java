package tn.enis.model.tache;

import java.util.List;

public interface TacheService {
	public void ajoutTache(Tache tache);
	public void supprimerTache(Tache tache);
	public boolean modifierTache(Tache tache);
	public void chercherTache(String description);
	public Tache findByID(Integer id);
    public List<Tache> findAll();
    public List<Tache> findByProjet(Integer id);

}
