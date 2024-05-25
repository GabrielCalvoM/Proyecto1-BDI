/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Control.Cursors;
import Control.Deletions;
import Control.Insertions;
import Model.Artist;
import Model.Country;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author Gabriel
 */
public class ArtistNations extends javax.swing.JPanel {

    private Artist artist;
    private MainFrame mainFrame;
    private JPanel previous;
    
    public ArtistNations(MainFrame mainFrame, JPanel previous, Artist artist) {
        initComponents();
        this.mainFrame = mainFrame;
        this.previous = previous;
        this.artist = artist;
        this.getArtistNations();
        this.initializeNations();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArtistRelative_Settings = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        nationalities = new javax.swing.JList<>();
        addArtistPic = new javax.swing.JButton();
        delArtistPic = new javax.swing.JButton();
        selNation = new javax.swing.JComboBox<>();

        ArtistRelative_Settings.setBackground(new java.awt.Color(0, 0, 0));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Nacionalidad del Artista");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel48)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BackBtn.setBackground(new java.awt.Color(51, 51, 51));
        BackBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(255, 255, 255));
        BackBtn.setText("Atrás");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        nationalities.setBackground(new java.awt.Color(51, 51, 51));
        nationalities.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane16.setViewportView(nationalities);

        addArtistPic.setBackground(new java.awt.Color(51, 51, 51));
        addArtistPic.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addArtistPic.setForeground(new java.awt.Color(255, 255, 255));
        addArtistPic.setText("Agregar País");
        addArtistPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addArtistPicActionPerformed(evt);
            }
        });

        delArtistPic.setBackground(new java.awt.Color(51, 51, 51));
        delArtistPic.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delArtistPic.setForeground(new java.awt.Color(255, 255, 255));
        delArtistPic.setText("Borrar País");
        delArtistPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delArtistPicActionPerformed(evt);
            }
        });

        selNation.setBackground(new java.awt.Color(51, 51, 51));
        selNation.setForeground(new java.awt.Color(255, 255, 255));
        selNation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No hay países" }));

        javax.swing.GroupLayout ArtistRelative_SettingsLayout = new javax.swing.GroupLayout(ArtistRelative_Settings);
        ArtistRelative_Settings.setLayout(ArtistRelative_SettingsLayout);
        ArtistRelative_SettingsLayout.setHorizontalGroup(
            ArtistRelative_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ArtistRelative_SettingsLayout.createSequentialGroup()
                .addGroup(ArtistRelative_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArtistRelative_SettingsLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(addArtistPic, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(delArtistPic, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ArtistRelative_SettingsLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ArtistRelative_SettingsLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(selNation, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        ArtistRelative_SettingsLayout.setVerticalGroup(
            ArtistRelative_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtistRelative_SettingsLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(selNation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(ArtistRelative_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackBtn)
                    .addComponent(addArtistPic, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delArtistPic, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtistRelative_Settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtistRelative_Settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        mainFrame.showPage("AdminPage", this.previous);
    }//GEN-LAST:event_BackBtnActionPerformed

    private void addArtistPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addArtistPicActionPerformed
        Country country = (Country) this.selNation.getSelectedItem();
        DefaultListModel model = (DefaultListModel) this.nationalities.getModel();
        
        try {
            for (int i = 0; i < model.size(); i++) {
                Country countryModel = (Country) model.getElementAt(i);

                if (countryModel.getId() == country.getId()) {
                    this.mainFrame.showError("La nacionalidad ya está registrada");
                    return;
                }
            }
        } catch (Exception e) {}
        
        try {
            Insertions.insertNationality(this.artist.getId(), country.getId());
            this.getArtistNations();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_addArtistPicActionPerformed

    private void delArtistPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delArtistPicActionPerformed
        DefaultListModel model = (DefaultListModel) this.nationalities.getModel();
        Country country = (Country) model.getElementAt(this.nationalities.getSelectedIndex());

        try {
            Deletions.deleteNationality(country.getId(), artist.getId());
            this.getArtistNations();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_delArtistPicActionPerformed

    private void initializeNations() {
        try {
            DefaultComboBoxModel countries = this.mainFrame.buildComboModel(
                                                            Cursors.getCountries());
            
            this.selNation.setModel(countries);
        } catch (SQLException ex) {
            System.out.println("Error al obtener los países");
        }
    }
    
    private void getArtistNations() {
        try {
            ArrayList<Country> list = Cursors.getNationalities(this.artist.getId());
            
            if (list.isEmpty()) {
                DefaultListModel model = new DefaultListModel();
                model.addElement("No hay nacionalidades registradas");
                this.nationalities.setModel(model);
                return;
            }
            
            DefaultListModel model = this.mainFrame.buildListModel(list);
            this.nationalities.setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArtistRelative_Settings;
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton addArtistPic;
    private javax.swing.JButton delArtistPic;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JList<String> nationalities;
    private javax.swing.JComboBox<String> selNation;
    // End of variables declaration//GEN-END:variables
}
