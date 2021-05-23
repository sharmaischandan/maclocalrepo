package com.football.model;

public class LeaguePosition {
	
	String country_name;
    int league_id;
    String league_name;
    String team_name;
    int overall_league_position;
    
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
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
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public int getOverall_league_position() {
		return overall_league_position;
	}
	public void setOverall_league_position(int overall_league_position) {
		this.overall_league_position = overall_league_position;
	}
	@Override
	public String toString() {
		return "LeaguePosition [country_name=" + country_name + ", league_id=" + league_id + ", league_name="
				+ league_name + ", team_name=" + team_name + ", overall_league_position=" + overall_league_position
				+ "]";
	}
    
}
