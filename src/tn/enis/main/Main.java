package tn.enis.main;

import tn.enis.dao.ResourceDao;
import tn.enis.dao.ResourceDaoImpl;
import tn.enis.model.resource.Resource;
import tn.enis.model.resource.ResourceService;
import tn.enis.model.resource.ResourceServiceImpl;

public class Main {

	public static void main(String[] args) {
  
		//tester RessourceService
		/*ResourceDao resourceDao=new ResourceDaoImpl();
		ResourceService resourceService = new ResourceServiceImpl(resourceDao);
		Resource resource1=new Resource(1,"ingenieur1",2.5);
		Resource resource2=new Resource(2,"ingenieur2",2.5);
		resourceService.ajoutResource(resource1);
		resourceService.ajoutResource(resource2);
		resourceService.chercherParId(2);
		Resource resource1Modifie=new Resource(1,"ingenieur1Modifie",5.5);
		resourceService.modifierResource(resource1Modifie);
		resourceService.supprimerResource(resource2);*/
	}

}
