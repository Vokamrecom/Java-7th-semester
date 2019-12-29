import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.StringReader;
import javax.inject.Inject;

@ServerEndpoint("/actions")
public class webSocket {
    Thread thread;
    ThreadHelper threadHelper = new ThreadHelper();

    @OnOpen
    public void open(Session session) {
    }

    @OnClose
    public void close(Session session) {
    }

    @OnError
    public void onError(Throwable error) {
    }

    @OnMessage
    public void handleMessage(String message, Session session) {
        if ("start".equals(message)) {
            KillThread();
            CreateThread(session);
        }
        if ("stop".equals(message)) {
            KillThread();
        }
    }

    private void CreateThread(Session session) {
        threadHelper = new ThreadHelper();
        thread = (new Thread(new MyThread(session, threadHelper)));
        thread.start();
    }

    private void KillThread() {
        if (thread != null && !threadHelper.isKilled) {
            threadHelper.isKilled = true;
            thread.interrupt();
        }
    }
}
