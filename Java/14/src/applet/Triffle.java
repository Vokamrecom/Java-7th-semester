package applet;

import java.applet.Applet;
import java.awt.*;

public class Triffle extends Applet {
    String text = "";

    public void init() {
        setBackground(Color.yellow);
        setForeground(Color.red);
        text += "init--";
    }

    public void start() {
        text += "start--";
    }

    public void stop() {
        text += "stop--";
    }

    public void destroy() {
        text += "destroy--";
    }

    public void paint(Graphics graphics) {
        text += "paint--";
        graphics.drawString(text, 10, 50);
    }
}
