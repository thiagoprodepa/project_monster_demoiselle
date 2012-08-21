package br.gov.prodepa.bookmark.view;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.gov.prodepa.bookmark.business.UsuarioServiceBC;
import br.gov.prodepa.bookmark.domain.Usuario;
import br.gov.prodepa.bookmark.dto.search.CommonSearchsDto;
import br.gov.prodepa.bookmark.qualifier.UsuarioForm;

@ViewController
@NextView("/private/usuario/edit.xhtml")
@PreviousView("/private/usuario/list.xhtml")
public class UsuarioMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	@UsuarioForm
	private Usuario usuario;

	@Inject
	private UsuarioServiceBC usuarioService;
	
	private List<Usuario> usuarios;
	
	private CommonSearchsDto searchsDto = new CommonSearchsDto();
	
	
	public String insert() {
		this.usuarioService.insert(usuario);
		return getPreviousView();
	}
	
	public String update() {
		this.usuarioService.update(this.usuario);
		return getPreviousView();
	}
	
	public String delete() {
		this.usuarioService.delete(this.usuario.getId());
		return getPreviousView();
	}
	
	public void search() {
		this.usuarios = this.usuarioService.findByExample(searchsDto);
		System.out.println(this.usuarios);
	}
	
	@Named
	@Produces
	@UsuarioForm
	public Usuario getUsuarioForm() {
		return this.usuario != null ? this.usuario : new Usuario();
	}
	
	@Produces
	@Named("usuarios")
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	
	
	public CommonSearchsDto getSearchsDto() {
		return searchsDto;
	}

	public void setSearchsDto(CommonSearchsDto searchsDto) {
		this.searchsDto = searchsDto;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
	
}
