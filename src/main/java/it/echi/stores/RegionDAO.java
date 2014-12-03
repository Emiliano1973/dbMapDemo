package it.echi.stores;

import it.echi.beans.Region;

import java.util.List;

public interface RegionDAO {

	public List<Region> getAllRegions() throws DAOException;
	
	public List<Region> getRegionsByCountryCode(String code) throws DAOException;
	
	public Region findRegionById(long id) throws DAOException;
}
