package br.gov.prodepa.bookmark.business;

import java.util.List;

import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.prodepa.bookmark.domain.Setor;

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
	
	public List<Setor> findByExamples(Setor example) {
		return findByExample(example);
	}
	
}
