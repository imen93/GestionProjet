package tn.enis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import tn.enis.dao.TacheDAO;
import tn.enis.model.projet.Projet;
import tn.enis.model.tache.Tache;
import tn.enis.model.tache.TacheService;
import tn.enis.model.tache.TacheServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class TacheServiceImplTest {
	@Mock
	TacheDAO tacheDao;
	TacheService tacheService;
	@Before
	public void setUp() throws Exception {
		tacheService = new TacheServiceImpl(tacheDao);
	}

	@After
	public void tearDown() throws Exception {
		tacheService = null;
		tacheDao=null;
	}

	@Test
	public void TestshouldUpdateTache() {
		Projet projet = new Projet(1, "projet1");
		Tache tache = new Tache(1, "tacheTest1", "1 heure", projet);
		when(tacheDao.findByID(Tache.class, 1)).thenReturn(tache);

		boolean updated = tacheService.modifierTache(new Tache(1,
				"tacheModifié", "2 heures", projet));
		assertTrue(updated);
		verify(tacheDao).findByID(Tache.class, 1);
		ArgumentCaptor<Tache> tacheCaptor = ArgumentCaptor
				.forClass(Tache.class);
		verify(tacheDao).modifier(tacheCaptor.capture());
		Tache updatedTache = tacheCaptor.getValue();
		assertEquals("tacheModifié", updatedTache.getDescription());
		assertEquals("2 heures", updatedTache.getDuree());
		System.out.println("done");
		verifyNoMoreInteractions(tacheDao);
	}

	@Test
	public void shouldNotUpdateIfTacheNotFound() {
		when(tacheDao.findByID(Tache.class, 1)).thenReturn(null);
		boolean updated = tacheService.modifierTache(new Tache(1, "tacheTest1",
				"1 heure", new Projet(1, "projet1")));
		assertFalse(updated);
		verify(tacheDao).findByID(Tache.class, 1);
		verifyZeroInteractions(tacheDao);
		verifyNoMoreInteractions(tacheDao);
	}
	@Test
	public void testFindById() {
		Projet projet = new Projet(1, "projet1");
		Tache tache = new Tache(1, "tacheTest1", "1 heure", projet);
		when(tacheDao.findByID(Tache.class, 1)).thenReturn(tache);
		Tache actualTache = tacheService.findByID(1);
		Assert.assertEquals("tacheTest1", actualTache.getDescription());
		Assert.assertEquals("1 heure", actualTache.getDuree());
		verify(tacheDao).findByID(Tache.class, 1);
	}
}
