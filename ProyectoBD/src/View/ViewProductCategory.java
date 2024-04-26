/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Control.*;
import Model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author Gabriel
 */
public class ViewProductCategory extends javax.swing.JPanel {
    MainFrame mainFrame;
    JPanel previous;
    Map<Integer, Integer> productCategories;
    Map<String, Integer> categories;
    
    public ViewProductCategory(MainFrame mainFrame, JPanel previous) {
        this.mainFrame = mainFrame;
        this.previous = previous;
        initComponents();
        this.initialzeProducts();
        this.initialzeCategories();
        this.initializeRelations();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PTitle = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        SelectedProduct = new javax.swing.JComboBox<>();
        SelectedCategory = new javax.swing.JComboBox<>();
        BackButton = new javax.swing.JButton();
        AddCategoryButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductCategoriesList = new javax.swing.JList<>();
        ProductLabel = new javax.swing.JLabel();
        CategoryLabel = new javax.swing.JLabel();
        DelButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(670, 485));

        PTitle.setBackground(new java.awt.Color(51, 51, 51));

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("Categorías de Productos");

        javax.swing.GroupLayout PTitleLayout = new javax.swing.GroupLayout(PTitle);
        PTitle.setLayout(PTitleLayout);
        PTitleLayout.setHorizontalGroup(
            PTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PTitleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        PTitleLayout.setVerticalGroup(
            PTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        SelectedProduct.setEditable(true);
        SelectedProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un producto" }));
        SelectedProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedProductActionPerformed(evt);
            }
        });

        SelectedCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoría" }));

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

        AddCategoryButton.setBackground(new java.awt.Color(51, 51, 51));
        AddCategoryButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddCategoryButton.setForeground(new java.awt.Color(204, 204, 204));
        AddCategoryButton.setText("Agregar");
        AddCategoryButton.setBorderPainted(false);
        AddCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCategoryButtonActionPerformed(evt);
            }
        });

        ProductCategoriesList.setBackground(new java.awt.Color(51, 51, 51));
        ProductCategoriesList.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ProductCategoriesList.setForeground(new java.awt.Color(255, 255, 255));
        ProductCategoriesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "No hay categorías disponibles" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ProductCategoriesList);

        ProductLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProductLabel.setForeground(new java.awt.Color(255, 255, 255));
        ProductLabel.setText("Productos");

        CategoryLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CategoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        CategoryLabel.setText("Categorías");

        DelButton.setBackground(new java.awt.Color(51, 51, 51));
        DelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DelButton.setForeground(new java.awt.Color(204, 204, 204));
        DelButton.setText("Eliminar");
        DelButton.setBorderPainted(false);
        DelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SelectedCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SelectedProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(CategoryLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(AddCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ProductLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(ProductLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SelectedProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CategoryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SelectedCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(AddCategoryButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(DelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(BackButton)
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SelectedProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedProductActionPerformed
        this.initializeRelations();
    }//GEN-LAST:event_SelectedProductActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        mainFrame.showPage("categoryPage", this.previous);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void AddCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCategoryButtonActionPerformed
        try {
            int product = ((Product) this.SelectedProduct.getSelectedItem()).getId();
            String name = (String) this.SelectedCategory.getSelectedItem();
            int category = this.categories.get(name);
            
            if (this.productCategories.containsKey(category)) {
                this.mainFrame.showError("El producto ya posee esta categoría");
                return;
                
            }
            
            Insertions.assignCategory(product, category);
            this.initializeRelations();
            
        } catch (Exception e) {
            System.out.println(e);
            
        }
        
    }//GEN-LAST:event_AddCategoryButtonActionPerformed

    private void DelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelButtonActionPerformed
        try{
            String category = this.ProductCategoriesList.getSelectedValue();
            int id = this.categories.get(category);
            Deletions.deleteCategory(this.productCategories.get(id));
        }
        catch (Exception e) {
            System.out.println("Failed to delete" + e);
        }
        this.initializeRelations();
    }//GEN-LAST:event_DelButtonActionPerformed

    
    public final void initialzeProducts() {
        try {
            ArrayList<Product> products = Cursors.getProducts();
            DefaultComboBoxModel model = this.mainFrame.buildComboModel(products);
            this.SelectedProduct.setModel(model);
            
        } catch (Exception e) {
            System.out.println("Couldn't fetch products: " + e);
            
        }
        
    }
    
    public final void initialzeCategories() {
        try {
            this.categories = Cursors.getCategories();
            DefaultComboBoxModel model = mainFrame.buildComboModel(new ArrayList<String>(this.categories.keySet()));
            this.SelectedCategory.setModel(model);
            
        } catch (Exception e) {
            System.out.println("Couldn't fetch categories: " + e);
            
        }
    }
    
    public final void initializeRelations() {
        try {
            int idProduct = ((Product) this.SelectedProduct.getSelectedItem()).getId();
            this.productCategories = Cursors.getProductCategory(idProduct);
            ArrayList<String> catList = new ArrayList();
            
            if (this.productCategories.isEmpty()) {
                catList.add("No hay categorías disponibles");
                
            }
            else {
                for (Map.Entry<String, Integer> category : this.categories.entrySet()) {
                    if (this.productCategories.containsKey(category.getValue())) {
                        catList.add(category.getKey());

                    }

                }
                
            }
            
            DefaultListModel model = this.mainFrame.buildListModel(catList);
            this.ProductCategoriesList.setModel(model);
            
        } catch (Exception e) {
            System.out.println("Couldn't fetch categories: " + e);
            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCategoryButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel CategoryLabel;
    private javax.swing.JButton DelButton;
    private javax.swing.JPanel PTitle;
    private javax.swing.JList<String> ProductCategoriesList;
    private javax.swing.JLabel ProductLabel;
    private javax.swing.JComboBox<String> SelectedCategory;
    private javax.swing.JComboBox<String> SelectedProduct;
    private javax.swing.JLabel Title;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}