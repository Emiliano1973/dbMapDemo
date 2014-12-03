package it.echi.services;

import it.echi.services.beans.TownBean;

import java.util.List;

public interface TownService {


	public List<TownBean> getAllTowns() throws ServiceException;
	
	public List<TownBean> getTownsByRegionId(long regionId) throws ServiceException;
	
	public TownBean findTownByPostCode(String postCode) throws ServiceException;

}
