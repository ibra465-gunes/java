package form;
import component.Bottom;
import model.ModelPersonel;
import service.ServicePersonel;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Form1 extends javax.swing.JPanel {

    private String isim;
    private String isim1;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim){
        this.isim=isim;
    }

    public String getIsim1() {
        return isim1;
    }

    public void setIsim1(String isim1) {
        this.isim1 = isim1;
    }   
    public Form1() {
        setIsim(Bottom.na);
        System.out.println(getIsim()+getIsim1());
        initComponents();
        setOpaque(false);
        Text();


    }
    public void Text(){
        DecimalFormat df = new DecimalFormat("#");
        Object array[]= new Object[8];
        ServicePersonel servicePersonel =new ServicePersonel();
        ModelPersonel personel = new ModelPersonel();
        array = servicePersonel.readAdminFile(personel,isim);
        System.out.println(array[4]);
        name1.setText(String.valueOf(array[1]));
        surname1.setText(String.valueOf(array[2]));
        age1.setText((String.valueOf(df.format(array[3]))));
        email1.setText(String.valueOf(array[4]));
        phoneNumber1.setText(String.valueOf(array[5]));
        adress1.setText(String.valueOf(array[6]));
        department1.setText(String.valueOf(array[7]));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        surname = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        surname1 = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        age1 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        email1 = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JLabel();
        phoneNumber1 = new javax.swing.JLabel();
        adress = new javax.swing.JLabel();
        adress1 = new javax.swing.JLabel();
        department = new javax.swing.JLabel();
        department1 = new javax.swing.JLabel();

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/admin3.png"))); // NOI18N

        name.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        name.setText("İsim:");

        surname.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        surname.setText("Soy İsim:");

        name1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        surname1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        age.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        age.setText("Yaş:");

        age1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        email.setText("Email:");

        email1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        phoneNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        phoneNumber.setText("Telefon Numarası:");

        phoneNumber1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        adress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        adress.setText("Adres:");

        adress1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        department.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        department.setText("Bölüm:");

        department1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surname)
                            .addComponent(name)
                            .addComponent(age)
                            .addComponent(email))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(age1)
                            .addComponent(email1)
                            .addComponent(surname1)
                            .addComponent(name1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumber)
                            .addComponent(adress)
                            .addComponent(department))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(department1)
                            .addComponent(adress1)
                            .addComponent(phoneNumber1))))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(icon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name)
                            .addComponent(name1))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surname)
                            .addComponent(surname1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(age)
                            .addComponent(age1))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(email1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumber)
                    .addComponent(phoneNumber1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adress)
                    .addComponent(adress1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(department)
                    .addComponent(department1))
                .addContainerGap(69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adress;
    private javax.swing.JLabel adress1;
    private javax.swing.JLabel age;
    private javax.swing.JLabel age1;
    private javax.swing.JLabel department;
    private javax.swing.JLabel department1;
    private javax.swing.JLabel email;
    private javax.swing.JLabel email1;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel phoneNumber;
    private javax.swing.JLabel phoneNumber1;
    private javax.swing.JLabel surname;
    private javax.swing.JLabel surname1;
    // End of variables declaration//GEN-END:variables
}
