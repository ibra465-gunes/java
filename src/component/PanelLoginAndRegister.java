package component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.ModelAdmin;
import net.miginfocom.swing.MigLayout;
import swing.MyPasswordField;
import swing.MyTextField;
import swing.Button;
import java.util.StringTokenizer;
import model.ModelAdminRegister;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    private ModelAdmin admin;
    private ModelAdminRegister adminRegister;
    public ModelAdminRegister getAdminRegister() {
        return adminRegister;
    }
    
    public ModelAdmin getAdmin() {
        return admin;
    }
    private ActionListener event;

    public PanelLoginAndRegister(ActionListener eventLogin,ActionListener eventRegister) {
        initComponents();
        initLogin(eventLogin);
        initRegister(eventRegister);
        login.setVisible(true);
        register.setVisible(false);
        
    }
    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]10[]25[]push"));
        JLabel label = new JLabel("Yönetici Kayıt");
        label.setFont(new Font("arial", 1, 30));
        label.setForeground(new Color(33, 114, 220));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUser.setHint("Yeni yönetici adı ve soyadı");
        register.add(txtUser, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Yeni yönetici şifresi");
        register.add(txtPass, "w 60%");
        MyTextField txtAdminName = new MyTextField();
        txtAdminName.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/admin.png")));
        txtAdminName.setHint("Yönetici adı ve soyadı");
        register.add(txtAdminName, "w 60%");
        MyPasswordField txtAdminPass = new MyPasswordField();
        txtAdminPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtAdminPass.setHint("Yönetici şifresi");
        register.add(txtAdminPass, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(33, 114, 220));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setFont(new Font("arial", 1, 13));
        cmd.addActionListener(eventRegister);
        cmd.setText("Kayıt");
        register.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = txtUser.getText();
                StringTokenizer st = new StringTokenizer(temp," ");
                String name = st.nextToken();
                String surname = st.nextToken();
                String password = String.valueOf(txtPass.getPassword());
                String temp1 = txtAdminName.getText();
                StringTokenizer st1 = new StringTokenizer(temp1," ");
                String adminName = st1.nextToken();
                String adminSurname = st1.nextToken();
                String adminPassword = String.valueOf(txtAdminPass.getPassword());
                adminRegister = new ModelAdminRegister(adminName,adminSurname,adminPassword);
                admin = new ModelAdmin(name,surname,password);
            }
            
        });
        

    }

    private void initLogin(ActionListener eventLogin) {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Yönetici Giriş");
        label.setFont(new Font("arial", 1, 30));
        label.setForeground(new Color(33, 114, 220));
        login.add(label);
        MyTextField txtAdminName = new MyTextField();
        txtAdminName.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/admin.png")));
        txtAdminName.setHint("Yönetici adı ve soyadı");
        login.add(txtAdminName, "w 60%");
        MyPasswordField txtAdminPass = new MyPasswordField();
        txtAdminPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtAdminPass.setHint("Yönetici şifresi");
        login.add(txtAdminPass, "w 60%");
        Button cmdForget = new Button();
        cmdForget.setText("Forgot your password ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("arial", 1, 12));
        cmdForget.setContentAreaFilled(false);//Özelliği ayarlar
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        Button cmd = new Button();
        cmd.setBackground(new Color(33, 114, 220));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setFont(new Font("arial", 1, 13));
        cmd.addActionListener(eventLogin);
        cmd.setText("Giriş");
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = txtAdminName.getText();
                StringTokenizer st = new StringTokenizer(temp," ");
                String name = st.nextToken();
                String surName = st.nextToken();
                String password = String.valueOf(txtAdminPass.getPassword());
                admin = new ModelAdmin(0, name,surName, password);
            }
        });
    }

    public void showLogin(boolean show) {
        if (show) {
            register.setVisible(false);
            login.setVisible(true);
        } else {
            register.setVisible(true);
            login.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        add(login, "card2");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        add(register, "card3");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
