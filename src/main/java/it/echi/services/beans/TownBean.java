package it.echi.services.beans;

import java.io.Serializable;

public class TownBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String postcode;

	private int eastings;

	private double latitude;

	private double longitude;

	private int northings;

	private String town;

	private int regionId;

	public TownBean(

	String postcode,

	int eastings,

	double latitude,

	double longitude,
	
	int northings,

	String town,

	int regionId) {
		this();
		this.postcode = postcode;

		this.eastings = eastings;

		this.latitude = latitude;

		this.longitude = longitude;

		this.northings = northings;

		this.town = town;

		this.regionId = regionId;

	}

	public TownBean() {
		super();
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getEastings() {
		return eastings;
	}

	public void setEastings(int eastings) {
		this.eastings = eastings;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getNorthings() {
		return northings;
	}

	public void setNorthings(int northings) {
		this.northings = northings;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

}
