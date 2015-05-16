package it.echi.services.beans;

import java.io.Serializable;

public final class RegionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int idRegion;
	private final String countryCode;
	private final String description;
	 

	public RegionBean(final int idRegion,final String description,final String countryCode) {
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
