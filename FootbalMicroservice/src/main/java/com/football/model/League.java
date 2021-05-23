package com.football.model;

public class League {
	int league_id;
	String league_name;
	public int country_id;
	public String country_name;
	
	
	public int getLeague_id() {
		return league_id;
	}
	public void setLeague_id(int league_id) {
		this.league_id = league_id;
	}
	public String getLeague_name() {
		return league_name;
	}
	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}
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
	@Override
	public String toString() {
		return "League [league_id=" + league_id + ", league_name=" + league_name + ", country_id=" + country_id
				+ ", country_name=" + country_name + "]";
	}
	
	
	
}
