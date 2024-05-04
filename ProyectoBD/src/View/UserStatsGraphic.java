/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Control.Cursors;
import Model.Person;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
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
    
    public void showUserChart(int genderRange, int ageRange) {
        try {
        
        // Obtener datos
        
        ArrayList<Person> users = Cursors.getUsersPersonalData();
        ArrayList<Person> maleList = new ArrayList<>();
        ArrayList<Person> femaleList = new ArrayList<>();
        ArrayList<Person> childList = new ArrayList<>();
        ArrayList<Person> youthList = new ArrayList<>();
        ArrayList<Person> adultList = new ArrayList<>();
        ArrayList<Person> elderList = new ArrayList<>();
        
        for (int i = 0; i < users.size(); i++) {
            // Datos de la persona
            Person user = users.get(i);
            int gender = user.getId_gender();
            System.out.println(user.getId_gender());
            int year = Integer.parseInt(user.getBirthDate().substring(0, 4));
            int age = 2024 - year;
            
            if (gender == 1) maleList.add(user);
            if (gender == 2) femaleList.add(user);
            if (age <= 18) childList.add(user);
            else if (age <= 35) youthList.add(user);
            else if (age <= 65) adultList.add(user);
            else if (age >= 66) elderList.add(user);
        }
       
        // Asignar datos por filtro
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        if (genderRange == 0 && ageRange == 0) {
            dataset.setValue("Total", users.size());
        }
        else if (genderRange != 0 && ageRange == 0) {
            dataset.setValue("Hombres", maleList.size());
            dataset.setValue("Mujeres", femaleList.size());
        }
        else if (genderRange == 0 && ageRange != 0) {
            dataset.setValue(" <= 18 años ", childList.size());
            dataset.setValue(" 19 a 35 años ", youthList.size());
            dataset.setValue(" 36 a 65 años ", adultList.size());
            dataset.setValue(" 66 >= años ", childList.size());
        }
        else if (genderRange == 1 && ageRange == 0) {
            for (int i = 0; i < femaleList.size(); i++) {
                if (childList.contains(femaleList.get(i))) 
                    childList.remove(i);
                if (youthList.contains(femaleList.get(i))) 
                    youthList.remove(i);
                if (adultList.contains(femaleList.get(i))) 
                    adultList.remove(i);
                if (elderList.contains(femaleList.get(i))) 
                    elderList.remove(i);
            }
            dataset.setValue(" <= 18 años ", childList.size());
            dataset.setValue(" 19 a 35 años ", youthList.size());
            dataset.setValue(" 36 a 65 años ", adultList.size());
            dataset.setValue(" 66 >= años ", childList.size());
        }
        else if (genderRange == 2 && ageRange == 0) {
            for (int i = 0; i < maleList.size(); i++) {
                if (childList.contains(maleList.get(i))) 
                    childList.remove(i);
                if (youthList.contains(maleList.get(i))) 
                    youthList.remove(i);
                if (adultList.contains(maleList.get(i))) 
                    adultList.remove(i);
                if (elderList.contains(maleList.get(i))) 
                    elderList.remove(i);
            }
            dataset.setValue(" <= 18 años ", childList.size());
            dataset.setValue(" 19 a 35 años ", youthList.size());
            dataset.setValue(" 36 a 65 años ", adultList.size());
            dataset.setValue(" 66 >= años ", childList.size());
        }
        else if (genderRange == 1 && ageRange == 1) {
            for (int i = 0; i < femaleList.size(); i++) {
                if (childList.contains(femaleList.get(i))) 
                    childList.remove(i);
            }
            dataset.setValue(" <= 18 años ", childList.size());
        }
        else if (genderRange == 1 && ageRange == 2) {
            for (int i = 0; i < femaleList.size(); i++) {
                if (youthList.contains(femaleList.get(i))) 
                    youthList.remove(i);
            }
            dataset.setValue(" 19 a 35 años ", youthList.size());
        }
        else if (genderRange == 1 && ageRange == 3) {
            for (int i = 0; i < femaleList.size(); i++) {
                if (adultList.contains(femaleList.get(i))) 
                    adultList.remove(i);
            }
            dataset.setValue(" 36 a 65 años ", adultList.size());
        }
        else if (genderRange == 1 && ageRange == 4) {
            for (int i = 0; i < femaleList.size(); i++) {
                if (elderList.contains(femaleList.get(i))) 
                    elderList.remove(i);
            }
            dataset.setValue(" 66 >= años ", elderList.size());
        }
        else if (genderRange == 2 && ageRange == 1) {
            for (int i = 0; i < maleList.size(); i++) {
                if (childList.contains(maleList.get(i))) 
                    childList.remove(i);
            }
            dataset.setValue(" <= 18 años ", childList.size());
        }
        else if (genderRange == 2 && ageRange == 2) {
            for (int i = 0; i < maleList.size(); i++) {
                if (youthList.contains(maleList.get(i))) 
                    youthList.remove(i);
            }
            dataset.setValue(" 19 a 35 años ", youthList.size());
        }
        else if (genderRange == 2 && ageRange == 3) {
            for (int i = 0; i < maleList.size(); i++) {
                if (adultList.contains(femaleList.get(i))) 
                    adultList.remove(i);
            }
            dataset.setValue(" 35 a 55 años ", adultList.size());
        }
        else if (genderRange == 2 && ageRange == 4) {
            for (int i = 0; i < maleList.size(); i++) {
                if (elderList.contains(maleList.get(i))) 
                    elderList.remove(i);
            }
            dataset.setValue(" 66 >= años ", elderList.size());
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
        AgeFilter = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Age_FilterButton = new javax.swing.JRadioButton();
        Gender_FilterButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

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
            .addGap(0, 477, Short.MAX_VALUE)
        );
        GraphicUsersPanelLayout.setVerticalGroup(
            GraphicUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        GenderFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Hombre", "Mujer" }));

        AgeFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "18 años o menos", "19 a 35 años", "36 a 65 años", "66 años o más" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Área de Graficado");

        Age_FilterButton.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        Age_FilterButton.setForeground(new java.awt.Color(255, 255, 255));
        Age_FilterButton.setText("Filtro por Edad");
        Age_FilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Age_FilterButtonActionPerformed(evt);
            }
        });

        Gender_FilterButton.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        Gender_FilterButton.setForeground(new java.awt.Color(255, 255, 255));
        Gender_FilterButton.setText("Filtro por Género");
        Gender_FilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Gender_FilterButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Filtros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(GenderFilter, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Gender_FilterButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                    .addComponent(AgeFilter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(GraphicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Age_FilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GraphicUsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(406, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(GraphicUsersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Gender_FilterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(GenderFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Age_FilterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AgeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(GraphicButton)
                        .addGap(27, 27, 27)
                        .addComponent(BackButton)))
                .addGap(27, 27, 27))
        );

        GraphicButton.getAccessibleContext().setAccessibleParent(GraphicButton);
    }// </editor-fold>//GEN-END:initComponents

    private void GraphicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicButtonActionPerformed
        int genderRange = GenderFilter.getSelectedIndex();
        int ageRange = AgeFilter.getSelectedIndex();
        
        
        showUserChart(genderRange, ageRange);
    }//GEN-LAST:event_GraphicButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        mainFrame.showPage("AdminPage", this.previous);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void Age_FilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Age_FilterButtonActionPerformed
        // TODO add your handling code here:
        if(Gender_FilterButton.isSelected())
        GenderFilter.setVisible(true);
        else
        GenderFilter.setVisible(false);
    }//GEN-LAST:event_Age_FilterButtonActionPerformed

    private void Gender_FilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Gender_FilterButtonActionPerformed
        // TODO add your handling code here:
        if(Age_FilterButton.isSelected())
        AgeFilter.setVisible(true);
        else
        AgeFilter.setVisible(false);
    }//GEN-LAST:event_Gender_FilterButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AgeFilter;
    private javax.swing.JRadioButton Age_FilterButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> GenderFilter;
    private javax.swing.JRadioButton Gender_FilterButton;
    private javax.swing.JButton GraphicButton;
    private javax.swing.JPanel GraphicUsersPanel;
    private javax.swing.JPanel PTitle;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
