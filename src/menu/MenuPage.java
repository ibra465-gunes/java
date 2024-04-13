package menu;

import component.Bottom;
import component.Menu;
import event.EventMenuSelected;
import form.Form0;
import form.Form1;
import form.Form2;
import form.Form4;
import form.Form5;
import form.Form6;
import form.Form7;
import form.Form8;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MenuPage extends javax.swing.JFrame {

    private Menu menu = new Menu();
    private JPanel main = new JPanel();
    private MigLayout layout;
    private Animator animator;
    private boolean menuShow;
    public String bottomText;
    private int count = 0;

    public String getBottomText() {
        return bottomText;
    }

    public void setBottomText(String bottomText) {
        this.bottomText = bottomText;
    }

    public MenuPage() {
        initComponents();
        init();
    }

    private void init() {
        layout = new MigLayout("fill", "0[]10[]0", "0[fill]0");
        body.setLayout(layout);
        main.setOpaque(false);
        main.setLayout(new BorderLayout());
        menu.addEventLogout(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit(0);
            }
        });
        menu.addEventMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }

        });
        menu.setEvent(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    showForm(new Form1());
                } else if (index == 1) {
                    showForm(new Form2());
                } else if (index == 2) {
                    menu.addSubMenu(new ModelMenu("Yazılım", new ImageIcon(getClass().getResource("/icon/software.png"))), count, index + 1);
                    menu.addSubMenu(new ModelMenu("Yol yapım", new ImageIcon(getClass().getResource("/icon/road.png"))), count, index + 1);
                    menu.addSubMenu(new ModelMenu("Eğitim", new ImageIcon(getClass().getResource("/icon/education.png"))), count, index + 1);
                    menu.addSubMenu(new ModelMenu("Ekip gezisi", new ImageIcon(getClass().getResource("/icon/excursion.png"))), count, index + 1);
                    count++;
                }else if (index == 4){
                    if(count==1){
                        showForm(new Form5());
                    }
                }else if (index == 5){
                    if(count==1){
                        showForm(new Form6());
                    }
                } else if (index == 6){
                    if(count==1){
                        showForm(new Form7());
                    }
                } else if (index == 7){
                    if(count==1){
                        showForm(new Form8());
                    }
                } 
                else if (index == 3) {
                    showForm(new Form4());
                }
                if(count == 2){
                    count = 0;
                }
            }

        });
        menu.addMenu(new ModelMenu("Profil", new ImageIcon(getClass().getResource("/icon/admin1.png"))));
        menu.addMenu(new ModelMenu("Personel Bilgisi", new ImageIcon(getClass().getResource("/icon/staff.png"))));
        menu.addMenu(new ModelMenu("Projeler", new ImageIcon(getClass().getResource("/icon/project.png"))));
        menu.addMenu(new ModelMenu("Kayıt", new ImageIcon(getClass().getResource("/icon/log.png"))));
        body.add(menu, "w 50!");
        body.add(main, "w 100%");
        TimingTarget target;
        target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menuShow) {
                    width = 50 + (150 * (1f - fraction));
                    menu.setAlpha(1f - fraction);
                } else {
                    width = 50 + (150 * fraction);
                    menu.setAlpha(fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!");
                body.revalidate();
            }

            @Override
            public void end() {
                menuShow = !menuShow;
            }

        };
        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        showForm(new Form0());
    }

    private void showForm(Component com) {
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        body.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1088, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String bottomText) {
        MenuPage menuPage = new MenuPage();
        menuPage.setBottomText(bottomText);
        Menu.name = menuPage.getBottomText();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    // End of variables declaration//GEN-END:variables
}
