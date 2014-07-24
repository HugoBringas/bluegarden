<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Test</title>
</head>
<body>
	<form action="${uploadUrl}" method="post" enctype="multipart/form-data">
		<input type="file" name="myFile"> <input type="submit"
			value="Submit">
	</form>
</body>
</body>
</html>