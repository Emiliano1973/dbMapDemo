package it.echi.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * The persistent class for the Town database table.
 * 
 */
@Entity
@Table(name="Town")
public class Town implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="postcode")
	private String postcode;

	@Column(name="eastings")
	private int eastings;

	@Column(name="latitude")
	private double latitude;

	@Column(name="longitude")
	private double longitude;

	@Column(name="northings")
	private int northings;

	@Column(name="town")
	private String town;

	//bi-directional many-to-one association to Region
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRegion")
	private Region region;

	public Town() {
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getEastings() {
		return this.eastings;
	}

	public void setEastings(int eastings) {
		this.eastings = eastings;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getNorthings() {
		return this.northings;
	}

	public void setNorthings(int northings) {
		this.northings = northings;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}