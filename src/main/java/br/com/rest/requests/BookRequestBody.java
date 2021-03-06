package br.com.rest.requests;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookRequestBody {
	
	@NotBlank
	@NotNull
	private String tittle;
	
	@NotNull
	@NotEmpty
	private Set<String> categoryCodes;

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public Set<String> getCategoryCodes() {
		return categoryCodes;
	}

	public void setCategoryCodes(Set<String> categoryCodes) {
		this.categoryCodes = categoryCodes;
	}

}
