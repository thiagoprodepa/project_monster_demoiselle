package br.gov.prodepa.monster.project.persistence;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.prodepa.monster.project.domain.Projeto;

@PersistenceController
public class ProjetoDAO extends JPACrud<Projeto, Long> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;
	
}
