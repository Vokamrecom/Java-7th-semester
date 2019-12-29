package Lab9;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.http.HttpSessionListener;

public class L3 implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent e) {
        System.out.println("L3:attributeAdded:AtributeName= " + e.getName());
        System.out.println("L3:attributeAdded:AtributeValue " + e.getValue());

    }

    public void attributeRemoved(ServletContextAttributeEvent e) {
        System.out.println("L3:attributeRemoved:AtributeName= " + e.getName());
        System.out.println("L3:attributeRemoved:AtributeValue " + e.getValue());
    }

    public void attributeReplaced(ServletContextAttributeEvent e) {
        System.out.println("L3:attributeReplaced:AtributeName=" + e.getName());
        System.out.println("L3:attributeReplaced:AtributeOldValue " + e.getValue());
        ServletContext sc = e.getServletContext();
        System.out.println("L3:attributeReplaced:AtributeNewValue " + sc.getAttribute(e.getName()));
    }
}