package it.echi.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the Country database table.
 * 
 */
@Entity
@Table(name="Country")
public class Country implements Serializable {
	@javax.persistence.Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="country")
	private String country;

	@Column(name="description")
	private String description;

	//bi-directional many-to-one association to Region
	@OneToMany(mappedBy="countryBean", fetch=FetchType.LAZY)
	private List<Region> regions;

	public Country() {
		super();
		this.regions=new ArrayList<Region>();
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Region> getRegions() {
		return this.regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public Region addRegion(Region region) {
		getRegions().add(region);
		region.setCountryBean(this);

		return region;
	}

	public Region removeRegion(Region region) {
		getRegions().remove(region);
		region.setCountryBean(null);

		return region;
	}

}