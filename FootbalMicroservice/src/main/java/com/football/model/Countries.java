package com.football.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import java.util.*;


public class Countries {
	public int country_id;
	public String country_name;

	
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	
	
	public void setCountryIdList(ArrayList<Integer> country_id) {
		//this.country_id = country_id;
	}

	public void setCountryNameList(ArrayList<String> country_name) {
		//this.country_name = country_name;
	}
	
	
	@Override
	public String toString() {
		return "Countries [country_id=" + country_id + ", country_name=" + country_name + "]";
	}
	

}
