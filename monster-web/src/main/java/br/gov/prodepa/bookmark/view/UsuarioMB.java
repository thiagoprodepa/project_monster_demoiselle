package br.gov.prodepa.bookmark.view;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.prodepa.bookmark.business.BookmarkBC;
import br.gov.prodepa.bookmark.business.SetorBC;
import br.gov.prodepa.bookmark.domain.Bookmark;
import br.gov.prodepa.bookmark.domain.Setor;
import br.gov.prodepa.bookmark.domain.Usuario;

@ViewController
@PreviousView("/private/usuario/list.xhtml")
public class UsuarioMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;


	@Inject
	private Usuario usuario;
	
	@Inject
	private SetorBC setorBc;
	
	
	
	

	/*@Transactional
	public String insert(Usuario usuario) {
		this.setorBc.insert(usuario);
		return getPreviousView();
	}
	
	@Transactional
	public String update() {
		this.setorBc.update(getBean());
		return getPreviousView();
	}

	@Transactional
	public String delete() {
		this.setorBc.delete(getId());
		return getPreviousView();
	}


	protected void handleLoad() {
		setBean(this.setorBc.load(getId()));
	}*/

}
