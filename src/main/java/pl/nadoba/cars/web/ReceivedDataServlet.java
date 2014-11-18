package pl.nadoba.cars.web;

import pl.nadoba.cars.model.Car;
import pl.nadoba.cars.service.CarStorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Gets the completed form and modifies the Storage
 */
@WebServlet("/modify")
public class ReceivedDataServlet extends HttpServlet {

    private CarStorageService carStorageService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        carStorageService = (CarStorageService) getServletContext().getAttribute("carStorageService");

        String make = request.getParameter("make");
        String model = request.getParameter("model");
        Car.BodyStyle bodyStyle = Car.BodyStyle.valueOf(request.getParameter("bodyStyle"));
        int engineCapacity = Integer.parseInt(request.getParameter("engineCapacity"));
        int horsepower = Integer.parseInt(request.getParameter("horsepower"));
        Car.FuelType fuelType = Car.FuelType.valueOf(request.getParameter("fuelType"));
        String color = request.getParameter("color");

        Car newCar = new Car(make, model, bodyStyle, fuelType, engineCapacity, horsepower, color);

        carStorageService.store(newCar);

        // przekierowanie do tabeli
        response.sendRedirect("cars");
    }

    @Override
    public void init() throws ServletException {
        if (getServletContext().getAttribute("carStorageService") == null)
            getServletContext().setAttribute("carStorageService", new CarStorageService());
    }
}
