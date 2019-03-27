/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ProductCategoryDao;
import Dao.ProductPurchaseDao;
import Dao.ProductSalesDao;
import Dao.SummaryDao;
import DaoImp.ProductCategoryDaoImp;
import DaoImp.ProductPurchaseDaoImp;
import DaoImp.ProductSalesDaoImp;
import DaoImp.SummaryDaoImp;
import Pojo.ProductCategory;
import Pojo.ProductPurchase;
import Pojo.ProductSales;
import Pojo.Summary;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ProductSalesView extends javax.swing.JFrame {

    /**
     * Creates new form ProductPurchaseView
     */
    public ProductSalesView() {
        initComponents();
    }

   
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) jTableProductSalesView.getModel();
        model.setRowCount(0);
    }
    public void displayDataIntoTable(){
        ProductSalesDao psDao = new ProductSalesDaoImp();
        ProductPurchaseDao p = new ProductPurchaseDaoImp();
        ProductCategoryDao catDao = new ProductCategoryDaoImp();
        SummaryDao summDao = new SummaryDaoImp();
        List<Summary> list = summDao.getList();
        DefaultTableModel model = (DefaultTableModel) jTableProductSalesView.getModel();
        Object[] cols = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            cols[0] = list.get(i).getId();
            cols[1] = list.get(i).getProductName();
            cols[2] = list.get(i).getProductCode();
            cols[3] = list.get(i).getTotalQty();
            cols[4] = list.get(i).getSoldQty();
            cols[5] = list.get(i).getAvailableQty();
            ProductPurchase pp = p.getProductPurchaseByProductCode(list.get(i).getProductCode());
            ProductCategory pc = catDao.getProductCategoryById(pp.getProductCategory().getId());
            cols[6] = pc.getCatName();
            model.addRow(cols);
           
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldProductName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductSalesView = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldProductCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAvailabelQuantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSalesQuantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTotalPrice = new javax.swing.JTextField();
        jButtonSales = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldUnitPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Product Sales View");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel1)
                .addContainerGap(412, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Prdouct Name:");

        jTextFieldProductName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTableProductSalesView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "P.Code", "Available Quantity", "Sold Quantity", "Unit Price", "Date", "Category"
            }
        ));
        jScrollPane1.setViewportView(jTableProductSalesView);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Prdouct Code:");

        jTextFieldProductCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Available Quantity:");

        jTextFieldAvailabelQuantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Sales Quantity:");

        jTextFieldSalesQuantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Total Price:");

        jTextFieldTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButtonSales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSales.setText("Sales");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Unit Price:");

        jTextFieldUnitPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldAvailabelQuantity)
                    .addComponent(jTextFieldProductCode, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jTextFieldSalesQuantity)
                    .addComponent(jTextFieldProductName)
                    .addComponent(jTextFieldTotalPrice)
                    .addComponent(jTextFieldUnitPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jButtonSales)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldAvailabelQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldSalesQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jButtonSales)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ProductSalesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductSalesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductSalesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductSalesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductSalesView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductSalesView;
    private javax.swing.JTextField jTextFieldAvailabelQuantity;
    private javax.swing.JTextField jTextFieldProductCode;
    private javax.swing.JTextField jTextFieldProductName;
    private javax.swing.JTextField jTextFieldSalesQuantity;
    private javax.swing.JTextField jTextFieldTotalPrice;
    private javax.swing.JTextField jTextFieldUnitPrice;
    // End of variables declaration//GEN-END:variables
}