package br.gov.prodepa.monster.project.secutity;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.security.SecurityContext;

@Alternative
public class Autorizador implements Authorizer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SecurityContext context;

	@Override
	public boolean hasRole(String role) {
		String usr = context.getUser().getId();
		boolean authorized = false;

		if (usr.equals("gerente") && role.equals("gerente")) {
			authorized = true;
		}

		return authorized;
	}

	@Override 
	public boolean hasPermission(String res, String op) {
		String usr = context.getUser().getId();
		boolean authorized = false;

		//TODO ControleAcesso, né !
		
		if (context.hasRole("gerente")) {
			authorized = true;
		}else{
			if (usr.equals("atendente")) {
			
				if (res.equals("setor")) {
					
					if(op.equals("create")) {
						authorized = true;
					} else
					if(op.equals("update")) {
						authorized = true;
					} else 
				    if(op.equals("delete")) {
						authorized = true;
					}
				} else
				if (res.equals("usuario")) {
					
					if(op.equals("create")) {
						authorized = true;
					} else
					if(op.equals("update")) {
						authorized = true;
					} else 
				    if(op.equals("delete")) {
						authorized = true;
					}
				} else
				if (res.equals("projeto")) {
					
					if(op.equals("create")) {
						authorized = true;
					} else
					if(op.equals("update")) {
						authorized = true;
					} else 
				    if(op.equals("delete")) {
						authorized = true;
					}
				}
				
			}
		}		

		return authorized;
	}

}
