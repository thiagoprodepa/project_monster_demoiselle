package br.gov.prodepa.bookmark.view;

import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.prodepa.bookmark.business.BookmarkBC;
import br.gov.prodepa.bookmark.business.SetorBC;
import br.gov.prodepa.bookmark.domain.Bookmark;
import br.gov.prodepa.bookmark.domain.Setor;
import br.gov.prodepa.bookmark.dto.search.CommonSearchsDto;

@ViewController
@NextView("/private/setor/edit.jsf")
@PreviousView("/private/setor/list.jsf")
public class SetorListMB extends AbstractListPageBean<Setor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SetorBC bc;
	
	private CommonSearchsDto searchsDto;

	public void search(CommonSearchsDto searchsDto) {
		System.out.println(searchsDto.getPattern());
		
		bc.findByExamples(searchsDto);
		
	}
	
	@Named 
	@Produces 
	@ConversationScoped
	public CommonSearchsDto getSearchsDto() { 
		return new CommonSearchsDto(); 
	}
	
	@Override
	protected List<Setor> handleResultList() {
		return this.bc.findAll();
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

}
