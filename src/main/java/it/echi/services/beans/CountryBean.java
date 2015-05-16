package it.echi.services.beans;

import java.io.Serializable;

public final class CountryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String code;
	private final String description;
	
	
	public CountryBean(final String code,final String description) {
		super();
		this.code=code;
		this.description=description;
	}
	public String getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	

}
