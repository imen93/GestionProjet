package tn.enis.model.resource;

import java.util.List;

import tn.enis.model.resource.Resource;

public interface ResourceService {
	public void ajoutResource(Resource resource);
	public void supprimerResource(Resource resource);
	public void modifierResource(Resource resource);
	public Resource chercherParId(Integer id);
    public List<Resource> getResourceList();
}
