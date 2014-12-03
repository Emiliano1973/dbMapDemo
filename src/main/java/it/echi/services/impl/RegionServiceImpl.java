package it.echi.services.impl;

import it.echi.beans.Region;
import it.echi.services.RegionService;
import it.echi.services.ServiceException;
import it.echi.stores.DAOException;
import it.echi.stores.RegionDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class RegionServiceImpl implements RegionService {
 
	@Autowired
	private RegionDAO regionDAO;
	
	public RegionServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<it.echi.services.beans.RegionBean> getAllRegions() throws ServiceException {
		List<it.echi.services.beans.RegionBean> regionBeans=null;
		try {
			List<Region> regions=this.regionDAO.getAllRegions();
			regionBeans=swapRegions(regions);
		} catch (DAOException e) {
			throw new ServiceException("Error in service :"+e.getMessage(), e);
		}
		
		return regionBeans;
	} 

	public List<it.echi.services.beans.RegionBean> getRegionsByCountryCode(String code)
			throws ServiceException {
		List<it.echi.services.beans.RegionBean> regionBeans=null;
		try {
			List<Region> regions=this.regionDAO.getRegionsByCountryCode(code);
			regionBeans=swapRegions(regions);
		} catch (DAOException e) {
			throw new ServiceException("Error in service :"+e.getMessage(), e);
		}
		
		return regionBeans;
	}

	public it.echi.services.beans.RegionBean getRegionById(long id) throws ServiceException {
		it.echi.services.beans.RegionBean regionBean=null;
		try {
			Region region=this.regionDAO.findRegionById(id);
			regionBean=swapRegion(region);
		} catch (DAOException e) {
			throw new ServiceException("Error in service :"+e.getMessage(), e);
		}
		return regionBean;
	}

	private List<it.echi.services.beans.RegionBean> swapRegions(List<Region> regions){
		List<it.echi.services.beans.RegionBean> regionBeans=new ArrayList<it.echi.services.beans.RegionBean>(regions.size());
			for(Region region : regions){
				regionBeans.add(swapRegion(region));
			}
		return regionBeans;
	}
	
	private it.echi.services.beans.RegionBean swapRegion(Region region){
		
		return new it.echi.services.beans.RegionBean(region.getIdRegion(), region.getDescription(), region.getCountryBean().getCountry());
	}
}
