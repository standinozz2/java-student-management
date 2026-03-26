package kouka;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/kouka/Register"})
public class Register extends HttpServlet {
	
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException,IOException {
	//(register.jsp)へフォワード
	request.getRequestDispatcher("register.jsp")
	.forward(request, response);
	}
}