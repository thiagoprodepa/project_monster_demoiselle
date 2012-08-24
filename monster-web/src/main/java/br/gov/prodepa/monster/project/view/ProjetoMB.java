package br.gov.prodepa.monster.project.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.prodepa.monster.project.business.ProjetoServiceBC;
import br.gov.prodepa.monster.project.domain.Projeto;
import br.gov.prodepa.monster.project.dto.search.CommonSearchsDto;

@Named
@RequestScoped
//@ViewController
public class ProjetoMB implements Serializable { 

	private static final long serialVersionUID = 1L;

	
	private static final String LIST = "/private/projeto/list.xhtml";
	private static final String EDIT = "/private/projeto/edit.xhtml";
	
	private Projeto projeto;
	
	private List<Projeto> projetos;
	
	private CommonSearchsDto searchsDto = new CommonSearchsDto();
	
	int ct = 0;
	
	@Inject
	private ProjetoServiceBC bc;

	public String insert() {
		this.bc.insert(this.projeto);
		return getListView();
	}
	
	public String update() {
		this.bc.update(this.projeto);
		return getListView();
	}
	
	public void search() {
		projetos = bc.findByExample(this.searchsDto);
	}

	public String delete() {
		this.bc.delete(getId());
		return getListView();
	}

	public String getListView() {
		return LIST;
	}
	
	public void select() {
		this.projeto = this.bc.load(getId());
	}
	
	public String getEditView() {
		select();
		return EDIT;
	}

	public String showFormView() {
		this.projeto = new Projeto();
		return EDIT;
	}
	
	private Long getId() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession mySession = myRequest.getSession();        
		System.out.println(myRequest.getParameter("id"));
		
		if(myRequest.getParameter("id") != null) {
			return new Long(myRequest.getParameter("id"));
		} else {
			return null;
		}
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public CommonSearchsDto getSearchsDto() {
		return searchsDto;
	}

	public void setSearchsDto(CommonSearchsDto searchsDto) {
		this.searchsDto = searchsDto;
	}

	public Projeto getProjeto() {
		ct++;
		System.out.println(getId() + " > " + ct);
		
		if(this.projeto == null) {
		if(getId() != null) {
			this.projeto = this.bc.load(getId());
		} else {
			this.projeto = new Projeto();
		}
		}
		
		/*if(this.projeto == null) {
			if(getId() != null) {
				this.projeto = this.bc.load(getId());
			} else {
				return null;
			}
		}*/
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}
