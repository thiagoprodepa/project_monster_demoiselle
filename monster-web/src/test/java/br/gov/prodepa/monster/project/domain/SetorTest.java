package br.gov.prodepa.monster.project.domain;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.prodepa.monster.project.domain.Setor;

@RunWith(DemoiselleRunner.class)
public class SetorTest {

	@Inject
	EntityManager em;
	
	@Before
	public void startTest() {
		em.getTransaction().begin();
	}
	
	@After
	public void stopTest() {
		
		if(em.getTransaction().isActive())
			em.getTransaction().commit();
	}
	
	@Test
	public void testCreate() {

		Setor s = new Setor("Tests");
		em.persist(s);

		assertNotNull(s.getId());
	}
	
	//TODO esse teste deveria lancar uma excessao referente a duplicacao do nome do setor
	@Test//(expected = org.hibernate.exception.ConstraintViolationException.class)
	public void testCreateDuplicated() {
		
		em.persist(new Setor("Tests"));
		em.persist(new Setor("Tests"));
		//em.getTransaction().commit();
		
		fail("Esse teste deveria lancar uma excessao referente a duplicacao do nome do setor");
	}
	
	@Test
	public void testfindAll() {

		List<Setor> setores = em.createQuery("SELECT s FROM Setor s").getResultList();
		
		System.out.println(setores);
		
		assertTrue(setores.size() > 0);
	}
	
//	fail("Not yet implemented");
}
