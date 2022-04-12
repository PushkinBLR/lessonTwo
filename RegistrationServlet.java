package servlet;

import Service.RegistrationService;
import dao.UserDAOImpl;
import entity.User;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Model;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    private final RegistrationService registrationService = new RegistrationService();
    private final UserDAOImpl userdaoimpl = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/registration.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");

        User user = new User(login, password,lastname, firstname);
        Model model = Model.getInstance();
        model.add(user);
        request.setAttribute("login", login);
        doGet(request, response);

        try {
            registrationService.createUser(new User(login,password,lastname,firstname));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        response.sendRedirect("/");
            request.setAttribute("message","Login done");
        }

}
