package main;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/priv")
public class DegreesFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String encoding = request.getCharacterEncoding();

        if (!"UTF-8".equalsIgnoreCase(encoding))
            response.setCharacterEncoding("UTF-8");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String degreesStr = httpRequest.getParameter("degrees");
        String radiansStr = httpRequest.getParameter("radians");

        RequestDispatcher dispatcher;

        if (degreesStr != null) {
            dispatcher = request.getRequestDispatcher("/degrees?degrees=" + degreesStr);
            dispatcher.forward(request, response);
        } else if (radiansStr != null) {
            dispatcher = request.getRequestDispatcher("/radians?radians=" + radiansStr);
            dispatcher.forward(request, response);
        } else {
            httpResponse.setContentType("text/html");
            httpResponse.getWriter().println("<h1>ОшибОчка</h1>");
        }
    }


    public void destroy() {
    }

}