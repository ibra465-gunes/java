package component;

import event.EventMenuSelected;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;
import swing.ButtonCustom;
import swing.MenuItem;

public class Menu extends javax.swing.JPanel {

    public void setEvent(EventMenuSelected event) {
        this.event = event;
    }
    private MigLayout layout;
    private JPanel panelMenu;
    private JButton cmdMenu;
    private JButton cmdLogOut;
    private Header header;
    public static String name;
    private Bottom bottom;
    private EventMenuSelected event;

    public Menu() {
        initComponents();
        setOpaque(false);
        init();

    }

    private void init() {
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "5[]0[]push[60]0"));
        panelMenu = new JPanel();
        Bottom.main(Menu.name);
        header = new Header();
        bottom = new Bottom();
        createButtonMenu();
        createButtonLogout();
        panelMenu.setOpaque(false);
        layout = new MigLayout("fillx, wrap", "0[fill]0", "0[]3[]0");
        panelMenu.setLayout(layout);
        add(cmdMenu, "pos 1al 0al 100% 50");
        add(cmdLogOut, "pos 1al 1al 100% 100, height 60!");
        add(header);
        add(panelMenu);
        add(bottom);

    }

    public void addMenu(ModelMenu menu) {
        MenuItem item = new MenuItem(menu.getIcon(), menu.getMenuName(), panelMenu.getComponentCount());
        item.addEvent(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                clearMenu(index);
            }
        });
        item.addEvent(event);
        panelMenu.add(item);
    }

    private void createButtonMenu() {
        cmdMenu = new JButton();
        cmdMenu.setContentAreaFilled(false);
        cmdMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMenu.setIcon(new ImageIcon(getClass().getResource("/icon/menu.png")));
        cmdMenu.setBorder(new EmptyBorder(5, 12, 5, 12));
    }

    private void createButtonLogout() {
        cmdLogOut = new ButtonCustom();
        cmdLogOut.setIcon(new ImageIcon(getClass().getResource("/icon/exit.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(215, 512));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gra2d = (Graphics2D) g;
        GradientPaint gra = new GradientPaint(0, 0, new Color(33, 114, 220), 0, getHeight(), Color.BLACK);
        gra2d.setPaint(gra);
        gra2d.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    private void clearMenu(int exceptIndex) {
        for (Component com : panelMenu.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.getIndex() != exceptIndex) {
                item.setSelected(false);
            }
        }
    }

    public void addSubMenu(ModelMenu menu, int count,int index) {

        JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, inset 0, gapy 0", "fill"));
        panel.setOpaque(false);
        MenuItem subItem = new MenuItem(menu.getIcon(), menu.getMenuName(), panelMenu.getComponentCount());
        if (count == 0) {

            subItem.addEvent(new EventMenuSelected() {
                @Override
                public void selected(int index) {
                    clearMenu(index);
                }
            });
            if(index==2){
            panelMenu.add(subItem, index);
            }else if(index==3){
                panelMenu.add(subItem, index);
            }
        } else if(count==1) {
            panelMenu.remove(index);
        }
        subItem.addEvent(event);
        revalidate();
        repaint();
    }

    public void addEventMenu(ActionListener event) {
        cmdMenu.addActionListener(event);
    }

    public void addEventLogout(ActionListener event) {
        cmdLogOut.addActionListener(event);
    }

    public void setAlpha(float alpha) {
        header.setAlpha(alpha);
        bottom.setAlpha(alpha);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
