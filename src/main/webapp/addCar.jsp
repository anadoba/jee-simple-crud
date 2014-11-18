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
        <h2>Add new car</h2>
        <form action='modify'>
            Make: <input type='text' name='make'/><br>
            Model: <input type='text' name='model'/><br>
            Body style:
            <select name='bodyStyle'>
                <option value='coupe'>coupe</option><br>
                <option value='estate'>estate</option><br>
                <option value='hatchback'>hatchback</option><br>
                <option value='sedan'>sedan</option>
            </select><br>
            Engine capacity: <input type='text' name='engineCapacity'/><br>
            Horsepower: <input type='text' name='horsepower'/><br>
            Fuel type: <input type='radio' name='fuelType' value='petrol'>petrol
                <input type='radio' name='fuelType' value='diesel'>diesel
                <input type='radio' name='fuelType' value='autogas'>autogas<br>
            Color: <input type='text' name='color'/><br>
            <input class='btn btn-success' type='submit' value='Add'/>
        </form>
    </body>
</html>
