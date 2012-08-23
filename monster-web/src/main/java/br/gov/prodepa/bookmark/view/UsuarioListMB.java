package br.gov.prodepa.bookmark.view;

import java.util.Iterator;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.prodepa.bookmark.business.UsuarioServiceBC;
import br.gov.prodepa.bookmark.domain.Usuario;
import br.gov.prodepa.bookmark.dto.search.CommonSearchsDto;
import br.gov.prodepa.bookmark.qualifier.UsuarioForm;
import br.gov.prodepa.bookmark.secutity.Credenciais;

@ViewController
@NextView("/private/usuario/edit.jsf")
@PreviousView("/private/usuario/list.jsf")
public class UsuarioListMB extends AbstractListPageBean<Usuario, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioServiceBC bc;
	
	private List<Usuario> usuarios;
	
	CommonSearchsDto searchsDto = new CommonSearchsDto();

	public void search() {
		System.out.println(this.searchsDto);
		
		usuarios = bc.findByExample(this.searchsDto);
	}
	
	@Override
	protected List<Usuario> handleResultList() {
		return usuarios; 
	}

	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);

			if (delete) {
				bc.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

	public CommonSearchsDto getSearchsDto() {
		return searchsDto;
	}

	public void setSearchsDto(CommonSearchsDto searchsDto) {
		this.searchsDto = searchsDto;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
