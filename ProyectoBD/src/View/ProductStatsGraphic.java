/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Control.Cursors;
import Model.Movie;
import Model.Person;
import Model.Series;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class ProductStatsGraphic extends javax.swing.JPanel {
    MainFrame mainFrame;
    JPanel previous;
    

    
    public ProductStatsGraphic(MainFrame mainFrame, JPanel previous) {
        this.mainFrame = mainFrame;
        this.previous = previous;
        initComponents();
    }
    
    public void showProductChart(String category) {
        try {
        
        // Obtener datos
        ArrayList<Movie> movies = Cursors.getMovies();
        ArrayList<Series> series = Cursors.getSeries();
        int moviesXcategory = 0;
        int seriesXcategory = 0;
        
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            System.out.println(m.getIdProduct());
            if (category.equals(Cursors.getProductCategory(m.getIdProduct()))) {
                moviesXcategory++;
            }
        }
        for (int i = 0; i < series.size(); i++) {
            Series s = series.get(i);
            if (category.equals(Cursors.getProductCategory(s.getIdProduct()))) {
                seriesXcategory++;
            }
        }
       
        // Asignar datos por filtro
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        if (category == null) {
            dataset.setValue("Todas las películas", movies.size());
            dataset.setValue("Todas las series", series.size());
        }
        else {
            dataset.setValue("Películas de " + category, moviesXcategory);
            dataset.setValue("Series de " + category, seriesXcategory);
        }
        
        JFreeChart piechart = ChartFactory.createPieChart(
            "Productos del Sistema",
            dataset,
            true,
            true,
            false
        );
        
        ChartPanel panel = new ChartPanel(piechart);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(470, 415));
        
        GraphicProductsPanel.setLayout(new BorderLayout());
        GraphicProductsPanel.add(panel, BorderLayout.NORTH);
        
        mainFrame.pack();
        repaint();
        }                                             

        catch (Exception e) {
            mainFrame.showError("Error al leer de la base de datos.");
            System.out.println(e.getCause() + "\n");
            System.out.println(e.getStackTrace() + "\n");
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
        GraphicProductsPanel = new javax.swing.JPanel();
        CategoryFilter = new javax.swing.JComboBox<>();
        Category_FilterButton = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(0, 0, 0));

        PTitle.setBackground(new java.awt.Color(51, 51, 51));

        Title.setBackground(new java.awt.Color(51, 51, 51));
        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("Estadísticas de Productos");

        javax.swing.GroupLayout PTitleLayout = new javax.swing.GroupLayout(PTitle);
        PTitle.setLayout(PTitleLayout);
        PTitleLayout.setHorizontalGroup(
            PTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PTitleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout GraphicProductsPanelLayout = new javax.swing.GroupLayout(GraphicProductsPanel);
        GraphicProductsPanel.setLayout(GraphicProductsPanelLayout);
        GraphicProductsPanelLayout.setHorizontalGroup(
            GraphicProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        GraphicProductsPanelLayout.setVerticalGroup(
            GraphicProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        CategoryFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        Category_FilterButton.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        Category_FilterButton.setForeground(new java.awt.Color(255, 255, 255));
        Category_FilterButton.setText("Filtro por Categoría");
        Category_FilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Category_FilterButtonActionPerformed(evt);
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
                            .addComponent(CategoryFilter, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Category_FilterButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(GraphicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GraphicProductsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(Category_FilterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(CategoryFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181)
                        .addComponent(GraphicButton)
                        .addGap(27, 27, 27)
                        .addComponent(BackButton))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GraphicProductsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        GraphicButton.getAccessibleContext().setAccessibleParent(GraphicButton);
    }// </editor-fold>//GEN-END:initComponents

    private void GraphicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicButtonActionPerformed
        GraphicProductsPanel.removeAll();
        GraphicButton.setVisible(false);
        String category = (String) CategoryFilter.getSelectedItem().toString();
        if (!Category_FilterButton.isSelected()) category = null;
        
        showProductChart(category);
    }//GEN-LAST:event_GraphicButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        mainFrame.showPage("AdminPage", this.previous);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void Category_FilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Category_FilterButtonActionPerformed
        // TODO add your handling code here
        try {
            DefaultComboBoxModel categoriesModel = mainFrame.buildComboModel(Cursors.getCategoriesArr());
            CategoryFilter.setModel(categoriesModel);
        }
        catch (Exception e) {
            mainFrame.showError("Error al leer de la base de datos.");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_Category_FilterButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> CategoryFilter;
    private javax.swing.JRadioButton Category_FilterButton;
    private javax.swing.JButton GraphicButton;
    private javax.swing.JPanel GraphicProductsPanel;
    private javax.swing.JPanel PTitle;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}
