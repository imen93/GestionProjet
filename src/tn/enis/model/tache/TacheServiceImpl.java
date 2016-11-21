package tn.enis.model.tache;

import java.util.List;

import tn.enis.dao.TacheDAO;

public class TacheServiceImpl implements TacheService {
	TacheDAO tachedao;

	public TacheServiceImpl(TacheDAO tachedao) {
		this.tachedao = tachedao;
	}

	@Override
	public void ajoutTache(Tache tache) {
		tachedao.ajouter(tache);

	}

	@Override
	public void supprimerTache(Tache tache) {
		tachedao.supprimer(tache);

	}

	@Override
	public void modifierTache(Tache tache) {
		tachedao.modifier(tache);

	}

	@Override
	public void chercherTache(String description) {
		tachedao.findByDescription(description);

	}

	@Override
	public Tache findByID(Integer id) {
		Tache tache = null;
		tache = tachedao.findByID(Tache.class, id);
		return tache;
	}

	@Override
	public List<Tache> findAll() {
		List<Tache> taches = null;
		taches = tachedao.findAll(Tache.class);
		return taches;
	}

	@Override
	public List<Tache> findByProjet(Integer id) {
		List<Tache> taches = null;
		taches = tachedao.findByProjet(id);
		return taches;
	}

}
