package kouka;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/kouka/menu"})
public class Menu extends HttpServlet {
	public void doGet(
			HttpServletRequest request,HttpServletResponse response
			) throws ServletException,IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		//(menu.jsp）へフォワード
		request.getRequestDispatcher("menu.jsp")
		.forward(request, response);
	} 
}