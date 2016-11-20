package tn.enis.model.ressource;

import java.util.List;

import tn.enis.dao.ResourceDao;

public class ResourceServiceImpl implements ResourceService {

	ResourceDao resourceDao;

	
	public ResourceServiceImpl(ResourceDao resourceDao) {
		super();
		this.resourceDao = resourceDao;
	}

	@Override
	public void ajoutResource(Ressource resource) {
		resourceDao.ajouter(resource);
	}

	@Override
	public void supprimerResource(Ressource resource) {
		resourceDao.supprimer(resource);
	}

	@Override
	public void modifierResource(Ressource resource) {
		resourceDao.modifier(resource);
	}

	@Override
	public List<Ressource> getResourceList() {
		resourceDao.findAll(Ressource.class);
		return null;
	}

	@Override
	public Ressource chercherParId(Integer id) {
		resourceDao.findByID(Ressource.class, id);
		return null;
	}

}
