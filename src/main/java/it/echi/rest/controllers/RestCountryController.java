package it.echi.rest.controllers;

import it.echi.services.CountryService;
import it.echi.services.beans.CountryBean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/country")
public class RestCountryController {

	@Autowired
	private CountryService countryService;

	public RestCountryController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<CountryBean> getAllCountries() {
		List<CountryBean> countries = null;
			countries = this.countryService.getAllCountries();
		return countries;
	}

}
