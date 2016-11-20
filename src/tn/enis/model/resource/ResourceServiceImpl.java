package tn.enis.model.resource;

import java.util.List;

import tn.enis.dao.ResourceDao;

public class ResourceServiceImpl implements ResourceService {

	ResourceDao resourceDao;

	
	public ResourceServiceImpl(ResourceDao resourceDao) {
		super();
		this.resourceDao = resourceDao;
	}

	@Override
	public void ajoutResource(Resource resource) {
		resourceDao.ajouter(resource);
	}

	@Override
	public void supprimerResource(Resource resource) {
		resourceDao.supprimer(resource);
	}

	@Override
	public void modifierResource(Resource resource) {
		resourceDao.modifier(resource);
	}

	@Override
	public List<Resource> getResourceList() {
		resourceDao.findAll(Resource.class);
		return null;
	}

	@Override
	public Resource chercherParId(Integer id) {
		resourceDao.findByID(Resource.class, id);
		return null;
	}

}
