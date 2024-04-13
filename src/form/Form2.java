package form;

import component.Message;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import model.ModelPersonel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import service.ServicePersonel;
import swing.ButtonOutLine;
import swing.MyTextField1;
import swing.ScrollBar;

public class Form2 extends javax.swing.JPanel {

    CardLayout crd;
    MigLayout layout = new MigLayout();
    public Form2() {
        initComponents();
        setOpaque(false);
        aramaP.setVisible(false);
        tabloP.setVisible(true);
        eklemeP.setVisible(false);
        silmeP.setVisible(false);
        jScrollPane3.setVerticalScrollBar(new ScrollBar());
        jScrollPane3.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane2.setVerticalScrollBar(new ScrollBar());
        jScrollPane2.getVerticalScrollBar().setBackground(Color.WHITE);
        init();
    }

    private void init() {
        MyTextField1 myTextField = new MyTextField1();
        myTextField.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/search.png")));
        myTextField.setHint("Aranacak personel ismini ve soyismini giriniz");
        myTextField.setBounds(10, 50, 750, 30);
        aramaP.add(myTextField);
        ButtonOutLine buton2 = new ButtonOutLine();
        buton2.setText("Arama");
        buton2.setForeground(Color.BLACK);
        buton2.setBounds(770, 50, 50, 30);
        buton2.setFont(new Font("arial", 2, 14));
        buton2.setBackground(Color.BLACK);
        aramaP.add(buton2);
        name1.setHint("Personel ismini giriniz.");
        surname1.setHint("Personel soyismini giriniz.");
        age1.setHint("Personel yaşını giriniz.");
        email1.setHint("Personel emailini giriniz.");
        phoneNumber1.setHint("Personel telefon numarasını (+ab)abc-abc-ab-ab şeklinde giriniz.");
        adress1.setHint("Personel adresini giriniz.");
        departmant1.setHint("Personel bölümünü giriniz.");
        name4.setHint("Personel ismini giriniz.");
        surname4.setHint("Personel soyismini giriniz.");
        List<Object[]> list1 = new ArrayList<>();
        ModelPersonel personel = new ModelPersonel();
        ServicePersonel servicePersonel = new ServicePersonel();
        list1 = servicePersonel.readAllFile(personel);
        DefaultTableModel model = (DefaultTableModel) tablo8.getModel();
        for (int i = 0; i < list1.size(); i++) {
            model.addRow(list1.get(i));
        }
        buton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aramaP.setVisible(false);
                tabloP.setVisible(true);
                eklemeP.setVisible(false);
                silmeP.setVisible(false);
            }
        });
        buton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aramaP.setVisible(true);
                tabloP.setVisible(false);
                eklemeP.setVisible(false);
                silmeP.setVisible(false);
            }
        });
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = myTextField.getText();
                StringTokenizer st = new StringTokenizer(temp, " ");
                String name = st.nextToken();
                String surname = st.nextToken();
                List<Object[]> list1 = new ArrayList<>();
                list1 = servicePersonel.readSearchFile(personel, name, surname);
                DefaultTableModel model = (DefaultTableModel) tablo1.getModel();
                for (int i = 0; i < list1.size(); i++) {
                    model.addRow(list1.get(i));
                }
            }
        });
        buton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aramaP.setVisible(false);
                tabloP.setVisible(false);
                eklemeP.setVisible(true);
                silmeP.setVisible(false);
            }

        });
        buton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aramaP.setVisible(false);
                tabloP.setVisible(true);
                eklemeP.setVisible(false);
                silmeP.setVisible(false);
            }

        });
        buton5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Message message1 = new Message();
                ModelPersonel personel = new ModelPersonel();
                ServicePersonel servicePersonel = new ServicePersonel();
                String name2 = name1.getText();
                String surname2 = surname1.getText();
                int age2 = Integer.parseInt(age1.getText());
                String email2 = email1.getText();
                String phoneNumber2 = phoneNumber1.getText();
                String adress2 = adress1.getText();
                String departmant2 = departmant1.getText();
                personel = new ModelPersonel(name2,surname2,age2,email2,phoneNumber2,adress2,departmant2);
                int a = servicePersonel.writePersonel(personel);
                eklemeP.add(message1);
                if(a==1){
                    
                    eklemeP.add(message1);
                    try {
                        wait(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Form2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else
                    showMessage(Message.MessageType.ERROR, "Eklenemedi");
                eklemeP.remove(message1);
            }
            
        });
        buton6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                aramaP.setVisible(false);
                tabloP.setVisible(true);
                eklemeP.setVisible(false);
                silmeP.setVisible(false);
            }
            
        });
        buton8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                aramaP.setVisible(false);
                tabloP.setVisible(false);
                eklemeP.setVisible(false);
                silmeP.setVisible(true);
            }
            
        });
        buton7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ModelPersonel personel = new ModelPersonel();
                ServicePersonel servicePersonel = new ServicePersonel();
                String name5 = name4.getText();
                String surname5= surname4.getText();
                personel = new ModelPersonel(name5,surname5);
                servicePersonel.deleteSearchFile(name5,surname5);
            }
            
        });
    }
    private void showMessage(Message.MessageType messageType, String message) {
        Message m = new Message();
        m.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!m.isShow()) {
                    jLayeredPane1.add(m, "pos 0.5al -30", 0); //  Insert to bg fist index 0
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        tabloP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buton = new swing.ButtonOutLine();
        buton3 = new swing.ButtonOutLine();
        buton8 = new swing.ButtonOutLine();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablo8 = new swing.TableColumn();
        aramaP = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablo1 = new swing.TableColumn();
        jLabel2 = new javax.swing.JLabel();
        buton1 = new swing.ButtonOutLine();
        eklemeP = new javax.swing.JPanel();
        buton4 = new swing.ButtonOutLine();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        surname = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JLabel();
        adress = new javax.swing.JLabel();
        departmant = new javax.swing.JLabel();
        phoneNumber1 = new swing.MyTextField1();
        name1 = new swing.MyTextField1();
        surname1 = new swing.MyTextField1();
        age1 = new swing.MyTextField1();
        email1 = new swing.MyTextField1();
        adress1 = new swing.MyTextField1();
        departmant1 = new swing.MyTextField1();
        buton5 = new swing.ButtonOutLine();
        silmeP = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        buton6 = new swing.ButtonOutLine();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        surname4 = new swing.MyTextField1();
        name4 = new swing.MyTextField1();
        buton7 = new swing.ButtonOutLine();

        setPreferredSize(new java.awt.Dimension(1000, 434));

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1000, 432));
        jLayeredPane1.setLayout(new java.awt.CardLayout());

        tabloP.setOpaque(false);
        tabloP.setPreferredSize(new java.awt.Dimension(1000, 432));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Tablo");

        buton.setBackground(new java.awt.Color(0, 0, 0));
        buton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        buton.setText("Arama   ");
        buton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        buton3.setBackground(new java.awt.Color(0, 0, 0));
        buton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        buton3.setText("Ekleme  ");
        buton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        buton8.setBackground(new java.awt.Color(0, 0, 0));
        buton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        buton8.setText("Silme  ");
        buton8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tablo8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numara", "İsim", "Soyisim", "Yaş", "Email", "Telefon Numarası", "Adres", "Bölüm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablo8);

        javax.swing.GroupLayout tabloPLayout = new javax.swing.GroupLayout(tabloP);
        tabloP.setLayout(tabloPLayout);
        tabloPLayout.setHorizontalGroup(
            tabloPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabloPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 681, Short.MAX_VALUE)
                .addComponent(buton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(tabloPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tabloPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        tabloPLayout.setVerticalGroup(
            tabloPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabloPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabloPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(buton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(391, Short.MAX_VALUE))
            .addGroup(tabloPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tabloPLayout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLayeredPane1.add(tabloP, "card2");

        aramaP.setOpaque(false);

        tablo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numara", "İsim", "Soyisim", "Yaş", "Email", "Telefon Numarası", "Adres", "Bölüm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablo1);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jLabel2.setText("Arama");

        buton1.setBackground(new java.awt.Color(0, 0, 0));
        buton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/table1.png"))); // NOI18N
        buton1.setText("Tablo   ");
        buton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aramaPLayout = new javax.swing.GroupLayout(aramaP);
        aramaP.setLayout(aramaPLayout);
        aramaPLayout.setHorizontalGroup(
            aramaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aramaPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aramaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                    .addGroup(aramaPLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        aramaPLayout.setVerticalGroup(
            aramaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aramaPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(aramaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(buton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.add(aramaP, "card3");

        eklemeP.setOpaque(false);

        buton4.setBackground(new java.awt.Color(0, 0, 0));
        buton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/table1.png"))); // NOI18N
        buton4.setText("Tablo  ");
        buton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        jLabel3.setText("Personel Ekle");

        name.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        name.setText("İsim");

        email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        email.setText("Email:");

        age.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        age.setText("Yaş:");

        surname.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        surname.setText("Soyisim:");

        phoneNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        phoneNumber.setText("Telefon Numarası:");

        adress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        adress.setText("Adres:");

        departmant.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        departmant.setText("Bölüm:");

        name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name1ActionPerformed(evt);
            }
        });

        buton5.setBackground(new java.awt.Color(0, 0, 0));
        buton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        buton5.setText("Ekle  ");
        buton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout eklemePLayout = new javax.swing.GroupLayout(eklemeP);
        eklemeP.setLayout(eklemePLayout);
        eklemePLayout.setHorizontalGroup(
            eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eklemePLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eklemePLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eklemePLayout.createSequentialGroup()
                        .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumber)
                            .addComponent(name)
                            .addComponent(surname)
                            .addComponent(age)
                            .addComponent(email)
                            .addComponent(adress)
                            .addComponent(departmant))
                        .addGap(18, 18, 18)
                        .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(surname1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(age1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(email1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phoneNumber1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adress1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(departmant1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(buton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 470, Short.MAX_VALUE)))
                .addContainerGap())
        );
        eklemePLayout.setVerticalGroup(
            eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eklemePLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name)
                        .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surname)
                    .addComponent(surname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(age)
                    .addComponent(age1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumber)
                    .addComponent(phoneNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adress)
                    .addComponent(adress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eklemePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmant)
                    .addComponent(departmant1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLayeredPane1.add(eklemeP, "card4");

        silmeP.setMinimumSize(new java.awt.Dimension(1000, 432));
        silmeP.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        jLabel4.setText("Personel Kayıtı Silme");

        buton6.setBackground(new java.awt.Color(0, 0, 0));
        buton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/table1.png"))); // NOI18N
        buton6.setText("Tablo  ");
        buton6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("İsim:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Soyisim:");

        name4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name4ActionPerformed(evt);
            }
        });

        buton7.setBackground(new java.awt.Color(0, 0, 0));
        buton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        buton7.setText("Sil  ");
        buton7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout silmePLayout = new javax.swing.GroupLayout(silmeP);
        silmeP.setLayout(silmePLayout);
        silmePLayout.setHorizontalGroup(
            silmePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(silmePLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(silmePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(silmePLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(silmePLayout.createSequentialGroup()
                        .addGroup(silmePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(silmePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(name4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(surname4, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(buton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(548, 548, 548)))
                .addContainerGap())
        );
        silmePLayout.setVerticalGroup(
            silmePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(silmePLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(silmePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(buton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(silmePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(silmePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(name4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(silmePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(surname4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(279, Short.MAX_VALUE))
        );

        jLayeredPane1.add(silmeP, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buton1ActionPerformed

    private void name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name1ActionPerformed

    private void name4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adress;
    private swing.MyTextField1 adress1;
    private javax.swing.JLabel age;
    private swing.MyTextField1 age1;
    private javax.swing.JPanel aramaP;
    private swing.ButtonOutLine buton;
    private swing.ButtonOutLine buton1;
    private swing.ButtonOutLine buton3;
    private swing.ButtonOutLine buton4;
    private swing.ButtonOutLine buton5;
    private swing.ButtonOutLine buton6;
    private swing.ButtonOutLine buton7;
    private swing.ButtonOutLine buton8;
    private javax.swing.JLabel departmant;
    private swing.MyTextField1 departmant1;
    private javax.swing.JPanel eklemeP;
    private javax.swing.JLabel email;
    private swing.MyTextField1 email1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel name;
    private swing.MyTextField1 name1;
    private swing.MyTextField1 name4;
    private javax.swing.JLabel phoneNumber;
    private swing.MyTextField1 phoneNumber1;
    private javax.swing.JPanel silmeP;
    private javax.swing.JLabel surname;
    private swing.MyTextField1 surname1;
    private swing.MyTextField1 surname4;
    private swing.TableColumn tablo1;
    private swing.TableColumn tablo8;
    private javax.swing.JPanel tabloP;
    // End of variables declaration//GEN-END:variables
}
