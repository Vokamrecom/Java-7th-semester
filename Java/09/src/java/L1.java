package Lab9;

import static java.lang.System.console;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class L1 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log("context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log("context destroyed");
    }

    public void log(String msg) {
        System.out.println("L1:" + msg);
    }
}
