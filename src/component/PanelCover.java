package component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import swing.ButtonOutLine;


public class PanelCover extends javax.swing.JPanel {
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private ActionListener event;
    private MigLayout layout;
    private JLabel title;
    private JLabel text1;
    private JLabel text2;
    private JLabel text3;
    private ButtonOutLine button;
    private boolean isLogin;
    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]","push[]25[]10[]25[]push");
        setLayout(layout);
        init();
        
    }
    private void init(){
        title = new JLabel("Hoş Geldiniz");
        title.setFont(new Font("arial",1,30));
        title.setForeground(new Color(245,245,245));
        add(title);
        text1 = new JLabel("\"Personel bilgilerini ilgili olmayan kişiler ile paylaşmayın\"");
        text1.setForeground(new Color(245,245,245));
        text1.setFont(new Font("arial",1,15));
        add(text1);
        text2 = new JLabel("\"İyi Çalışmalar\"");
        text2.setForeground(new Color(245,245,245));
        text2.setFont(new Font("arial",1,15));
        add(text2);
        button = new ButtonOutLine();
        button.setBackground(new Color(255,255,255));
        button.setForeground(new Color(255,255,255));
        button.setText("Kayıt");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                event.actionPerformed(e);
            }
            
        });
        add(button,"w 60%, h 40");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gra2D = (Graphics2D) g;
        GradientPaint gra = new GradientPaint(0, 0, new Color(33,114,220), 0, getHeight(), Color.black);
        gra2D.setPaint(gra);
        gra2D.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g); 
        
    }
    public void addEvent(ActionListener event){
        this.event = event;
    }
    public void registerLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(text1, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(text2, "pad 0 -" + v + "% 0 0");
    }

    public void registerRight(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(text1, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(text2, "pad 0 -" + v + "% 0 0");
    }

    public void loginLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(text1, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(text2, "pad 0 " + v + "% 0 " + v + "%");
    }

    public void loginRight(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(text1, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(text2, "pad 0 " + v + "% 0 " + v + "%");
    }
    public void login(boolean login){
        if(this.isLogin != login){
            if(login){
                title.setText("Hoş Geldiniz");
                text1.setText("\"Personel bilgi sistemine yönetici şifresi ile kayıt olun\"");
                button.setText("Giriş");
            }
            else{
                title.setText("Hoş Geldiniz");
                text1.setText("\"Personel bilgilerini ilgili olmayan kişiler ile paylaşmayın\"");
                button.setText("Kayıt");
            }
            this.isLogin = login;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
