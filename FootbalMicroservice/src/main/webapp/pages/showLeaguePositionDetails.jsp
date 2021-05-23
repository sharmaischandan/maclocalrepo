<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<div align="left">
		<h2>Football League</h2>
		<h3><a href="/">Home</a><br>
		<h3><a href="/searchCountries">Search Countries</a><br>
		<a href="/searchLeague">Search League</a><br>
		<a href="/searchTeam">Search Team</a><br>
		<a href="/leaguePosition">Search Position</a><br></h3>
</div>
<head>
	<div align="center">
		<h2>Country Details</h2>
			<span>League Id:</span><span>${leaguePosition.league_id}</span><br/>
			<span>Country Name:</span><span>${leaguePosition.country_name}</span><br/>
			<span>League Id:</span><span>${leaguePosition.league_name}</span><br/>
			<span>Team Name:</span><span>${leaguePosition.team_name}</span><br/>
			<span>Overall League Position:</span><span>${leaguePosition.overall_league_position}</span><br/>
	</div>
</html>

