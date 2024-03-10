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


@WebServlet(value = "/calculator", name = "OperationServlet")
public class OperationServlet extends HttpServlet {

    private final OperationService service = new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String type = req.getParameter("type");
        Operation operation = new Operation();
        operation.setNum1(num1);
        operation.setNum2(num2);
        operation.setType(type);
        User author = (User) req.getSession().getAttribute("user");
        operation.setAuthor(author);
        Operation calculate = service.calculate(operation);
        req.setAttribute("operation", calculate);
        getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);
    }
}
