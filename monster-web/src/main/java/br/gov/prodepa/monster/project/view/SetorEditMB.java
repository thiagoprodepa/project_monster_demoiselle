package br.gov.prodepa.monster.project.view;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.prodepa.monster.project.business.BookmarkBC;
import br.gov.prodepa.monster.project.business.SetorBC;
import br.gov.prodepa.monster.project.domain.Bookmark;
import br.gov.prodepa.monster.project.domain.Setor;

@ViewController
@PreviousView("/private/setor/list.xhtml")
public class SetorEditMB extends AbstractEditPageBean<Setor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SetorBC setorBc;

	@Override
	@Transactional
	public String delete() {
		this.setorBc.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.setorBc.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.setorBc.update(getBean());
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		setBean(this.setorBc.load(getId()));
	}

}
