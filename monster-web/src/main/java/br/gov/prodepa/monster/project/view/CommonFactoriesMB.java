package br.gov.prodepa.monster.project.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import br.gov.prodepa.monster.project.domain.Perfil;

@SessionScoped
public class CommonFactoriesMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Named("perfis")
	@Produces
	public List<Perfil> getPerfilLists() {
		return null;
	}

}
