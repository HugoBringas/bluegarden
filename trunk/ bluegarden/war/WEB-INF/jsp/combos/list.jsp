<%@page import="com.bluegarden.entities.Combo"%>
<%@page import="java.util.List"%>
<%@page import="com.google.appengine.api.datastore.KeyFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Combo List</title>
</head>
<body>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>Character</th>
					<th>Combo</th>
					<th>Damage</th>
					<th>Additional Info</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>

				<%
					if(request.getAttribute("combos") !=null){
																		List<Combo> list = (List<Combo>)request.getAttribute("combos");
																		for(Combo c : list){
				%>
				<tr>
					<td><%=c.getCharacter()%></td>
					<td><%=c.getCombo()%></td>
					<td><%=c.getDamage()%></td>
					<td><%=c.getAdditionalInfo() == null ? "" : c.getAdditionalInfo()%></td>
					<td>
					<a href="/combos/update/<%=KeyFactory.keyToString(c.getKey())%>">Update</a> | <a href="/combos/delete/<%=KeyFactory.keyToString(c.getKey())%>">Delete</a>
					</td>
				</tr>
				<%
					}
																		}
				%>
			</tbody>

		</table>

	</div>

</body>
</html>