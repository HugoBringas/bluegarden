<%@page import="com.google.appengine.api.datastore.KeyFactory"%>
<%@page import="com.bluegarden.entities.Combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update combo</title>
</head>
<body>
	<p>combo update</p>
	<form:form method="POST" commandName="combo"
		action="/combos/save/${key}">
		<table>
			<tr>
				<td>Character Name:</td>
				<td><form:input path="character" /></td>
				<td><form:errors path="character" /></td>
			</tr>
			<tr>
				<td>Combo:</td>
				<td><form:input path="combo" /></td>
				<td><form:errors path="combo" /></td>
			</tr>
			<tr>
				<td>Damage:</td>
				<td><form:input path="damage" /></td>
				<td><form:errors path="damage" /></td>
			</tr>
			<tr>
				<td>Additional Info:</td>
				<td><form:textarea path="additionalInfo" /></td>
				<td><form:errors path="additionalInfo" /></td>
			</tr>

			<tr>
				<input type="submit" />
			</tr>

		</table>
	</form:form>
</body>
</html>