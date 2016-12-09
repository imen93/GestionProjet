package tn.enis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import tn.enis.dao.ProjetDAO;
import tn.enis.model.projet.Projet;
import tn.enis.model.projet.ProjetService;
import tn.enis.model.projet.ProjetServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProjetServiceImplTest {
	@Mock
	ProjetDAO projetDao;
	@Mock
	List<Projet> listProjet;
	ProjetService projetService;
	Projet projet1;
	Projet projet2;

	@Before
	public void setUp() throws Exception {
		projetService = new ProjetServiceImpl(projetDao);
		projet1 = new Projet(1, "projet1");
		projet2 = new Projet(2, "projet2");
		listProjet.add(projet1);
		listProjet.add(projet2);
		when(projetDao.findAll(Projet.class)).thenReturn(
				Arrays.asList(projet1, projet2));

	}

	@After
	public void tearDown() throws Exception {
		projetService = null;
		projetDao = null;
	}

	@Test
	public void testshouldUpdateProjet() {

		Projet projet = new Projet(1, "projetTest11");
		when(projetDao.findByID(Projet.class, 1)).thenReturn(projet);

		boolean updated = projetService
				.modifierProjet(new Projet(1, "location"));
		assertTrue(updated);
		verify(projetDao).findByID(Projet.class, 1);
		ArgumentCaptor<Projet> projetCaptor = ArgumentCaptor
				.forClass(Projet.class);
		verify(projetDao).modifier(projetCaptor.capture());
		Projet updatedProjet = projetCaptor.getValue();
		assertEquals("location", updatedProjet.getNom_projet());
		System.out.println("done");
		verifyNoMoreInteractions(projetDao);

	}

	@Test
	public void testhouldNotUpdateIfProjetNotFound() {
		when(projetDao.findByID(Projet.class, 1)).thenReturn(null);
		boolean updated = projetService
				.modifierProjet(new Projet(1, "location"));
		assertFalse(updated);
		verify(projetDao).findByID(Projet.class, 1);
		verifyZeroInteractions(projetDao);
		verifyNoMoreInteractions(projetDao);
	}

	@Test
	public void testFindById() {
		Projet projet = new Projet(1, "projetTest11");
		when(projetDao.findByID(Projet.class, 1)).thenReturn(projet);
		Projet actualProject = projetService.findByID(1);
		Assert.assertEquals("projetTest11", actualProject.getNom_projet());
		verify(projetDao).findByID(Projet.class, 1);
	}

	@Test
	public void testFindAll() {
		List<Projet> projets = projetDao.findAll(Projet.class);
		assertEquals(2, projets.size());
		Projet projet = projets.get(0);
		assertEquals("projet1", projet.getNom_projet());
	}

}
