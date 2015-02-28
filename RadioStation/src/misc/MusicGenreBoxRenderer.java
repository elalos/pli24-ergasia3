package misc;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import pojos.MusicGenre;

public class MusicGenreBoxRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof MusicGenre) {
            MusicGenre g = (MusicGenre) value;
            setText(g.getName());
        }
        return this;
    }
}