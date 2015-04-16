package it.echi.services.beans;

import java.io.Serializable;

public class RegionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int idRegion;
	private final String countryCode;
	private final String description;
	 

	public RegionBean(int idRegion, String description, String countryCode) {
		super();
		this.idRegion=idRegion;
		this.description=description;
		this.countryCode=countryCode;
	}

	public int getIdRegion() {
		return idRegion;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public String getDescription() {
		return description;
	}
	
}
