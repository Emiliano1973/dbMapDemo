package it.echi.services;

import it.echi.services.beans.RegionBean;

import java.util.List;

public interface RegionService {

	public List<RegionBean> getAllRegions() throws ServiceException;
	
	public List<RegionBean> getRegionsByCountryCode(String code) throws ServiceException;
	
	public RegionBean getRegionById(long id)throws ServiceException;
	
	
	
}
