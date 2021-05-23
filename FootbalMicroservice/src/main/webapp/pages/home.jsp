<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Football Microservice</title>
<style type="text/css">
	label {
		display: inline-block;
		width: 200px;
		margin: 5px;
		text-align: left;
	}
	input[type=text] {
		width: 200px;	
	}
	
	
	button {
		padding: 10px;
		margin: 10px;
	}
</style>
</head>
<body>
	<div align="center">
		<h2>Football League</h2>
		<h3><a href="/searchCountries">Search Countries</a><br>
		<a href="/searchLeague">Search League</a><br>
		<a href="/searchTeam">Search Team</a><br>
		<a href="/leaguePosition">Search Position</a><br></h3>
	</div>
</body>
</html>
