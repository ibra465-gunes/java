package component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.StringTokenizer;
import javax.swing.JLabel;

import form.Form1;
import menu.MenuPage;


public class Bottom extends javax.swing.JPanel {
    private float alpha;
    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
    public static String na;
    public static String na1;
    public static String na2;
    public Bottom() {
        initComponents();
        setOpaque(false);
        setBackground(Color.BLACK);
        name.setForeground(Color.WHITE);
        Bottom.main(na);
        name.setText(Bottom.na);
    }
    public static void main(String nam){
        Bottom.na=nam;

    }
    @Override
    public void paint(Graphics g) {
        Graphics2D gra2d = (Graphics2D) g;
        gra2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gra2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        gra2d.setColor(getBackground());
        gra2d.fillRoundRect(5, 5, getWidth()-10, getHeight()-10, 20, 20);
        super.paint(g);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new swing.ImageAvatar();
        name = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        imageAvatar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/admin2.png"))); // NOI18N

        name.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Yönetici");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name)
                    .addComponent(jLabel1))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
