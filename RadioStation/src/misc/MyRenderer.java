package misc;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import pojos.Artist;
import pojos.MusicGenre;
import pojos.MusicGroup;
import pojos.MusicProductionCompany;

public class MyRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof MusicGenre) {
            MusicGenre g = (MusicGenre) value;
            setText(g.getName());
        }
        if (value instanceof MusicGroup) {
            MusicGroup mg = (MusicGroup) value;
            setText(mg.getName());
        }
        if (value instanceof MusicProductionCompany) {
            MusicProductionCompany c = (MusicProductionCompany) value;
            setText(c.getName());
        }
        if (value instanceof Artist) {
            Artist a = (Artist) value;
            setText(a.getArtisticname()+" "+a.getLastname()+" "+a.getFirstname());
        }        
        return this;
    }
}