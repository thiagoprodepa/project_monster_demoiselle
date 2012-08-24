package br.gov.prodepa.monster.project.business;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.prodepa.monster.project.business.SetorBC;
import br.gov.prodepa.monster.project.domain.Setor;
import br.gov.prodepa.monster.project.dto.search.CommonSearchsDto;

@RunWith(DemoiselleRunner.class)
public class SetorBCTest {

	@Inject
	SetorBC setorBC;
	
	@Test
	public void testLoad() {
		setorBC.load();
	}
	
	@Test
	public void testLoadID() {
		Setor setor = setorBC.load(71L);
		
		assertNotNull(setor);
	}

	@Test
	public void testInsert() {
		setorBC.insert(new Setor("TesteInsert"));
	}

	@Test
	public void testUpdate() {
		Setor setor = setorBC.load(71L);
		
		setor.setNome("UpdateTeste");
		
		setorBC.update(setor);
	}
	
	@Test
	public void testDelete() {
		setorBC.delete(71L);
	}

	@Test
	public void testFindAll() {
		List<Setor> setores = setorBC.findAll();
		
		System.out.println(setores);
	}

	@Test
	public void testFindByExample() {
		List<Setor> setores = setorBC.findByExamples(new CommonSearchsDto("G"));
		
		System.out.println(setores);
	}

}
