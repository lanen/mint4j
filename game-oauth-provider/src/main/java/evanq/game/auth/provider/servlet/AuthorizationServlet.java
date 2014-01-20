package evanq.game.auth.provider.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("authorize")
public class AuthorizationServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 667808529785678403L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	
}
