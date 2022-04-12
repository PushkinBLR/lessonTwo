package servlet;

import dao.UserDAOImpl;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class EntryServlet extends HttpServlet {
    private final UserDAOImpl userdaoimpl = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/entry.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        List<User> userByLogin = null;
        try {
            userByLogin = userdaoimpl.findAllUser();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        if (userByLogin.contains(login)) {
            User user = userByLogin.get(0);
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/");
                return;
            } else {
                request.setAttribute("message", "wrong password");
            }
        } else {
            request.setAttribute("message", "user not found");
        }
        getServletContext().getRequestDispatcher("/views/success.jsp").forward(request, response);
    }
}

