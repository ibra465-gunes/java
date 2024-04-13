package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class ButtonCustom extends JButton {
    
    public ButtonCustom() {
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gra2d = (Graphics2D)g;
        gra2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gra2d.setColor(getBackground());
        gra2d.fillRoundRect(10, 10, getWidth()-20, getHeight()-20, 20, 20);
        super.paintComponent(g); 
    }
    
}


