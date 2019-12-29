import javax.websocket.Session;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {
    private Session session;
    private ThreadHelper threadHelper;

    public MyThread() {
    }

    public MyThread(Session s, ThreadHelper th) {
        session = s;
        threadHelper = th;
    }

    public void run() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        while (!threadHelper.isKilled) {
            Date date = new Date();
            session.getAsyncRemote().sendText("{\"time\":\"" + dateFormat.format(date) + "\"}");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        (new MyThread()).start();
    }
}
