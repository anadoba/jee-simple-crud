package com.example.servletjspdemo.web;

import com.example.servletjspdemo.domain.Person;
import com.example.servletjspdemo.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/personForm")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("osoba") == null) {
			session.setAttribute("osoba", new Person());
		}

		Person person = (Person) session.getAttribute("osoba");

		StorageService ss = (StorageService) getServletContext().getAttribute("mojabaza");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();

		sb.append("<html><body><h2>Person Form</h2>")
				.append("<form action='personData'>")
				.append("Imie: <input type='text' name='name' value='" + person.getName() + "'/> <br />")
				.append("Nazwisko: <input type='text' name='surname' value='" + person.getSurname() + "'/> <br />")
				.append("Plec: <input type='radio' name='sex' value='male'>Mezczyzna<input type='radio' name='sex' value='female'>Kobieta")
				.append("<br>Hobby: <br><input type='checkbox' name='hobby' value='tv'>I like watching TV<br /><input type='checkbox' name='hobby' value='sport'>I like to exercise<br>")
				.append("Opis: <br> <textarea name='opis' value='" + person.getOpis() + "'> </textarea>")
				.append("<br>Wyksztalcenie: <select name='wyksztalcenie'> <option value='gimnazjalne'>gimnazjalne</option><br>")
				.append("<option value='zawodowe'>zawodowe</option><br><option value='srednie'>srednie</option><br>")
				.append("<option value='policealne'>policealne</option><br><option value='wyzsze'>wyzsze</option><br></select><br>")
				.append("<br><input type='submit' value=' Wyslij ' />")
				.append("</form>")
				.append("</body></html>");
		out.println(sb);
		out.close();


	}

	@Override
	public void init() throws ServletException {

		if (getServletContext().getAttribute("mojabaza") == null) {
			getServletContext().setAttribute("mojabaza", new StorageService());
		}

	}
}
