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
        ArrayList<Person> childListM = new ArrayList<>();
        ArrayList<Person> youthListM = new ArrayList<>();
        ArrayList<Person> adultListM = new ArrayList<>();
        ArrayList<Person> elderListM = new ArrayList<>();
        
        for (int i = 0; i < users.size(); i++) {
            // Datos de la persona
            Person user = users.get(i);
            int gender = user.getId_gender();
            //System.out.println(user.getId_gender());
            int year = Integer.parseInt(user.getBirthDate().substring(0, 4));
            int age = 2024 - year;
            
            if (gender == 1) maleList.add(user);
            if (gender == 2) femaleList.add(user);
            if (age <= 18) childList.add(user);
            else if (age <= 35) youthList.add(user);
            else if (age <= 65) adultList.add(user);
            else if (age >= 66) elderList.add(user);
            if (age <= 18 && gender == 1) childListM.add(user);
            else if (age <= 35 && gender == 1) youthListM.add(user);
            else if (age <= 65 && gender == 1) adultListM.add(user);
            else if (age >= 66 && gender == 1) elderListM.add(user);
        }
       
        // Asignar datos por filtro
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        // No Filters being Applied
        if (genderRange == -1 && ageRange == -1) {
            dataset.setValue("Todos", users.size());
        }
        else if (genderRange != -1 && ageRange == -1) {
            dataset.setValue("Hombes", maleList.size());
            dataset.setValue("Mujeres", femaleList.size());
        }
        else if (genderRange == -1 && ageRange != -1) {
            dataset.setValue(" <= 18 años ", childList.size());
            dataset.setValue(" 19 a 35 años ", youthList.size());
            dataset.setValue(" 36 a 65 años ", adultList.size());
            dataset.setValue(" 66 >= años ", elderList.size());
        }
        
        // All Combinations
        else if (genderRange == 0 && ageRange == 0) {
            dataset.setValue("Hombres, <= 18 años ", childListM.size());
            dataset.setValue("Hombres, 19 a 35 años ", youthListM.size());
            dataset.setValue("Hombres, 36 a 65 años ", adultListM.size());
            dataset.setValue("Hombres, 66 >= años ", elderListM.size());
            dataset.setValue("Mujeres, <= 18 años ", childList.size() - childListM.size());
            dataset.setValue("Mujeres, 19 a 35 años ", youthList.size() - youthListM.size());
            dataset.setValue("Mujeres, 36 a 65 años ", adultList.size() - adultListM.size());
            dataset.setValue("Mujeres, 66 >= años ", elderList.size() - elderListM.size());
        }
        else if (genderRange == 1 && ageRange == 0) {
            dataset.setValue("Hombres, <= 18 años ", childListM.size());
            dataset.setValue("Hombres, 19 a 35 años ", youthListM.size());
            dataset.setValue("Hombres, 36 a 65 años ", adultListM.size());
            dataset.setValue("Hombres, 66 >= años ", elderListM.size());
        }
        else if (genderRange == 2 && ageRange == 0) {
            dataset.setValue("Mujeres, <= 18 años ", childList.size() - childListM.size());
            dataset.setValue("Mujeres, 19 a 35 años ", youthList.size() - youthListM.size());
            dataset.setValue("Mujeres, 36 a 65 años ", adultList.size() - adultListM.size());
            dataset.setValue("Mujeres, 66 >= años ", elderList.size() - elderListM.size());
        }
        else if (genderRange == 0 && ageRange == 1) {
            dataset.setValue("Hombres, <= 18 años ", childListM.size());
            dataset.setValue("Mujeres, <= 18 años ", childList.size() - childListM.size());
        }
        else if (genderRange == 0 && ageRange == 2) {
            dataset.setValue("Hombres, 19 a 35 años ", youthListM.size());
            dataset.setValue("Mujeres, 19 a 35 años ", youthList.size() - youthListM.size());
        }
        else if (genderRange == 0 && ageRange == 3) {
            dataset.setValue("Hombres, 36 a 65 años ", adultListM.size());
            dataset.setValue("Mujeres, 36 a 65 años ", adultList.size() - adultListM.size());
        }
        else if (genderRange == 0 && ageRange == 4) {
            dataset.setValue("Hombres, 66 >= años ", elderListM.size());
            dataset.setValue("Mujeres, 66 >= años ", elderList.size() - elderListM.size());
        }
        else if (genderRange == 1 && ageRange == 1) {
            dataset.setValue("Hombres, <= 18 años ", childListM.size());
        }
        else if (genderRange == 2 && ageRange == 1) {
            dataset.setValue("Mujeres, <= 18 años ", childList.size() - childListM.size());
        }
        else if (genderRange == 1 && ageRange == 2) {
            dataset.setValue("Hombres, 19 a 35 años ", youthListM.size());
        }
        else if (genderRange == 2 && ageRange == 2) {
            dataset.setValue("Mujeres, 19 a 35 años ", youthList.size() - youthListM.size());
        }
        else if (genderRange == 1 && ageRange == 3) {
            dataset.setValue("Hombres, 36 a 65 años ", adultListM.size());
        }
        else if (genderRange == 2 && ageRange == 3) {
            dataset.setValue("Mujeres, 36 a 65 años ", adultList.size() - adultListM.size());
        }
        else if (genderRange == 1 && ageRange == 4) {
            dataset.setValue("Hombres, 66 >= años ", elderListM.size());
        }
        else if (genderRange == 2 && ageRange == 4) {
            dataset.setValue("Mujeres, 66 >= años ", elderList.size() - elderListM.size());
        }
            
        JFreeChart piechart = ChartFactory.createPieChart(
            "Usuarios del Sistema",
            dataset,
            true,
            true,
            false
        );
        
        ChartPanel panel = new ChartPanel(piechart);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(470, 415));
        
        GraphicUsersPanel.setLayout(new BorderLayout());
        GraphicUsersPanel.add(panel, BorderLayout.NORTH);
        
        mainFrame.pack();
        repaint();
        }                                             

        catch (Exception e) {
            mainFrame.showError("Error al leer de la base de datos.");
            System.out.println(e.getMessage());
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
        Age_FilterButton = new javax.swing.JRadioButton();
        Gender_FilterButton = new javax.swing.JRadioButton();

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
                .addContainerGap(370, Short.MAX_VALUE))
        );
        PTitleLayout.setVerticalGroup(
            PTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
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
            .addGap(0, 450, Short.MAX_VALUE)
        );
        GraphicUsersPanelLayout.setVerticalGroup(
            GraphicUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        GenderFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Hombre", "Mujer" }));

        AgeFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "18 años o menos", "19 a 35 años", "36 a 65 años", "66 años o más" }));

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
                        .addComponent(Age_FilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GraphicUsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(Gender_FilterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(GenderFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Age_FilterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AgeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(GraphicButton)
                        .addGap(27, 27, 27)
                        .addComponent(BackButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GraphicUsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        GraphicButton.getAccessibleContext().setAccessibleParent(GraphicButton);
    }// </editor-fold>//GEN-END:initComponents

    private void GraphicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicButtonActionPerformed
        GraphicUsersPanel.removeAll();
        GraphicButton.setVisible(false);
        int genderRange = GenderFilter.getSelectedIndex();
        int ageRange = AgeFilter.getSelectedIndex();
        
        if (!Gender_FilterButton.isSelected()) genderRange = -1;
        if (!Age_FilterButton.isSelected()) ageRange = -1;
        
        showUserChart(genderRange, ageRange);
    }//GEN-LAST:event_GraphicButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        mainFrame.showPage("AdminPage", this.previous);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void Age_FilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Age_FilterButtonActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_Age_FilterButtonActionPerformed

    private void Gender_FilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Gender_FilterButtonActionPerformed
        // TODO add your handling code here
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
    // End of variables declaration//GEN-END:variables
}
