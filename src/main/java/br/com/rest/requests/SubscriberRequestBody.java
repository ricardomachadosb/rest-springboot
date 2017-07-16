package br.com.rest.requests;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class SubscriberRequestBody {
	
	@NotBlank
	@NotNull
	private String email;
	
	@NotNull
	@NotEmpty
	private Set<String> categoryCodes;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getCategoryCodes() {
		return categoryCodes;
	}

	public void setCategoryCodes(Set<String> categoryCodes) {
		this.categoryCodes = categoryCodes;
	}
}
