package it.echi.services.beans;

import java.io.Serializable;

public class RegionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idRegion;
	private String countryCode;
	private String description;
	
	public RegionBean() {
		super();
	}


	public RegionBean(int idRegion, String description, String countryCode) {
		this();
		this.idRegion=idRegion;
		this.description=description;
		this.countryCode=countryCode;
	}

	public int getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
