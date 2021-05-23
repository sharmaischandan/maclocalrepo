<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	label {
		display: inline-block;
		width: 80px;
		margin: 5px;
		text-align: left;
	}
	input[type=text]{
		width: 100;	
	}	
	button {
		padding: 10px;
		margin: 10px;
	}
</style>
</head>
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
		<span>Country Id:</span><span>${countries.country_id}</span><br/>
		<span>Country Name:</span><span>${countries.country_name}</span><br/>
	</div>
	
	<div align="center">
		<h2>Search By Country</h2>
		<form:form action="searchCountryById" method="post" modelAttribute="countries">
			<form:label path="country_id">Country Id:</form:label>
			<form:input path="country_id"/><br/>
			<form:button>Search Country</form:button>
		</form:form>
</html>