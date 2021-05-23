package com.football.controller;

import org.jvnet.staxex.util.FinalArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import java.util.stream.Collector;

import com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector;
import com.football.exception.RecordNotfoundException;
import com.football.model.Countries;
import com.football.model.League;
import com.football.model.LeaguePosition;

@Controller
public class HomeController {

	@Autowired
	private RestTemplate restTemplate;

	final String KEY = "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping(value = "/searchCountries")
	public String searchCompany(Model model) {
		Countries countries = new Countries();

		messageTypeConverter();
		try {
			ResponseEntity<Countries[]> response = restTemplate
					.getForEntity("https://apifootball.com/api/?action=get_countries&APIkey=" + KEY, Countries[].class);

			Countries[] countriesArray = response.getBody();
			for (Countries ct : countriesArray) {
				countries.setCountry_id(ct.country_id);
				countries.setCountry_name(ct.country_name);
			}
		} catch (Exception e) {
			throw new RecordNotfoundException();
		}
		model.addAttribute("countries", countries);
		return "showCountryDetails";
	}

	@PostMapping(value = "/searchCountryById")
	public String searchCountryById(@ModelAttribute("countries") Countries countries) {

		messageTypeConverter();
		ResponseEntity<Countries[]> response = restTemplate
				.getForEntity("https://apifootball.com/api/?action=get_countries&country_id=" + countries.country_id
						+ "&APIkey=" + KEY, Countries[].class);
		Countries[] countriesArray = response.getBody();

		for (Countries ct : countriesArray) {
			countries.setCountry_id(ct.country_id);
			countries.setCountry_name(ct.country_name);
		}
		return "showCountryDetails";
	}

	@GetMapping(value = "/searchLeague")
	public String searchLeague(Model model) {
		League league = new League();

		messageTypeConverter();
		try {
			ResponseEntity<League[]> response = restTemplate
					.getForEntity("https://apifootball.com/api/?action=get_leagues&APIkey=" + KEY, League[].class);
			League[] countriesArray = response.getBody();
			for (League le : countriesArray) {
				league.setLeague_id(le.getLeague_id());
				league.setLeague_name(le.getLeague_name());
				league.setCountry_id(le.getCountry_id());
				league.setCountry_name(le.getCountry_name());
			}
		} catch (Exception e) {
			throw new RecordNotfoundException();
		}
		model.addAttribute("league", league);

		return "showLeagueDetails";
	}

	@GetMapping(value = "/searchTeam")
	public String searchTeam(Model model) {
		Countries countries = new Countries();

		try {
			ResponseEntity<Countries[]> response = restTemplate
					.getForEntity("https://apifootball.com/api/?action=get_countries&APIkey=" + KEY, Countries[].class);

			Countries[] countriesArray = response.getBody();
			List<Integer> countryIdArr = new ArrayList<>();
			List<String> countryNameArr = new ArrayList<>();
			for (Countries ct : countriesArray) {
				countryIdArr.add(ct.getCountry_id());
				countryNameArr.add(ct.getCountry_name());
				countries.setCountry_id(ct.getCountry_id());
				countries.setCountry_name(ct.getCountry_name());
			}
		} catch (Exception e) {
			throw new RecordNotfoundException();
		}
		model.addAttribute("countries", countries);
		return "showTeamDetails";
	}

	@GetMapping(value = "/leaguePosition")
	public String leaguePosition(Model model) {
		LeaguePosition leaguePosition = new LeaguePosition();

		messageTypeConverter();
		try {
			ResponseEntity<LeaguePosition[]> response = restTemplate.getForEntity(
					"https://apifootball.com/api/?action=get_standings&country_id=169&league_id=62&APIkey=" + KEY,
					LeaguePosition[].class);

			LeaguePosition[] countriesArray = response.getBody();
			for (LeaguePosition lp : countriesArray) {
				leaguePosition.setLeague_id(lp.getLeague_id());
				leaguePosition.setLeague_name(lp.getLeague_name());
				leaguePosition.setCountry_name(lp.getCountry_name());
				leaguePosition.setTeam_name(lp.getTeam_name());
				leaguePosition.setOverall_league_position(lp.getOverall_league_position());
			}
		} catch (Exception e) {
			throw new RecordNotfoundException();
		}

		model.addAttribute("leaguePosition", leaguePosition);
		return "showLeaguePositionDetails";
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	void messageTypeConverter() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		// Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		// Note: here we are making this converter to process any kind of response,
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
	}

}
