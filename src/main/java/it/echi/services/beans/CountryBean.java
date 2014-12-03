package it.echi.services.beans;

import java.io.Serializable;

public class CountryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code=null;
	private String description=null;
	
	public CountryBean() {
		
	}
	public CountryBean(String code, String description) {
		this.code=code;
		this.description=description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
