package br.gov.prodepa.bookmark.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.prodepa.bookmark.business.BookmarkBC;
import br.gov.prodepa.bookmark.business.SetorBC;
import br.gov.prodepa.bookmark.domain.Bookmark;
import br.gov.prodepa.bookmark.domain.Setor;

@ViewController
@PreviousView("/setor/bookmark_list.xhtml")
public class SetorMB extends AbstractEditPageBean<Setor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SetorBC setorkBC;

	@Override
	@Transactional
	public String delete() {
		this.setorkBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.setorkBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.setorkBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		setBean(this.setorkBC.load(getId()));
	}

}
