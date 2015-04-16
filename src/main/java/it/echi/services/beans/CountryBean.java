package it.echi.services.beans;

import java.io.Serializable;

public class CountryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String code;
	private final String description;
	
	
	public CountryBean(String code, String description) {
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
