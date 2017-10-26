<%--
  Created by IntelliJ IDEA.
  User: cts1
  Date: 23/10/17
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <title>vehicle details</title>
</head>
<body>
<h1>Fill the vehicle details</h1>
<s:url var="url_rate"  value="/rate_per_KM"/>
<f:form action="${url_rate}" modelAttribute="command">
    <table border="1">
        <tr>
            <td>Name of vehicle</td>
            <td><f:input path="nameOfVehicle" /> </td>
        </tr>
        <tr>
            <td>Fuel type</td>
            <td><f:select path="fuelType" >
                <option selected="selected" disabled="disabled">Choose option</option>
                <option value="diesel">diesel</option>
                <option value="petrol">petrol</option>
            </f:select>
            </td>
        </tr>
        <tr>
            <td>AC or NON-AC</td>
            <td><f:select path="isAc">
                <option selected="selected" disabled="disabled">Choose option</option>
                <option value="ac">AC</option>
                <option value="non-ac">NON-AC</option>
            </f:select></td>
        </tr>
            <td colspan="2" align="right">
                <button>Submit</button> <br/>
            </td>
        </tr>
    </table>
</f:form>
</body>
</html>
