/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Control.Cursors;
import Model.Artist;
import Model.ArtistRelative;
import Model.Country;
import Model.Product;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gabriel
 */
public class ViewArtist extends javax.swing.JPanel {

    private JPanel previousPanel;
    private MainFrame mainFrame;
    private HashMap<String, Integer> products;
    private ArrayList<String> imagesPath;
    private int actualPic;
    
    public ViewArtist(MainFrame frame, JPanel prev, int idArtist) {
        initComponents();
        this.mainFrame = frame;
        this.previousPanel = prev;
        this.getData(idArtist);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewMovie = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        MainMenuLbl2 = new javax.swing.JLabel();
        artistName = new javax.swing.JLabel();
        ArtistPic = new javax.swing.JLabel();
        birthDate = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        biography = new javax.swing.JTextArea();
        artistHeight = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        artistProducts = new javax.swing.JList<>();
        jLabel76 = new javax.swing.JLabel();
        viewProductBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        artistSiblings = new javax.swing.JList<>();
        jScrollPane20 = new javax.swing.JScrollPane();
        artistCouple = new javax.swing.JList<>();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        artistChildren = new javax.swing.JList<>();
        jLabel79 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        artistParents = new javax.swing.JList<>();
        jLabel80 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        triviaData = new javax.swing.JTextArea();
        artistRole = new javax.swing.JLabel();
        nextPic = new javax.swing.JButton();
        prevPic = new javax.swing.JButton();
        jScrollPane23 = new javax.swing.JScrollPane();
        nationalities = new javax.swing.JList<>();
        jLabel75 = new javax.swing.JLabel();

        ViewMovie.setBackground(new java.awt.Color(0, 0, 0));

        jPanel19.setBackground(new java.awt.Color(51, 51, 51));

        MainMenuLbl2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MainMenuLbl2.setForeground(new java.awt.Color(255, 255, 255));
        MainMenuLbl2.setText("Belphegor");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainMenuLbl2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainMenuLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        artistName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        artistName.setForeground(new java.awt.Color(255, 255, 255));
        artistName.setText("Nombre Artista");

        birthDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        birthDate.setForeground(new java.awt.Color(255, 255, 255));
        birthDate.setText("<html>Fecha de Nacimiento: <br>01/01/2000</html>");

        biography.setEditable(false);
        biography.setBackground(new java.awt.Color(51, 51, 51));
        biography.setColumns(20);
        biography.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        biography.setForeground(new java.awt.Color(255, 255, 255));
        biography.setLineWrap(true);
        biography.setRows(5);
        biography.setText("Aqui va la sinopsis\n");
        biography.setWrapStyleWord(true);
        jScrollPane16.setViewportView(biography);

        artistHeight.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        artistHeight.setForeground(new java.awt.Color(255, 255, 255));
        artistHeight.setText("<html>Altura:<br>190cm</html>");
        artistHeight.setToolTipText("");

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Biografía");

        artistProducts.setBackground(new java.awt.Color(51, 51, 51));
        artistProducts.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        artistProducts.setForeground(new java.awt.Color(255, 255, 255));
        artistProducts.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "No hay productos relacionados" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane18.setViewportView(artistProducts);

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Productos");

        viewProductBtn.setBackground(new java.awt.Color(51, 51, 51));
        viewProductBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewProductBtn.setText("Ver");
        viewProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductBtnActionPerformed(evt);
            }
        });

        BackBtn.setBackground(new java.awt.Color(51, 51, 51));
        BackBtn.setForeground(new java.awt.Color(255, 255, 255));
        BackBtn.setText("Atrás");
        BackBtn.setBorderPainted(false);
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Hermanos");

        artistSiblings.setBackground(new java.awt.Color(51, 51, 51));
        artistSiblings.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        artistSiblings.setForeground(new java.awt.Color(255, 255, 255));
        artistSiblings.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "N/A" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane19.setViewportView(artistSiblings);

        artistCouple.setBackground(new java.awt.Color(51, 51, 51));
        artistCouple.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        artistCouple.setForeground(new java.awt.Color(255, 255, 255));
        artistCouple.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "N/A" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane20.setViewportView(artistCouple);

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Pareja");

        artistChildren.setBackground(new java.awt.Color(51, 51, 51));
        artistChildren.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        artistChildren.setForeground(new java.awt.Color(255, 255, 255));
        artistChildren.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "N/A" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane21.setViewportView(artistChildren);

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Hijos");

        artistParents.setBackground(new java.awt.Color(51, 51, 51));
        artistParents.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        artistParents.setForeground(new java.awt.Color(255, 255, 255));
        artistParents.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "N/A" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane22.setViewportView(artistParents);

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("Padres");

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Dato curioso");

        triviaData.setEditable(false);
        triviaData.setBackground(new java.awt.Color(51, 51, 51));
        triviaData.setColumns(20);
        triviaData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        triviaData.setForeground(new java.awt.Color(255, 255, 255));
        triviaData.setLineWrap(true);
        triviaData.setRows(5);
        triviaData.setText("Aqui va el dato");
        triviaData.setWrapStyleWord(true);
        jScrollPane17.setViewportView(triviaData);

        artistRole.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        artistRole.setForeground(new java.awt.Color(255, 255, 255));
        artistRole.setText("Rol: -");

        nextPic.setBackground(new java.awt.Color(51, 51, 51));
        nextPic.setForeground(new java.awt.Color(192, 192, 192));
        nextPic.setText(">");
        nextPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPicActionPerformed(evt);
            }
        });

        prevPic.setBackground(new java.awt.Color(51, 51, 51));
        prevPic.setForeground(new java.awt.Color(192, 192, 192));
        prevPic.setText("<");
        prevPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevPicActionPerformed(evt);
            }
        });

        nationalities.setBackground(new java.awt.Color(51, 51, 51));
        nationalities.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        nationalities.setForeground(new java.awt.Color(255, 255, 255));
        nationalities.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "No hay productos relacionados" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane23.setViewportView(nationalities);

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Nacionalidad");

        javax.swing.GroupLayout ViewMovieLayout = new javax.swing.GroupLayout(ViewMovie);
        ViewMovie.setLayout(ViewMovieLayout);
        ViewMovieLayout.setHorizontalGroup(
            ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ViewMovieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewMovieLayout.createSequentialGroup()
                        .addComponent(artistName, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(artistRole, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ViewMovieLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                .addComponent(prevPic, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(artistHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthDate)
                            .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ArtistPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane19)
                                    .addComponent(jScrollPane20)
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel78)
                                            .addComponent(jLabel77))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel74))
                                        .addGroup(ViewMovieLayout.createSequentialGroup()
                                            .addComponent(jLabel73)
                                            .addGap(147, 147, 147))
                                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel75))
                                .addGap(18, 18, 18)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel80)
                                    .addComponent(jLabel79)
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel76))
                                        .addGap(18, 18, 18)
                                        .addComponent(viewProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        ViewMovieLayout.setVerticalGroup(
            ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewMovieLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(artistRole, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewMovieLayout.createSequentialGroup()
                        .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(ViewMovieLayout.createSequentialGroup()
                                .addComponent(ArtistPic, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prevPic, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nextPic, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(birthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(artistHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BackBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ViewMovieLayout.createSequentialGroup()
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel78)
                                    .addComponent(jLabel80))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(ViewMovieLayout.createSequentialGroup()
                                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel77)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewMovieLayout.createSequentialGroup()
                                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel79)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(36, 36, 36)
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ViewMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewMovieLayout.createSequentialGroup()
                                        .addComponent(viewProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)))))
                        .addGap(29, 29, Short.MAX_VALUE))
                    .addGroup(ViewMovieLayout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewMovie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewMovie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductBtnActionPerformed
        DefaultListModel model = (DefaultListModel) this.artistProducts.getModel();
        String name;
        Product product;
        
        try {
            name = (String) model.get(this.artistProducts.getSelectedIndex());
            int idProduct = this.products.get(name);
            product = Cursors.getProduct(idProduct);
        } catch (Exception e) {
            this.mainFrame.showError("Seleccione un producto");
            return;
        }

        this.mainFrame.showPage("viewMovie", new ViewMovie(this.mainFrame, this,
                                                           product));
    }//GEN-LAST:event_viewProductBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        mainFrame.showPage("NewPage", previousPanel);
    }//GEN-LAST:event_BackBtnActionPerformed

    private void nextPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPicActionPerformed
        if (this.actualPic >= this.imagesPath.size() - 1) {
            return;
        }
        
        this.actualPic++;
        this.setPhoto();
        
        if (!this.prevPic.isEnabled()) {
            this.prevPic.setEnabled(true);
        }
        
        if (this.actualPic == this.imagesPath.size() - 1) {
            this.nextPic.setEnabled(false);
        }
    }//GEN-LAST:event_nextPicActionPerformed

    private void prevPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevPicActionPerformed
        if (this.actualPic <= 0) {
            return;
        }
        
        this.actualPic--;
        this.setPhoto();
        
        if (!this.nextPic.isEnabled()) {
            this.nextPic.setEnabled(true);
        }
        
        if (this.actualPic == 0) {
            this.prevPic.setEnabled(false);
        }
    }//GEN-LAST:event_prevPicActionPerformed

    private void getData(int idArtist) {
        this.products = new HashMap();
        this.imagesPath = new ArrayList();
        this.actualPic = 0;
        this.artistData(idArtist);
    }
    
    private void artistData(int idArtist) {
        Artist artist;
        try {
            artist = Cursors.getArtist(idArtist);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(previousPanel, "No se ha encontrado al artista");
            return;
        }
        
        String name = artist.getName();
        String type = artist.getArtistType();
        String birth = artist.getBirthDate();
        String bio = artist.getBiography_artist();
        String trivia = artist.getTrivia_data();
        int height = artist.getHeight();
        
        this.artistName.setText(name);
        this.artistRole.setText("Rol: " + type);
        this.birthDate.setText("<html>Fecha de Nacimiento:<br>" +
                                      birth + "</html>");
        this.biography.setText(bio);
        this.triviaData.setText(trivia);
        this.artistHeight.setText("<html>Altura:<br>" +
                                         height + " cm</html>");
        
        this.initializeRelatives(idArtist);
        this.initializeProducts(idArtist);
        this.initializePhotos(idArtist);
        this.initializeNations(idArtist);
    }
    
    private void initializeRelatives(int id) {
    // Search the relatives of the artist and show them in lists
        try {
            DefaultListModel<String> model = mainFrame.buildListModel(Cursors.getParents(id));
            this.artistParents.setModel(model);
        } catch (SQLException ex) {}
        
        try {
            DefaultListModel<String> model = mainFrame.buildListModel(Cursors.getChildren(id));
            this.artistChildren.setModel(model);
        } catch (SQLException ex) {}
        
        try {
            DefaultListModel<String> model = mainFrame.buildListModel(Cursors.getCouple(id));
            this.artistCouple.setModel(model);
        } catch (SQLException ex) {}
        
        try {
            DefaultListModel<String> model = mainFrame.buildListModel(Cursors.getSiblings(id));
            this.artistSiblings.setModel(model);
        } catch (SQLException ex) {}
    }
    
    private void initializeProducts(int idArtist) {
        ArrayList<Integer> idProducts;
        ArrayList<String> productNames = new ArrayList();
        
        try {
            idProducts = Cursors.getArtistProducts(idArtist);
        } catch (Exception e) {
            System.out.println("Error al cargar los productos");
            return;
        }
        
        if (idProducts.isEmpty()) {
            System.out.println("No hay productos");
            return;
        }
        
        for (int id : idProducts) {
            try {
                String name = Cursors.getProduct(id).toString();
                productNames.add(name);
                this.products.put(name, id);
            } catch (Exception e) {
                System.out.println("Error al cargar el producto " + id);
            }
        }
        
        DefaultListModel<String> model = mainFrame.buildListModel(productNames);
        this.artistProducts.setModel(model);
    }
    
    private void initializePhotos(int idArtist) {
        try {
            this.imagesPath = Cursors.getArtistPhotos(idArtist);
        } catch (SQLException ex) {}
        
        if (this.imagesPath.isEmpty()) {
            return;
        }
        
        this.setPhoto();
        this.prevPic.setEnabled(false);
        
        if (this.imagesPath.size() <= 1) {
            this.nextPic.setEnabled(false);
        }
    }
    
    private void initializeNations(int idArtist) {
        try {
            ArrayList<Country> list = Cursors.getNationalities(idArtist);
            
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
    
    private void setPhoto() {
    //Receives a label and an image path, sets the label's icon to the image.
        
        String path = this.imagesPath.get(this.actualPic);
        File file = new File(path);
        BufferedImage originalImage;
        
        try {
            originalImage = ImageIO.read(file);
        }
        catch (Exception e) {
            mainFrame.showError("Error al cargar imagen");
            return;
        }

        Image scaledImage = originalImage.getScaledInstance(140, 165, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);
        this.ArtistPic.setIcon(icon);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ArtistPic;
    private javax.swing.JButton BackBtn;
    private javax.swing.JLabel MainMenuLbl2;
    private javax.swing.JPanel ViewMovie;
    private javax.swing.JList<String> artistChildren;
    private javax.swing.JList<String> artistCouple;
    private javax.swing.JLabel artistHeight;
    private javax.swing.JLabel artistName;
    private javax.swing.JList<String> artistParents;
    private javax.swing.JList<String> artistProducts;
    private javax.swing.JLabel artistRole;
    private javax.swing.JList<String> artistSiblings;
    private javax.swing.JTextArea biography;
    private javax.swing.JLabel birthDate;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JList<String> nationalities;
    private javax.swing.JButton nextPic;
    private javax.swing.JButton prevPic;
    private javax.swing.JTextArea triviaData;
    private javax.swing.JButton viewProductBtn;
    // End of variables declaration//GEN-END:variables
}
