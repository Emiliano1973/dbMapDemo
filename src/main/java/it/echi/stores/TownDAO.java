package it.echi.stores;

import java.util.List;
import it.echi.beans.Town;
public interface TownDAO {

	public List<Town> getAllTowns() throws DAOException;
	
	public List<Town> getTownsByRegionId(long regionId) throws DAOException;
	
	public Town findTownByPostCode(String postCode) throws DAOException;
	

	
}
