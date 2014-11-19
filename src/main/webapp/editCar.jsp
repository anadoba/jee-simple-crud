<%@page import="pl.nadoba.cars.service.CarStorageService"%>
<%@page import="pl.nadoba.cars.model.Car"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JEE Project 1 - Cars</title>
        <link href='bootstrap/css/bootstrap.css' rel="stylesheet">
    </head>
    <body class="container theme-showcase">
        <h2>Edit the car</h2>
        <form action='modify'>
            <input type='hidden' name='editUUID' value='${car.uuid}'/>
            Make: <input type='text' name='make' value='${car.make}'/><br>
            Model: <input type='text' name='model' value='${car.model}'/><br>
            Body style:
            <select name='bodyStyle'>
                <option value='coupe' <c:if test="${car.bodyStyle == \"coupe\"}">selected</c:if>>coupe</option><br>
                <option value='estate' <c:if test="${car.bodyStyle == \"estate\"}">selected</c:if>>estate</option><br>
                <option value='hatchback' <c:if test="${car.bodyStyle == \"hatchback\"}">selected</c:if>>hatchback</option><br>
                <option value='sedan' <c:if test="${car.bodyStyle == \"sedan\"}">selected</c:if>>sedan</option>
            </select><br>
            Engine capacity: <input type='text' name='engineCapacity' value='${car.engineCapacity}'/><br>
            Horsepower: <input type='text' name='horsepower' value='${car.horsepower}'/><br>
            Fuel type: <input type='radio' name='fuelType' value='petrol' <c:if test="${car.fuelType == \"petrol\"}">checked</c:if>>petrol
                <input type='radio' name='fuelType' value='diesel' <c:if test="${car.fuelType == \"diesel\"}">checked</c:if>>diesel
                <input type='radio' name='fuelType' value='autogas' <c:if test="${car.fuelType == \"autogas\"}">checked</c:if>>autogas<br>
            Color: <input type='text' name='color' value='${car.color}'/><br>
            <input class='btn btn-success' type='submit' value='Edit'/>
        </form>
    </body>
</html>
