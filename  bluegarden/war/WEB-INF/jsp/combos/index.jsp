<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Combos</title>
</head>
<body>
<p>combos index</p>
<form:form metho="POST" commandName="combo" action="/combos/add" >
<table>
<tr>
<td>Character Name:</td>
<td> <form:input path="character" /></td>
<td> <form:errors path="character" /></td>
</tr>
<tr>
<td>Combo:</td>
<td> <form:input path="combo" /></td>
<td> <form:errors path="combo" /></td>
</tr>
<tr>
<td>Damage:</td>
<td> <form:input path="damage" /></td>
<td> <form:errors path="damage" /></td>
</tr>

<tr>
<input type="submit" />
</tr>
</table>
</form:form>

</form>
</body>
</html>