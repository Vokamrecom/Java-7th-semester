import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/QueryProcedure")
public class QueryProcedure extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        PrintWriter printWriter = httpServletResponse.getWriter();

        String paramValue = httpServletRequest.getParameter("procedureValue");
        String queryProcedure = "{ CALL lb10Procedure(?,?)}";

        ConnectionDataBase connectionDataBase = null;
        CallableStatement callableStatement = null;

        try {
            connectionDataBase = new ConnectionDataBase();
            callableStatement = (CallableStatement) connectionDataBase.getConnection().prepareCall(queryProcedure);
            callableStatement.setString(1, paramValue);
            callableStatement.setString(2, paramValue);
            callableStatement.execute();

            printWriter.println("Data entered!");
            printWriter.println("\nValue: " + paramValue);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert callableStatement != null;
                callableStatement.close();
                connectionDataBase.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
