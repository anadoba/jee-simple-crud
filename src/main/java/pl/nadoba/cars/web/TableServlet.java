package pl.nadoba.cars.web;

import pl.nadoba.cars.service.CarStorageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet, which handles the display part mostly
 */

@WebServlet("/cars")
public class TableServlet extends HttpServlet {

    CarStorageService carStorageService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        carStorageService = (CarStorageService) getServletContext().getAttribute("carStorageService");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cars.jsp");
        request.setAttribute("carsDB", carStorageService.getMap().values());

        requestDispatcher.include(request, response);
    }

    @Override
    public void init() throws ServletException {
        if (getServletContext().getAttribute("carStorageService") == null)
            getServletContext().setAttribute("carStorageService", new CarStorageService());


    }
}
