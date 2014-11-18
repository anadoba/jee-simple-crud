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
        int engineCapacity = Integer.parseInt(request.getParameter("engineCapacity"));
        int horsepower = Integer.parseInt(request.getParameter("horsepower"));
        String color = request.getParameter("color");

        Car newCar = new Car(make, model, Car.BodyStyle.coupe, Car.FuelType.petrol, engineCapacity, horsepower, color);

        carStorageService.store(newCar);

        // przekierowanie do index
        request.setAttribute("carStorageService", carStorageService);
        response.sendRedirect("cars");
    }

    @Override
    public void init() throws ServletException {
        if (getServletContext().getAttribute("carStorageService") == null)
            getServletContext().setAttribute("carStorageService", new CarStorageService());
    }
}
