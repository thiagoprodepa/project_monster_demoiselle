package br.gov.prodepa.monster.project.view;

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

import br.gov.prodepa.monster.project.business.BookmarkBC;
import br.gov.prodepa.monster.project.business.SetorBC;
import br.gov.prodepa.monster.project.domain.Bookmark;
import br.gov.prodepa.monster.project.domain.Setor;
import br.gov.prodepa.monster.project.dto.search.CommonSearchsDto;
import br.gov.prodepa.monster.project.secutity.Credenciais;

@ViewController
@NextView("/private/setor/edit.jsf")
@PreviousView("/private/setor/list.jsf")
public class SetorListMB extends AbstractListPageBean<Setor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SetorBC bc;
	
	CommonSearchsDto searchsDto = new CommonSearchsDto();

	public void search() {
		handleResultList();
	}
	
	@Override
	protected List<Setor> handleResultList() {
		
		System.out.println(searchsDto);
		
		List<Setor> li = bc.findByExamples(searchsDto);
		System.out.println(li);
		return li;
		//return this.bc.findAll();
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
	
	

}
