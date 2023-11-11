package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/radians")
public class RadiansServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String radiansStr = request.getParameter("radians");

        double radians = Double.parseDouble(radiansStr);
        double degrees = Math.toDegrees(radians);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);

        response.setContentType("text/html");

        response.getWriter().println("угол: " + degrees);
        response.getWriter().println("sin: " + sin);
        response.getWriter().println("cos: " + cos);

    }
}