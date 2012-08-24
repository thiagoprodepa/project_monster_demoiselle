package br.gov.prodepa.monster.project.secutity;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.security.User;

@Alternative
public class Autenticador implements Authenticator {

	private static final long serialVersionUID = 1L;

	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private Credenciais credentials;

	@Override
	public boolean authenticate() {
		
		if(securityContext != null && securityContext.isLoggedIn()) {
			//TODO add message for user already logged
			return true;
		}
		
		String username = credentials.getUsername();
		String password = credentials.getPassword();

		boolean authenticated = false;

		if (username.equals("gerente") && password.equals("gerente")) {
			authenticated = true;
		} else if (username.equals("atendente") && password.equals("atendente")) {
			authenticated = true;
		}

		return authenticated;
	}

	@Override
	public void unAuthenticate() {
		credentials.clear();
	}

	@Override
	public User getUser() {
		
		if(credentials == null || credentials.getUsername() == null || credentials.getUsername().equals("")) {
			return null;
		} else {
		
			//TODO deve ir para o controle de acesso.
			
			return new User() {
	
				private static final long serialVersionUID = 1L;
	
				@Override
				public String getId() {
					return credentials.getUsername();
				}
	
				@Override
				public void setAttribute(Object key, Object value) {
				}
	
				@Override
				public Object getAttribute(Object key) {
					return null;
				}
			};
		}
	}

}
