<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<div align="left">
		<h2>Football League</h2>
		<h3><a href="/">Home</a><br>
		<h3><a href="/searchCountries">Search Countries</a><br>
		<a href="/searchLeague">Search League</a><br>
		<a href="/searchTeam">Search Team</a><br>
		<a href="/leaguePosition">Search Position</a><br></h3>
</div>
<div align="center">
		<h2>Country Details</h2>
			<span>League Id:</span><span>${league.league_id}</span><br/>
			<span>League Name:</span><span>${league.league_name}</span><br/>
			<span>Country Id:</span><span>${league.country_id}</span><br/>
			<span>Country Name:</span><span>${league.country_name}</span><br/>
	</div>
</html>