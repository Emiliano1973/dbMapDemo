package it.echi.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.echi.beans.Town;
import it.echi.services.ServiceException;
import it.echi.services.TownService;
import it.echi.services.beans.TownBean;
import it.echi.stores.DAOException;
import it.echi.stores.TownDAO;

@Service
public class TownServiceImpl implements TownService {

	@Autowired
	private TownDAO townDAO;
	
	public TownServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<TownBean> getAllTowns() throws ServiceException {
		List<TownBean> townBeans=null;
		try {
			List<Town> towns=this.townDAO.getAllTowns();
			townBeans=swapTowns(towns);
		} catch (DAOException e) {
			throw new ServiceException("Error in service :"+e.getMessage(), e);
		}
		
		
		return townBeans;
	}

	public List<TownBean> getTownsByRegionId(long regionId) throws ServiceException {
		List<TownBean> townBeans=null;
		try {
			List<Town> towns=this.townDAO.getTownsByRegionId(regionId);
			townBeans=swapTowns(towns);
		} catch (DAOException e) {
			throw new ServiceException("Error in service :"+e.getMessage(), e);
		}
		
		
		return townBeans;
		}

	public TownBean findTownByPostCode(String postCode) throws ServiceException {
		TownBean townBean=null;
		try {
			Town town =this.townDAO.findTownByPostCode(postCode);
			townBean=swapTown(town);
		} catch (DAOException e) {
			throw new ServiceException("Error in service :"+e.getMessage(), e);
		}
		return townBean;
	}
	
	
	
	private List<TownBean> swapTowns(List<Town> towns){
		List<TownBean> townBeans=new ArrayList<TownBean>(towns.size());
		for(Town town:towns){
			townBeans.add(swapTown(town));
		}
		return townBeans;
	}

	
	private TownBean swapTown(Town town){
		return new TownBean(town.getPostcode(), town.getEastings(), town.getLatitude(), town.getLongitude(), town.getNorthings(), town.getTown(), town.getRegion().getIdRegion());
	}

}
