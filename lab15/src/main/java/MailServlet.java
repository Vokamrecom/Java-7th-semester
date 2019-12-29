import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;

@WebServlet(name = "mail", urlPatterns = "/mail")
public class MailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        String eMailAddressTo = "ermakovkiril@gmail.com";
        String eMailMessage = request.getParameter("message");
        String eMailMessageSubject = context.getInitParameter("eMailMessageSubject");
        final String eMailPasswordFrom = "steudent.bgtu@gmail.com";
        final String eMailAddressFrom = context.getInitParameter("eMailAddressFrom");

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(eMailAddressFrom, ".System99");
            }
        };
        Session session = Session.getInstance(props, auth);

        MailSender.sendEmail(session, eMailAddressTo, eMailMessageSubject, eMailMessage);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ServletContext context = req.getServletContext();
            String username = context.getInitParameter("eMailAddressTo");
            String password = context.getInitParameter("eMailPasswordFrom");
            String result = MailSender.getMessages(username, password);

            resp.getWriter()
                    .println(result);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
