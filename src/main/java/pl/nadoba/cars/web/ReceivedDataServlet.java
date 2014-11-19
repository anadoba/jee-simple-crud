package pl.nadoba.cars.web;

import pl.nadoba.cars.model.Car;
import pl.nadoba.cars.service.CarStorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Gets the completed form and modifies the Storage
 */
@WebServlet("/modify")
public class ReceivedDataServlet extends HttpServlet {

    private CarStorageService carStorageService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        carStorageService = (CarStorageService) getServletContext().getAttribute("carStorageService");

        if (request.getParameter("delete") != null) {
            UUID uuid = UUID.fromString(request.getParameter("delete"));
            carStorageService.delete(uuid);

            response.sendRedirect("cars");
            return;
        }

        if (request.getParameter("editUUID") != null) {
            Car car = carStorageService.getCar(UUID.fromString(request.getParameter("editUUID")));

            String make = request.getParameter("make");
            String model = request.getParameter("model");
            Car.BodyStyle bodyStyle = Car.BodyStyle.valueOf(request.getParameter("bodyStyle"));
            int engineCapacity = Integer.parseInt(request.getParameter("engineCapacity"));
            int horsepower = Integer.parseInt(request.getParameter("horsepower"));
            Car.FuelType fuelType = Car.FuelType.valueOf(request.getParameter("fuelType"));
            String color = request.getParameter("color");

            car.setMake(make);
            car.setModel(model);
            car.setBodyStyle(bodyStyle);
            car.setEngineCapacity(engineCapacity);
            car.setHorsepower(horsepower);
            car.setFuelType(fuelType);
            car.setColor(color);

            carStorageService.editCar(UUID.fromString(request.getParameter("editUUID")), car);

            response.sendRedirect("cars");
            return;
        }

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
