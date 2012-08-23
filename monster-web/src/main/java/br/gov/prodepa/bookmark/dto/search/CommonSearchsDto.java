package br.gov.prodepa.bookmark.dto.search;

import java.io.Serializable;

import javax.inject.Named;

import br.gov.frameworkdemoiselle.annotation.Name;

//@Named("searchsDto")
public class CommonSearchsDto implements Serializable {

	private static final long serialVersionUID = 4613442883761171258L;

	private String pattern;

	public CommonSearchsDto() {
		super();
	}

	public CommonSearchsDto(String pattern) {
		super();
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public String toString() {
		return "Pattern: " + pattern;
	}
	
}
