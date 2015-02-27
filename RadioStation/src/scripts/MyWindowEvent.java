package scripts;

import java.awt.Window;
import java.awt.event.WindowEvent;

public class MyWindowEvent extends WindowEvent{
    public boolean exitAndSave;
    public MyWindowEvent(Window source, int id, boolean exitAndSave) {
        super(source, id);
        this.exitAndSave = exitAndSave;
    }
}
