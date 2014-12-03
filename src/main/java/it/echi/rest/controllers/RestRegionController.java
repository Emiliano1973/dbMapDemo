package it.echi.rest.controllers;

import it.echi.services.RegionService;
import it.echi.services.beans.RegionBean;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/region")
public class RestRegionController {

	@Autowired
	private RegionService regionService;

	public RestRegionController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Collection<RegionBean> getAllRegions() {
		Collection<RegionBean> regions = null;
		regions = this.regionService.getAllRegions();
		return regions;
	}

	@RequestMapping(value = "/all/{countryCode}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Collection<RegionBean> getRegionsByCountryCode(
			@PathVariable("countryCode") String code) {
		  
		Collection<RegionBean> regions = null;
		regions = this.regionService.getRegionsByCountryCode(code);
		return regions;
	}

	@RequestMapping(value = "/{regionId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RegionBean getRegionsById(
			@PathVariable("regionId") long id) {
		RegionBean region = null;
		region = this.regionService.getRegionById(id);
		return region;
	}

}
