
package component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Message extends javax.swing.JPanel {
    private MessageType messageType = MessageType.SUCCESS;
    private boolean show;

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
    
    public Message() {
        initComponents();
        setOpaque(false);
    }
    public void showMessage(MessageType messageType, String message){
        this.messageType = messageType;
        lbMessage.setText(message);
        if(messageType==MessageType.SUCCESS){
            lbMessage.setIcon(new ImageIcon(getClass().getResource("/icon/success.png")));
        }else {
            lbMessage.setIcon(new ImageIcon(getClass().getResource("/icon/error.png")));
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMessage = new javax.swing.JLabel();

        lbMessage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(255, 255, 255));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gra2d = (Graphics2D)g;
        if(messageType == MessageType.SUCCESS){
            gra2d.setColor(new Color(15,174,37));
        }else{
            gra2d.setColor(new Color(240,52,53));
        }
        gra2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.9f));
        gra2d.fillRect(0, 0, getWidth(), getHeight());
        gra2d.setComposite(AlphaComposite.SrcOver);
        gra2d.setColor(new Color(245,245,245));
        gra2d.drawRect(0, 0, getWidth()-1, getHeight()-1);
        super.paintComponent(g); 
    }
    
    public static enum MessageType{
        SUCCESS, ERROR
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbMessage;
    // End of variables declaration//GEN-END:variables
}
