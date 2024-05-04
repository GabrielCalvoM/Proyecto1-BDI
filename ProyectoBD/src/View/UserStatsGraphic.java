/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Control.Cursors;
import Model.Person;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class UserStatsGraphic extends javax.swing.JPanel {
    MainFrame mainFrame;
    JPanel previous;

    
    public UserStatsGraphic(MainFrame mainFrame, JPanel previous) {
        this.mainFrame = mainFrame;
        this.previous = previous;
        initComponents();
    }
    
    public void showUserChart(int genderRange) {
        try {
        
        // Obtener datos
        int femaleCount = 0;
        int maleCount = 0;
        
        ArrayList<Person> users = Cursors.getUsersPersonalData();
        for (int i = 0; i < users.size(); i++) {
            Person user = users.get(i);
            System.out.println(user.getId_gender());
            //System.out.println(user.getId_gender() % 2 + 1);
            if (user.getId_gender() == 2) femaleCount = femaleCount + 1;
            if (user.getId_gender() == 1) maleCount = maleCount + 1;
        }
       
        System.out.println(femaleCount + "\t" + maleCount);
        
        // Asignar datos por filtro
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        if (genderRange == 0) {
            dataset.setValue("Mujeres", femaleCount);
            dataset.setValue("Hombres",  maleCount);
        }
        else if (genderRange == 1) {
            dataset.setValue("Hombres", maleCount);
        }
        else if (genderRange == 2) {
            dataset.setValue("Mujeres", femaleCount);
        }
        
        JFreeChart piechart = ChartFactory.createPieChart(
            "Usuarios del Sistema",
            dataset,
            true,
            true,
            false
        );
        
        ChartPanel panel = new ChartPanel(piechart);
        panel.setMouseWheelEnabled(false);
        panel.setPreferredSize(new Dimension(400, 300));
        
        GraphicUsersPanel.setLayout(new BorderLayout());
        GraphicUsersPanel.add(panel, BorderLayout.NORTH);
        
        mainFrame.pack();
        repaint();
        }                                             

        catch (Exception e) {
            mainFrame.showError("Error al leer de la base de datos.");
            return;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PTitle = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        GraphicButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        GraphicUsersPanel = new javax.swing.JPanel();
        GenderFilter = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AgeFilter = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        PTitle.setBackground(new java.awt.Color(51, 51, 51));

        Title.setBackground(new java.awt.Color(51, 51, 51));
        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("Estadísticas de Usuarios");

        javax.swing.GroupLayout PTitleLayout = new javax.swing.GroupLayout(PTitle);
        PTitle.setLayout(PTitleLayout);
        PTitleLayout.setHorizontalGroup(
            PTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PTitleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PTitleLayout.setVerticalGroup(
            PTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        GraphicButton.setBackground(new java.awt.Color(51, 51, 51));
        GraphicButton.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        GraphicButton.setForeground(new java.awt.Color(255, 255, 255));
        GraphicButton.setText("Graficar");
        GraphicButton.setBorderPainted(false);
        GraphicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicButtonActionPerformed(evt);
            }
        });

        BackButton.setBackground(new java.awt.Color(51, 51, 51));
        BackButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackButton.setForeground(new java.awt.Color(204, 204, 204));
        BackButton.setText("Atrás");
        BackButton.setBorderPainted(false);
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GraphicUsersPanelLayout = new javax.swing.GroupLayout(GraphicUsersPanel);
        GraphicUsersPanel.setLayout(GraphicUsersPanelLayout);
        GraphicUsersPanelLayout.setHorizontalGroup(
            GraphicUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        GraphicUsersPanelLayout.setVerticalGroup(
            GraphicUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        GenderFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Hombre", "Mujer" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Filtro por Género");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Filtro por Edad");

        AgeFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "18 años o menos", "19 a 35 años", "36 a 64 años", "65 años o más" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Gráfico Filtrado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(GraphicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GenderFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AgeFilter, 0, 182, Short.MAX_VALUE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GraphicUsersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GenderFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(GraphicButton)
                        .addGap(32, 32, 32)
                        .addComponent(BackButton))
                    .addComponent(GraphicUsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        GraphicButton.getAccessibleContext().setAccessibleParent(GraphicButton);
    }// </editor-fold>//GEN-END:initComponents

    private void GraphicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicButtonActionPerformed
        int genderRange = GenderFilter.getSelectedIndex();
        showUserChart(genderRange);
    }//GEN-LAST:event_GraphicButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        mainFrame.showPage("AdminPage", this.previous);
    }//GEN-LAST:event_BackButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AgeFilter;
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> GenderFilter;
    private javax.swing.JButton GraphicButton;
    private javax.swing.JPanel GraphicUsersPanel;
    private javax.swing.JPanel PTitle;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
