package br.gov.prodepa.bookmark.business;

import java.util.List;

import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.prodepa.bookmark.domain.Setor;
import br.gov.prodepa.bookmark.dto.search.CommonSearchsDto;

@BusinessController
public class SetorBC extends JPACrud<Setor, Long> {
	
	private static final long serialVersionUID = 1L;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Setor("Presidencia"));
			insert(new Setor("GTI"));
			insert(new Setor("GES"));
			insert(new Setor("GGC"));
			insert(new Setor("GQ"));
			insert(new Setor("RAY"));
		}
	}
	
	public List<Setor> findByExamples(CommonSearchsDto example) {
		
		//TODO PROBLEM Esse metodo findByExample devera receber um param diferente do declarado na classe para suportar esse caso.
		
		if(example == null) {
			return findByExample(new Setor());
		} else {
			return findByExample(new Setor(example.getPattern()));
		}
	}
	
}
