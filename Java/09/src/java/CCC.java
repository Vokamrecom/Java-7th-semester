package Lab9;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class CCC extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log("service");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CCC</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>Servlet CCC at " + request.getContextPath() + "</div>");
        out.println("</body>");
        out.println("</html>");
    }

    public void init() {
        log("init");
    }

    public void destroy() {
        log("destroy");
    }

    public void log(String msg) {
        System.out.println("CCC:" + msg);
    }
}
