import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class Listener2 implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public Listener2() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context Initialized 2");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed 2");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session created 2");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroyed 2");
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("Attribute Added 2");
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("Attribute Removed 2");
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("Attribute Replaced 2");
    }
}
