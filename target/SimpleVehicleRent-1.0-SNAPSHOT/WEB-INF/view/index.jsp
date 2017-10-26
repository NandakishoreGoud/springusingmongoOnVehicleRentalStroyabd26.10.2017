<%--
  Created by IntelliJ IDEA.
  User: cts1
  Date: 23/10/17
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <title>rate per km</title>
</head>
<body>
<h2>rate per km for the vehicle is ${som}</h2>
<br>
<s:url var="dis" value="/journey_form"/>
<a href="${dis}"><h3>Journey</h3></a>
</body>
</html>
