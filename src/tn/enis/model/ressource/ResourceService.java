package tn.enis.model.ressource;

import java.util.List;

import tn.enis.model.ressource.Ressource;

public interface ResourceService {
	public void ajoutResource(Ressource resource);
	public void supprimerResource(Ressource resource);
	public void modifierResource(Ressource resource);
	public Ressource chercherParId(Integer id);
    public List<Ressource> getResourceList();
}
