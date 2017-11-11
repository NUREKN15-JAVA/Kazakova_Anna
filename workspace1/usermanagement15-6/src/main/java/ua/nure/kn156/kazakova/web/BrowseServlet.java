package ua.nure.kn156.kazakova.web;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.kn156.kazakova.db.DAOFactory;
import ua.nure.kn156.kazakova.db.DatabaseException;

public class BrowseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 browse(req, resp);
	}

	private void browse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 Collection users;
	        try {
	            users = DAOFactory.getInstance().getUserDao().findAll();
	            req.getSession().setAttribute("users", users);
	            req.getRequestDispatcher("/browse.jsp").forward(req, resp);
	        } catch (DatabaseException e) {
	            throw new ServletException(e);
	        }
		
		
	}

		
}
