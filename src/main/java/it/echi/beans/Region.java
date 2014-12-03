package it.echi.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * The persistent class for the Region database table.
 * 
 */
@Entity
@javax.persistence.Table(name="Region")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Region implements Serializable {
	
	@javax.persistence.Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idRegion")
	private int idRegion;

	@Column(name="description")
	private String description;

	//bi-directional many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country")
	private Country countryBean;

	//bi-directional many-to-one association to Town
	@OneToMany(mappedBy="region", fetch=FetchType.LAZY)
	private List<Town> towns;

	public Region() {
		super();
		this.towns=new ArrayList<Town>();
	}

	public int getIdRegion() {
		return this.idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Country getCountryBean() {
		return this.countryBean;
	}

	public void setCountryBean(Country countryBean) {
		this.countryBean = countryBean;
	}

	public List<Town> getTowns() {
		return this.towns;
	}

	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}

	public Town addTown(Town town) {
		getTowns().add(town);
		town.setRegion(this);

		return town;
	}

	public Town removeTown(Town town) {
		getTowns().remove(town);
		town.setRegion(null);

		return town;
	}

}