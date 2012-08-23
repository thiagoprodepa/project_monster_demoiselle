package br.gov.prodepa.bookmark.view;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.prodepa.bookmark.business.UsuarioServiceBC;
import br.gov.prodepa.bookmark.domain.Usuario;

@ViewController
@PreviousView("/private/usuario/list.xhtml")
public class UsuarioEditMB extends AbstractEditPageBean<Usuario, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioServiceBC bc;

	@Override
	@Transactional
	public String delete() {
		this.bc.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.bc.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.bc.update(getBean());
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		
	    FacesContext context = FacesContext.getCurrentInstance();HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
	    HttpSession mySession = myRequest.getSession();        
	    System.out.println(myRequest.getParameter("id"));  
		
		
		setBean(this.bc.load(getId()));
	}
	
	

}
