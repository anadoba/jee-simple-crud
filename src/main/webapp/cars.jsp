<%@page import="pl.nadoba.cars.service.CarStorageService"%>
<%@page import="pl.nadoba.cars.model.Car"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JEE Project 1 - Cars</title>
        <link href='bootstrap/css/bootstrap.css' rel="stylesheet">
    </head>
    <body class="container theme-showcase">
        <h2>Cars</h2>

            <c:forEach var="car" items="${carsDB}">
                <tr>
                    <td>${car.make}</td>
                </tr>
            </c:forEach>

        <p><a class='btn btn-success' href="addCar.jsp">Add new car</a></p>
    </body>
</html>
