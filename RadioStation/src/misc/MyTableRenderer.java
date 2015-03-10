package misc;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import pojos.Album;


public class MyTableRenderer extends DefaultTableCellRenderer {


@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row,int col) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

    if (value instanceof Album) {
        Album alb = (Album) value;
        if (alb.getArtistid() != null) 
            setText(alb.getArtistid().getArtisticname()+" "+
                    alb.getArtistid().getLastname()+" "+
                    alb.getArtistid().getFirstname());

        else setText(alb.getMusicgroupid().getName());

    }

    return this;
}
}