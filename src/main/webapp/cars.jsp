<%@page import="pl.nadoba.cars.service.CarStorageService"%>
<%@page import="pl.nadoba.cars.model.Car"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <table class="table table-hover">
                <tr>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Body style</th>
                    <th>Engine capacity</th>
                    <th>Horsepower</th>
                    <th>Fuel type</th>
                    <th>Color</th>
                </tr>
                <c:forEach var="car" items="${cars}">
                    <tr>
                        <td>${car.make}</td>
                        <td>${car.model}</td>
                        <td>${car.bodyStyle}</td>
                        <td>${car.engineCapacity} cc</td>
                        <td>${car.horsepower} hp</td>
                        <td>${car.fuelType}</td>
                        <td>${car.color}</td>
                    </tr>
                </c:forEach>
            </table>
        <p><a class='btn btn-success' href="addCar.jsp">Add new car</a></p>
    </body>
</html>
