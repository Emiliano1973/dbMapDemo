package it.echi.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.echi.beans.Country;
import it.echi.services.CountryService;
import it.echi.services.ServiceException;
import it.echi.services.beans.CountryBean;
import it.echi.stores.CountryDAO;
import it.echi.stores.DAOException;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDAO countryDAO;
	
	public CountryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<CountryBean> getAllCountries() throws ServiceException {
			List<CountryBean> countries=null;
			try {
			 List<Country>	countriesDB=this.countryDAO.getCountries();
			 countries=new ArrayList<CountryBean>(countriesDB.size());
			 Iterator<Country> iter=countriesDB.iterator();
			 while(iter.hasNext()){
				 Country cou=iter.next();
				 countries.add(new CountryBean(cou.getCountry(), cou.getDescription()));
			 }
			 
			} catch (DAOException e) {
				throw new ServiceException("Error in service :"+e.getMessage(), e);

			}
		
		return countries;
	}

}
