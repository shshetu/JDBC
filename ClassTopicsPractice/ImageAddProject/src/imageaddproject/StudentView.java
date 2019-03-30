/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageaddproject;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author User
 */
public class StudentView extends javax.swing.JFrame {

    /**
     * Creates new form StudentView
     */
    public StudentView() {
        initComponents();
        new StudentDaoImp().createTable();
        displayDataIntoTable();
    }

    public void displayDataIntoTable() {
        File src = new File("images\\shetu.jpg"); ///create a file object where we will add file
        try {
            BufferedImage img = ImageIO.read(src); //BufferedImage class to process the image
            Image newImage = img.getScaledInstance(100, 120, Image.SCALE_SMOOTH);
            jLabelimage.setIcon(new ImageIcon(newImage, "shetu's pic"));
            String[] title = {"ID", "Name", "Photo"};
            DefaultTableModel model = new DefaultTableModel(null, title) {
                @Override
                public Class<?> getColumnClass(int column) {
                    if (column == 2) {
                        return ImageIcon.class;
                    }
                    return Object.class;
                }
            };
            //override method

            ///////
            Object cols[] = new Object[3];
            StudentDao dao = new StudentDaoImp();
            List<Student> list = dao.getStudent();
            for (int i = 0; i < list.size(); i++) {
                cols[0] = list.get(i).getId();
                cols[1] = list.get(i).getName();
                System.out.println("Image: " + list.get(i).getPhoto());
                cols[2] = new ImageIcon(list.get(i).getPhoto());
                model.addRow(cols);
            }
            jTableImage.setModel(model);
            if (list.size() > 0) {
                jLabelimage.setIcon(new ImageIcon(list.get(2).getPhoto()));
            }
        } catch (Exception e) {
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

        jLabel1 = new javax.swing.JLabel();
        jTextFieldFileName = new javax.swing.JTextField();
        jButtonChooseAFile = new javax.swing.JButton();
        jLabelimage = new javax.swing.JLabel();
        jButtonUpload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableImage = new javax.swing.JTable();
        jTextFieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Photo");

        jTextFieldFileName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldFileName.setText("File Name");

        jButtonChooseAFile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonChooseAFile.setText("Choose A File");
        jButtonChooseAFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseAFileActionPerformed(evt);
            }
        });

        jButtonUpload.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonUpload.setText("Upload");
        jButtonUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUploadActionPerformed(evt);
            }
        });

        jTableImage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableImage.setRowHeight(230);
        jScrollPane1.setViewportView(jTableImage);

        jTextFieldName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(jTextFieldFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonChooseAFile)
                        .addGap(35, 35, 35)
                        .addComponent(jButtonUpload))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelimage, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(44, 44, 44)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonChooseAFile)
                    .addComponent(jButtonUpload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelimage, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    String source = "";
    String filename = "";
    String destination = "images";
    private void jButtonUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUploadActionPerformed
        // TODO add your handling code here:
         try {
            StudentDao dao = new StudentDaoImp();

            File source = new File(this.source);
            File dest = new File(destination);
            FileUtils.copyFileToDirectory(source, dest);
            File fileForSave = new File(destination + "/" + filename); //save
            Student student = new Student("Mr. Trump", fileForSave.getAbsoluteFile().toString(), dest.getName());
            dao.insert(student, fileForSave);
            displayDataIntoTable();
            JOptionPane.showMessageDialog(null, "Upload Success");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButtonUploadActionPerformed

    private void jButtonChooseAFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseAFileActionPerformed
        // TODO add your handling code here:
       JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            source = selectedFile.getAbsolutePath();
            filename = selectedFile.getName();
            System.out.println(selectedFile.getAbsolutePath());
          

            try {
                BufferedImage img = ImageIO.read(selectedFile);
                Image newImg = img.getScaledInstance(100, 120, Image.SCALE_SMOOTH);
                //  lblPhoto.setIcon(new javax.swing.ImageIcon(selectedFile.getAbsolutePath()));//Okay
                jLabelimage.setIcon(new javax.swing.ImageIcon(newImg, ""));

            } catch (IOException ex) {
                Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButtonChooseAFileActionPerformed

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
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChooseAFile;
    private javax.swing.JButton jButtonUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelimage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableImage;
    private javax.swing.JTextField jTextFieldFileName;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}