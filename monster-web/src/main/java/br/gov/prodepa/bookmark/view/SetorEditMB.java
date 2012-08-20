package br.gov.prodepa.bookmark.view;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.prodepa.bookmark.business.BookmarkBC;
import br.gov.prodepa.bookmark.business.SetorBC;
import br.gov.prodepa.bookmark.domain.Bookmark;
import br.gov.prodepa.bookmark.domain.Setor;

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
