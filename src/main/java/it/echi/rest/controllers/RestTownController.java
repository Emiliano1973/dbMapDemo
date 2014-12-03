package it.echi.rest.controllers;

import java.util.Collection;

import it.echi.services.TownService;
import it.echi.services.beans.TownBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/town")
public class RestTownController {

	@Autowired
	private TownService townService;

	public RestTownController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Collection<TownBean> getAllTowns() {
		Collection<TownBean> towns = this.townService.getAllTowns();
		return towns;
	}

	@RequestMapping(value = "/all/{regionId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Collection<TownBean> getTownsByRegionId(
			@PathVariable("regionId") long id) {
		Collection<TownBean> towns = this.townService.getTownsByRegionId(id);
		return towns;
	}

	@RequestMapping(value = "/{postcode}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody TownBean getTownByPostCode(
			@PathVariable("postcode") String postCode) {
		TownBean town = this.townService.findTownByPostCode(postCode);
		return town;
	}

}
