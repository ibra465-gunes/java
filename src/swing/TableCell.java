package swing;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TableCell extends JLabel {

    private final CellType cellType;
    private boolean selected;

    public TableCell(Object obj) {
        setFont(new Font("arial", 1, 12));
        this.cellType = CellType.EMPTY;
        if (obj != null) {
            setText(obj.toString());
        }
        setBorder(new EmptyBorder(10,10,10,10));
        setForeground(new Color(80,80,80));
    }

    public TableCell(Object obj, boolean selected, CellType cellType) {
        this.cellType = null;
        this.selected = selected;
        if(obj != null){
            setText(obj.toString());
        }
        setBorder(new EmptyBorder(10,10,10,10));
        setForeground(new Color(80,80,80));
    }

    public static enum CellType {
        LEFT, RIGHT, CENTER, EMPTY
    }
}
