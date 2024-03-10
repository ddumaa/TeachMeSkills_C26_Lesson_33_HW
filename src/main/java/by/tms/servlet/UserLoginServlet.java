package by.tms.servlet;

import by.tms.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();

        Connection connection =
                null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "NetLove62");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from account");

            while (resultSet.next()) {
                long idU = resultSet.getLong(1);
                String nameU = resultSet.getString(2);
                String usernameU = resultSet.getString(3);
                String passwordU = resultSet.getString(4);

                if (password.equals(passwordU) && username.equals(usernameU)) {
                    user.setUsername(usernameU);
                    user.setName(nameU);
                    user.setId(idU);
                    req.getSession().setAttribute("user", user);

                    resp.sendRedirect("/home");
                }
            } if (req.getSession() == null){
                req.setAttribute("message", "Wrong password!");
                getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}