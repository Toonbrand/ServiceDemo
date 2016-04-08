package nl.youngcapital.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RekenAfhandel
 */
@WebServlet("/d")
public class RekenAfhandel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RekenAfhandel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<html><head><title>hallo</title></head><link rel=stylesheet href=style.css><body>");
		response.getWriter().append("<h1>Reken pagina</h1>");
		try{
			Double value1 = Double.parseDouble(request.getParameter("val1"));
			Double value2 = Double.parseDouble(request.getParameter("val2"));
			String choice = request.getParameter("choice");

			response.getWriter().append("<br>De uitkomst is: ");
			if(choice.equals("minus")){
				response.getWriter().append("<h3>" + (value1 - value2) + "</h3>");
			}
			else if(choice.equals("plus")){
				response.getWriter().append("<h3>" + (value1 + value2) + "</h3>");
			}
		}
		catch(NumberFormatException nfe){
			response.getWriter().append("<h3>Voer alleen getallen in</h3>");
		}



		response.getWriter().append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
