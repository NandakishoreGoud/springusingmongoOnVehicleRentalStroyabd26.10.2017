<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: cts1
  Date: 23/10/17
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <title>journey form</title>
</head>
<body>
<s:url var="url_dis"  value="/distance_cal"/>
<f:form action="${url_dis}" modelAttribute="command">
    <table border="1">
        <tr>
            <td>From City</td>
            <td><f:input path="fromCity" /> </td>
        </tr>
        <tr>
            <td>To City</td>
            <td><f:input path="toCity" /> </td>
        </tr>

        <td colspan="2" align="right">
            <button>Submit</button> <br/>
        </td>
        </tr>
    </table>
</f:form>
</body>
</html>
