import java.applet.Applet;
import java.awt.*;

public class Trifle extends Applet {
  private String str = "";

  public void init() {
    str += "-init-";
    setBackground(Color.GREEN);
    setForeground(Color.BLUE);
  }

  public void start() {
    str += "-start-";
  }

  public void stop() {
    str += "-stop-";
  }

  public void destroy() {
    str += "-destroy-";
  }

  public void paint(Graphics g) {
    str += "paint";
    g.drawString(str, 10, 50);
  }


}
