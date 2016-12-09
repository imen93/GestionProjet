package tn.enis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tn.enis.dao.ProjetDAO;
import tn.enis.model.projet.Projet;
import tn.enis.model.projet.ProjetService;
import tn.enis.model.projet.ProjetServiceImpl;

public class ProjetServiceImplTest {
	@Mock
	ProjetDAO projetDao;
	ProjetService projetService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		projetService = new ProjetServiceImpl(projetDao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldUpdateProjet() {

		Projet projet = new Projet(1, "projetTest11");
		when(projetDao.findByID(Projet.class, 1)).thenReturn(projet);

		boolean updated = projetService
				.modifierProjet(new Projet(1, "location"));
		assertTrue(updated);
		verify(projetDao).findByID(Projet.class,1);
		ArgumentCaptor<Projet> projetCaptor = ArgumentCaptor
				.forClass(Projet.class);
		verify(projetDao).modifier(projetCaptor.capture());
		Projet updatedProjet = projetCaptor.getValue();
		assertEquals("location", updatedProjet.getNom_projet());
		System.out.println("done");
	}

	@Test
	public void shouldNotUpdateIfProjetNotFound() {
		when(projetDao.findByID(Projet.class, 1)).thenReturn(null);
		boolean updated = projetService.modifierProjet(new Projet(1, "location"));
		assertFalse(updated);
		verify(projetDao).findByID(Projet.class, 1);
		verifyZeroInteractions(projetDao);
		verifyNoMoreInteractions(projetDao);
	}

}
