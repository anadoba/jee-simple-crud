package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspdemo.domain.Person;
import com.example.servletjspdemo.domain.Person.Education;
import com.example.servletjspdemo.domain.Person.Hobby;
import com.example.servletjspdemo.domain.Person.Sex;
import com.example.servletjspdemo.service.StorageService;

/**
 * Servlet implementation class ReceivedForm
 */
@WebServlet("/personData")
public class ReceivedForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StorageService storage = new StorageService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceivedForm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO zapisac do pamieci i ewentualnie wyswietlic
		// wykorzystac storage service
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String sex = request.getParameter("sex");
		String hobby = request.getParameter("hobby");
		String description = request.getParameter("opis");
		String education = request.getParameter("wyksztalcenie");
		
		Person newPerson = new Person(name, surname, Sex.valueOf(sex), Hobby.valueOf(hobby), description, Education.valueOf(education));
		
		storage.add(newPerson);
		
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append("<html><body><h2>Person</h2>")
			.append(storage.getAllPersonsInHTML())
			.append("</body></html>");
		out.println(sb);
		out.close();
		// potem sobie wyswietlic
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
