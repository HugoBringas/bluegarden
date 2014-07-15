<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="bluegarden">
<head>
<script>
	var appName = "bluegarden";
</script>
<script type="text/javascript"
	src="<c:url value="/scripts/angular/angular.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/scripts/angular/angular-resource.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/scripts/angular/angular-route.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/scripts/angular/angular-ui-router.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/scripts/app/app.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/scripts/app/controllers/testController.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/scripts/app/uiStates.js"/>"></script>

</head>
<h1>test</h1>
<body>
	<jsp:doBody />
</body>

</html>