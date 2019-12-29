package Lab6;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class DDD extends HttpServlet {

    @Override
    public void init() throws ServletException {
        A obj = new A();
        obj.SetA(0);
        obj.SetB(0);
        obj.SetC(0);

        this.getServletContext().setAttribute("attribute", obj);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cBean = request.getParameter("CBean");
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        if ("new".equals(cBean)) {
            A newObject = new A();
            if (request.getParameter("A") != null) {
                newObject.SetA(Integer.parseInt(request.getParameter("A")));
            }

            if (request.getParameter("B") != null) {
                newObject.SetB(Integer.parseInt(request.getParameter("B")));
            }

            if (request.getParameter("C") != null) {
                newObject.SetC(Integer.parseInt(request.getParameter("C")));
            }

            setValue(type, request, newObject, response);
        } else {
            A oldValue = null;
            if (type.equals("session")){
                oldValue = (A) (session.getAttribute("attribute"));
            }else {
                oldValue = (A) (this.getServletContext().getAttribute("attribute"));
            }
             

            if (request.getParameter("A") != null) {
                oldValue.SetA(Integer.parseInt(request.getParameter("A")));
            }

            if (request.getParameter("B") != null) {
                oldValue.SetB(Integer.parseInt(request.getParameter("B")));
            }

            if (request.getParameter("C") != null) {
                oldValue.SetC(Integer.parseInt(request.getParameter("C")));
            }
            setValue(type, request, oldValue, response);
        }
    }

    private void setValue(String type, HttpServletRequest request, A obj, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        if ("session".equals(type)) {
            HttpSession session = request.getSession();
            session.setAttribute("attribute", obj);

            rd = request.getRequestDispatcher("/Session.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("attribute", obj);
            this.getServletContext().setAttribute("attribute", obj);
            rd = request.getRequestDispatcher("/Context.jsp");
            rd.forward(request, response);
        }
    }
}
