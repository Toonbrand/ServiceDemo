package nl.youngcapital.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HogerLagerGame
 */


@WebServlet("/HogerLagerGame")
public class HogerLagerGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static int secret;
	static int tries;
	static String input;

	public void init(){
		this.secret = (int)(Math.random()*101);
		System.out.println(secret);
		this.tries = 0;
		this.input = null;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HogerLagerGame() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<html><head><title>hallo</title></head><link rel=stylesheet href=style.css><body>");
		response.getWriter().append("<form method=get ><label for=guess>Guess a number:</label><br><input type=text name=guess autofocus><br><br><input type=submit class=button value=submit></form>");
		
		if(request.getParameter("opnieuw") != null){
			secret = (int)(Math.random()*101);
			System.out.println(secret);
			tries = 0;
		}
		
		
		try{
			input = request.getParameter("guess");
			if(input != null){
				int numberInput = Integer.parseInt(input);
				
				if(numberInput == secret){
					response.getWriter().append("<h1>Good guess!</h1>");
					response.getWriter().append("<form method=get ><input type=submit class=button value=Again name=opnieuw></form>");
				}
				else if(numberInput < secret){
					response.getWriter().append("<h3>Higher</h3>");
				}
				else if(numberInput > secret){
					response.getWriter().append("<h3>Lower</h3>");
				}
				
				tries++;
			}

		}
		catch(NumberFormatException nfe){
			response.getWriter().append("<h3>Voer alleen getallen in</h3>");
		}

		response.getWriter().append("<p>Tries: " + tries + "</p>");
		response.getWriter().append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
