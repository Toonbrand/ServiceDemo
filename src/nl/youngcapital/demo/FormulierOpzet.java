package nl.youngcapital.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/a")
public class FormulierOpzet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static String theme;

	public void init(){
		this.theme = "theme1";
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormulierOpzet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<html><head><title>hallo</title></head>");

		Cookie whichTheme = new Cookie("which_theme", request.getParameter("theme"));
		whichTheme.setMaxAge(60*60*24);
		response.addCookie(whichTheme);

		//haal thema op
		if(request.getParameter("theme") != null){
			theme = request.getParameter("theme");
		}

		System.out.println(theme);
		//selecteer thema
		switch(theme){
		case "theme1" : response.getWriter().append("<link rel=stylesheet href=style.css><body>");
		break;
		case "theme2" : response.getWriter().append("<link rel=stylesheet href=style2.css><body>");
		break;
		case "theme3" : response.getWriter().append("<link rel=stylesheet href=style3.css><body>");
		}

		//lees cookie
		theme = whichTheme.getValue();
		System.out.println("Cookie value:" + whichTheme.getValue());

		//laat formulier zien

		if(whichTheme.getValue() == null){
			response.getWriter().append("<form method=get ><label for=theme>Theme:</label><select name=theme><option value=theme1>Theme1</option><option value=theme2>Theme2</option><option value=theme3>Patrick</option></select><br><input type=submit class=button value=set theme></form>");
		}

		response.getWriter().append("<form method=get action=b><label for=user>Username:</label><input type=text name=user><br><label for=pwd>Password:</label><input type=password name=pwd><br><input type=submit class=button value=submit></form>");
		response.getWriter().append("<form method=get action=asdf><label for=status>Status code:<br></label><input type=radio name=status value=200>200<br><input type=radio name=status value=400>400<br><input type=radio name=status value=404>404<br><input type=radio name=status value=418>418<br><input type=radio name=status value=500>500<br><input type=submit class=button value=check></form>");
		response.getWriter().append("<form method=get action=d><label for=val1>Value1:</label><input type=text name=val1><br><select name=choice><option value=minus>Minus</option><option value=plus>Plus</option></select></br><label for=val2>Value2:</label><input type=text name=val2><br><input type=submit class=button value=calculate></form>");
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
