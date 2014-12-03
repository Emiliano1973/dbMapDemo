package it.echi.stores;

import it.echi.beans.Country;

public interface CountryDAO {

	public java.util.List<Country> getCountries() throws DAOException;
	
	public Country findCountryById(String code) throws DAOException;
}
