package ua.nure.kn156.kazakova.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.kn156.kazakova.User;
import ua.nure.kn156.kazakova.db.DAOFactory;
import ua.nure.kn156.kazakova.db.DatabaseException;


public class AddServlet extends EditServlet {

    protected void processUser(User user) throws DatabaseException {
        DAOFactory.getInstance().getUserDao().create(user);
    }

    protected void showPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }
}
