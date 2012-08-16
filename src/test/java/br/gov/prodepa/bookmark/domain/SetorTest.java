package br.gov.prodepa.bookmark.domain;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class SetorTest {

	@Inject
	EntityManager em;
	
	@Test
	public void testCreate() {

		Setor s = new Setor("Tests");
		em.persist(s);
		
		List setores = em.createQuery("SELECT s FROM Setor s").getResultList();
		
		assertNotNull(s.getId());
	}
	
	@Test
	public void testCreateDuplicated() {
		em.persist(new Setor("Tests"));
		em.persist(new Setor("Tests"));
	}
//	fail("Not yet implemented");
}
