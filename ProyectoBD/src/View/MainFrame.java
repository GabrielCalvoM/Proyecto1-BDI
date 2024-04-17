package View;
import Model.Country;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import Control.*;
import javax.swing.ListModel;
        
public class MainFrame extends javax.swing.JFrame {
    public MainFrame() {
        initComponents();
    }
    
    void setCountryList() {
        DefaultListModel countriesListModel = new DefaultListModel();
        try{
            ArrayList<Country> countries = Cursors.getCountries();
            for (Country country : countries) {
                countriesListModel.addElement(country);
                countryList.setModel(countriesListModel);
            }
        }
        catch (Exception e) {
            System.out.println("Couldn't fetch countries: " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        MainMenu = new javax.swing.JPanel();
        MainMenuLbl = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        AdminPage = new javax.swing.JPanel();
        AdminMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CountriesButton = new javax.swing.JButton();
        AdmMenuBackBtn = new javax.swing.JButton();
        EditCountries = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        countryList = new javax.swing.JList<>();
        AddCountryBtn = new javax.swing.JButton();
        RemoveCountryBtn = new javax.swing.JButton();
        EditCountBackBtn = new javax.swing.JButton();
        NewCountryTxtfield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setLayout(new java.awt.CardLayout());

        MainMenu.setBackground(new java.awt.Color(0, 0, 0));

        MainMenuLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MainMenuLbl.setForeground(new java.awt.Color(255, 255, 255));
        MainMenuLbl.setText("Menu Principal");

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Pagina Admin");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainMenuLayout = new javax.swing.GroupLayout(MainMenu);
        MainMenu.setLayout(MainMenuLayout);
        MainMenuLayout.setHorizontalGroup(
            MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addComponent(MainMenuLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(475, 475, 475))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainMenuLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))))
        );
        MainMenuLayout.setVerticalGroup(
            MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(MainMenuLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        MainPanel.add(MainMenu, "card2");

        AdminPage.setBackground(new java.awt.Color(0, 0, 0));
        AdminPage.setLayout(new java.awt.CardLayout());

        AdminMenu.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(502, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        CountriesButton.setBackground(new java.awt.Color(153, 153, 153));
        CountriesButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CountriesButton.setForeground(new java.awt.Color(255, 255, 255));
        CountriesButton.setText("Countries");
        CountriesButton.setBorderPainted(false);
        CountriesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountriesButtonActionPerformed(evt);
            }
        });

        AdmMenuBackBtn.setBackground(new java.awt.Color(51, 51, 51));
        AdmMenuBackBtn.setForeground(new java.awt.Color(255, 255, 255));
        AdmMenuBackBtn.setText("Back");
        AdmMenuBackBtn.setBorderPainted(false);
        AdmMenuBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmMenuBackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminMenuLayout = new javax.swing.GroupLayout(AdminMenu);
        AdminMenu.setLayout(AdminMenuLayout);
        AdminMenuLayout.setHorizontalGroup(
            AdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(AdminMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CountriesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdmMenuBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AdminMenuLayout.setVerticalGroup(
            AdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminMenuLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CountriesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281)
                .addComponent(AdmMenuBackBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        AdminPage.add(AdminMenu, "card4");

        EditCountries.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Editar Paises");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        countryList.setBackground(new java.awt.Color(51, 51, 51));
        countryList.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countryList.setForeground(new java.awt.Color(255, 255, 255));
        countryList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Costa Rica", "Estados Unidos", "China", "Corea del Sur" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(countryList);

        AddCountryBtn.setBackground(new java.awt.Color(51, 51, 51));
        AddCountryBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddCountryBtn.setText("Agregar");
        AddCountryBtn.setBorderPainted(false);
        AddCountryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCountryBtnActionPerformed(evt);
            }
        });

        RemoveCountryBtn.setBackground(new java.awt.Color(51, 51, 51));
        RemoveCountryBtn.setForeground(new java.awt.Color(255, 255, 255));
        RemoveCountryBtn.setText("Eliminar");
        RemoveCountryBtn.setBorderPainted(false);
        RemoveCountryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveCountryBtnActionPerformed(evt);
            }
        });

        EditCountBackBtn.setBackground(new java.awt.Color(51, 51, 51));
        EditCountBackBtn.setForeground(new java.awt.Color(255, 255, 255));
        EditCountBackBtn.setText("Back");
        EditCountBackBtn.setBorderPainted(false);
        EditCountBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCountBackBtnActionPerformed(evt);
            }
        });

        NewCountryTxtfield.setBackground(new java.awt.Color(51, 51, 51));
        NewCountryTxtfield.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NewCountryTxtfield.setForeground(new java.awt.Color(255, 255, 255));
        NewCountryTxtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewCountryTxtfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditCountriesLayout = new javax.swing.GroupLayout(EditCountries);
        EditCountries.setLayout(EditCountriesLayout);
        EditCountriesLayout.setHorizontalGroup(
            EditCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EditCountriesLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(EditCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditCountriesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(AddCountryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(EditCountriesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(NewCountryTxtfield)
                        .addContainerGap())))
            .addGroup(EditCountriesLayout.createSequentialGroup()
                .addGroup(EditCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditCountriesLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(RemoveCountryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EditCountriesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(EditCountBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EditCountriesLayout.setVerticalGroup(
            EditCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditCountriesLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(EditCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditCountriesLayout.createSequentialGroup()
                        .addComponent(NewCountryTxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddCountryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(RemoveCountryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditCountBackBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        AdminPage.add(EditCountries, "card3");

        MainPanel.add(AdminPage, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("Change page");
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.next(MainPanel);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CountriesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountriesButtonActionPerformed
        CardLayout card = (CardLayout) AdminPage.getLayout();
        card.next(AdminPage);
        setCountryList();
    }//GEN-LAST:event_CountriesButtonActionPerformed

    private void AddCountryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCountryBtnActionPerformed
        String name = NewCountryTxtfield.getText();
        try {
            Insertions.insertCountry(name);
        }
        catch (Exception e) {
            System.out.println("Error inserting: " + e);
            return;
        }
        NewCountryTxtfield.setText("");
        setCountryList();
    }//GEN-LAST:event_AddCountryBtnActionPerformed

    private void RemoveCountryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveCountryBtnActionPerformed
        try{
            int index = countryList.getSelectedIndex();
            ListModel model = countryList.getModel();
            Country country = (Country)model.getElementAt(index);
            System.out.println(country);
            Deletions.deleteCountry(country.getId());
        }
        catch (Exception e) {
            System.out.println("Failed to delete" + e);
        }
        setCountryList();
    }//GEN-LAST:event_RemoveCountryBtnActionPerformed

    private void EditCountBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditCountBackBtnActionPerformed
        CardLayout card = (CardLayout) AdminPage.getLayout();
        card.previous(AdminPage);
    }//GEN-LAST:event_EditCountBackBtnActionPerformed

    private void AdmMenuBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmMenuBackBtnActionPerformed
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.previous(MainPanel);
    }//GEN-LAST:event_AdmMenuBackBtnActionPerformed

    private void NewCountryTxtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewCountryTxtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewCountryTxtfieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCountryBtn;
    private javax.swing.JButton AdmMenuBackBtn;
    private javax.swing.JPanel AdminMenu;
    private javax.swing.JPanel AdminPage;
    private javax.swing.JButton CountriesButton;
    private javax.swing.JButton EditCountBackBtn;
    private javax.swing.JPanel EditCountries;
    private javax.swing.JPanel MainMenu;
    private javax.swing.JLabel MainMenuLbl;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JTextField NewCountryTxtfield;
    private javax.swing.JButton RemoveCountryBtn;
    private javax.swing.JList<String> countryList;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}