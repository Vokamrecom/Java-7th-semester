import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class Listener1 implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public Listener1() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context Initialized 1");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed 1");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session created 1");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroyed 1");
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("Attribute Added 1");
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("Attribute Removed 1");
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("Attribute Replaced 1");
    }
}
