package by.tms.servlet;

import by.tms.model.Operation;
import by.tms.model.User;
import by.tms.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(value = "/history", name = "UserHistoryServlet")
public class UserHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        List<String> history = new ArrayList<>();

        Connection connection =
                null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "NetLove62");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from archive_operation");

            while (resultSet.next()) {
                String operation = resultSet.getString(1);
                long id = resultSet.getLong(3);

                if (user.getId() == id) {
                    history.add(operation);
                }
            } if (!history.isEmpty()){
                req.setAttribute("history", history);
                getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
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