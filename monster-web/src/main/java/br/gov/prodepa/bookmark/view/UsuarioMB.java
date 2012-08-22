package br.gov.prodepa.bookmark.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.prodepa.bookmark.business.UsuarioServiceBC;
import br.gov.prodepa.bookmark.domain.Usuario;
import br.gov.prodepa.bookmark.dto.search.CommonSearchsDto;
import br.gov.prodepa.bookmark.qualifier.UsuarioForm;

@Named
@ConversationScoped
/*@ViewController
@NextView("/private/usuario/edit.jsf")
@PreviousView("/private/usuario/list.jsf")*/
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final String nextView = "/private/usuario/edit.xhtml";
	private static final String previousView = "/private/usuario/list.xhtml";

	//@Inject
	//@UsuarioForm
	private Usuario usuario;
	
	@Inject
	private UsuarioServiceBC usuarioService;
	
	private List<Usuario> usuarios;
	
	private CommonSearchsDto searchsDto = new CommonSearchsDto();
	
	@Inject
	private Conversation conversation;
	
	
	public String insert() {
		this.usuarioService.insert(usuario);
		return previousView;
	}
	
	public String update() {
		this.usuarioService.update(this.usuario);
		return previousView;
	}
	
	public String delete() {
		this.usuarioService.delete(this.usuario.getId());
		return previousView;
	}
	
	public void search() {
		conversation.begin();
		this.usuarios = this.usuarioService.findByExample(searchsDto);
		System.out.println(this.usuarios);
	}
	
	@Named
	@Produces
	@UsuarioForm
	public Usuario getUsuarioForm() {
		
		/*System.out.println(id != null ? id.getValue():"");
		
		if(id != null && id.getValue() != null) {
			
			System.out.println(id.getValue() + " " + Long.getLong(id.getValue()) );
			
			this.usuario = usuarioService.load(Long.getLong(id.getValue()));
		}*/
		
		return this.usuario != null ? this.usuario : new Usuario();
	}
	
	@Produces
	@Named("usuarios")
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void showView(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void showView() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>");
	}
	
	
	
	public String showEdit(Usuario usuario) {
		
		this.usuario = usuario;
		System.out.println(this.usuario);
		return nextView;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
