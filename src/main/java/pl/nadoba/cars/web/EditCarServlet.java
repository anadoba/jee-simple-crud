package pl.nadoba.cars.web;

import pl.nadoba.cars.service.CarStorageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Gets the edited car UUID and passes it to the jsp
 */
@WebServlet("/edit")
public class EditCarServlet extends HttpServlet {

    private CarStorageService carStorageService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        carStorageService = (CarStorageService) getServletContext().getAttribute("carStorageService");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editCar.jsp");
        request.setAttribute("car", carStorageService.getCar(UUID.fromString(request.getParameter("uuid"))));
        requestDispatcher.include(request, response);
    }

    @Override
    public void init() throws ServletException {
        if (getServletContext().getAttribute("carStorageService") == null)
            getServletContext().setAttribute("carStorageService", new CarStorageService());
    }
}
