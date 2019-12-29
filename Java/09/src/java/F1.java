package Lab9;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

public class F1 implements Filter {
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        log("DoBeforeProcessing");
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        log("DoAfterProcessing");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log("doFilter");
        doBeforeProcessing(request, response);
        if (getRandomBoolean()){
            log("error");
            HttpServletResponse httpresponse = (HttpServletResponse) response;
            httpresponse.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            chain.doFilter(request, response);
        }
        doAfterProcessing(request, response);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        log("setFilterConfig");
    }

    public void destroy() {
        log("destroy");
    }

    public void init(FilterConfig filterConfig) {
        log("init");
    }

    public void log(String msg) {
        System.out.println("F1:" + msg);
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.3;
        // I tried another approaches here, still the same result
    }
}
