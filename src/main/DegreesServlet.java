package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/degrees")
public class DegreesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String degreesStr = request.getParameter("degrees");
        double degrees = Double.parseDouble(degreesStr);
        double radians = Math.toRadians(degrees);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);

        response.setContentType("text/html");
        response.getWriter().println("<h1>Результаты расчета:</h1>");
        response.getWriter().println("Градусы: " + degrees);
        response.getWriter().println("Радианы: " + radians);
        response.getWriter().println("Синус: " + sin);
        response.getWriter().println("Косинус: " + cos);

    }
}