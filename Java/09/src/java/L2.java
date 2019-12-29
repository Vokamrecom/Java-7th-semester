package Lab9;

import static java.lang.System.console;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class L2 implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log("session initialized");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log("session destroyed");
    }

    public void log(String msg) {
        System.out.println("L2:" + msg);
    }
}
