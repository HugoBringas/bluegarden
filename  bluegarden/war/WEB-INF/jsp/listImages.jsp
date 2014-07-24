<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Images</title>
</head>
<body>
	<table  class="table table-bordered">
		<thead>
			<tr>
				<th>Name</th>
				<th>Link</th>
				<th>Date Uploaded</th>
				<th>Size in bytes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="picture" items="${pictures}">
				<tr>
					<td>${picture.name}</td>
					<td><a href="${picture.url}"> <img
							style="width: 24%; height: 37" class="img-thumbnail center-block"
							src="${picture.url}" alt="no_image" />
					</a></td>
					<td>${picture.dateUploaded}</td>
					<td>${picture.size}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>