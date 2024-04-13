package main;

import component.Bottom;
import component.Message;
import component.PanelCover;
import component.PanelLoginAndRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import log.Logger;
import menu.MenuPage;
import model.ModelAdmin;
import model.ModelAdminRegister;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import service.ServiceAdmin;

public class Main extends javax.swing.JFrame {
    private MenuPage menu = new MenuPage();
    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));

    public Main() {
        initComponents();
        init();
    }

    public void init() {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        };
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        };
        loginAndRegister = new PanelLoginAndRegister(eventLogin,eventRegister);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginAndRegister.showLogin(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                jLayeredPane1.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }

        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        jLayeredPane1.setLayout(layout);
        jLayeredPane1.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        jLayeredPane1.add(loginAndRegister, "width " + loginSize + "%, pos 1al 0 n 100%");
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }

        });
    }
    private void register(){
        ModelAdminRegister adminRegister = loginAndRegister.getAdminRegister();
        ModelAdmin admin = loginAndRegister.getAdmin();
        ServiceAdmin service = new ServiceAdmin();
        Logger log = new Logger();
        int a = service.readFileForRegister(adminRegister);
        
        if(a==1){
            String phrease = new String(adminRegister.getAdminRName()+" "+adminRegister.getAdminRSurname()+" Kayıt");
            log.logger(phrease);
            service.writeRegister(admin);
            showMessage(Message.MessageType.SUCCESS, "Kayıt Başarılı");
        }else
            showMessage(Message.MessageType.ERROR, "Kayıt Hatalı");
    }
    private void login() {
        ModelAdmin admin = loginAndRegister.getAdmin();
        ServiceAdmin service = new ServiceAdmin();
        MenuPage menu = new MenuPage();
        Logger log = new Logger();
 
        int a = service.readFile(admin);
        if(a==1){
            String phrease = new String(admin.getName()+" "+admin.getSurname()+" Giriş");
            String phrease1 = new String(admin.getName()+" "+admin.getSurname());
            log.logger(phrease);
            showMessage(Message.MessageType.SUCCESS, "Giriş Başarılı");
            this.dispose();
            MenuPage.main(phrease1);
        }else
            showMessage(Message.MessageType.ERROR, "Giriş Hatalı");
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1013, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void showMessage(Message.MessageType messageType, String message) {
        Message m = new Message();
        m.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!m.isShow()) {
                    jLayeredPane1.add(m);//, "pos 0.5al -30", 0); //  Insert to bg fist index 0
                    m.setVisible(true);
                    jLayeredPane1.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (m.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(m, "pos 0.5al " + (int) (f - 30));
                jLayeredPane1.repaint();
                jLayeredPane1.revalidate();
            }

            @Override
            public void end() {
                if (m.isShow()) {
                    jLayeredPane1.remove(m);//Belirtilen dizindeki bileşeni bu açılır menüden kaldırır.
                    jLayeredPane1.repaint();//Sayfayı yeniden tasarlamaya yarar.
                    jLayeredPane1.revalidate();
                } else {
                    m.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    animator.start();
                }catch(InterruptedException e){
                    System.err.println(e);
                }
            }
        }).start();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
