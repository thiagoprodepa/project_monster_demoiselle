package br.gov.prodepa.bookmark.business;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;


import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.prodepa.bookmark.domain.Bookmark;
import br.gov.prodepa.bookmark.persistence.BookmarkDAO;

@Stateless
public class UsuarioServiceBC implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	@Startup
	public void load() {
		/*if (findAll().isEmpty()) {
			insert(new Bookmark("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Demoiselle SourceForge", "http://sf.net/projects/demoiselle"));
			insert(new Bookmark("Twitter", "http://twitter.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Blog", "http://blog.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Wiki", "http://wiki.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Bug Tracking", "http://tracker.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Forum", "http://forum.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("SVN", "http://svn.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Maven", "http://repository.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Downloads", "http://download.frameworkdemoiselle.gov.br"));
		}*/
	}
	
}
