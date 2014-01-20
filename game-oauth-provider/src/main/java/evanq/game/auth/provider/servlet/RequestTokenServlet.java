package evanq.game.auth.provider.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("request_token")
public class RequestTokenServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 27620324696033727L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.getWriter().write("hellsso");
	}
}
