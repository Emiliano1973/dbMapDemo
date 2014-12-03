package it.echi.services;

import it.echi.services.beans.CountryBean;


public interface CountryService {

	public java.util.List<CountryBean> getAllCountries() throws ServiceException;
}
