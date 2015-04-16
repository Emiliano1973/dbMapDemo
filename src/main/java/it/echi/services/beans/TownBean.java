package it.echi.services.beans;

import java.io.Serializable;

public class TownBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String postcode;

	private final int eastings;

	private final double latitude;

	private final double longitude;

	private final int northings;

	private final String town;

	private final int regionId;

	public TownBean(

	String postcode,

	int eastings,

	double latitude,

	double longitude,
	
	int northings,

	String town,

	int regionId) {
		this.postcode = postcode;

		this.eastings = eastings;

		this.latitude = latitude;

		this.longitude = longitude;

		this.northings = northings;

		this.town = town;

		this.regionId = regionId;

	}


	public String getPostcode() {
		return postcode;
	}


	public int getEastings() {
		return eastings;
	}

	public double getLatitude() {
		return latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public int getNorthings() {
		return northings;
	}


	public String getTown() {
		return town;
	}


	public int getRegionId() {
		return regionId;
	}


}
