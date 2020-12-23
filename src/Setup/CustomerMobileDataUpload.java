/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setup;

import MasterClass.BlockData;
import MasterClass.BranchData;
import MasterClass.CustomerData;
import MasterClass.CustomerMobileData;
import MasterClass.LocationData;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author chamod
 */
public class CustomerMobileDataUpload extends javax.swing.JInternalFrame {

    CustomerData customerData = new CustomerData();
    BranchData branchData = new BranchData();
    BlockData blockData = new BlockData();
    CustomerMobileData customerMobileData = new CustomerMobileData();
    LocationData locationData = new LocationData();

    /**
     * Creates new form Branch
     */
    public CustomerMobileDataUpload() {
        initComponents();
        ShowGrid();
    }

    private void ShowGrid() {
        String data[][] = null;
        String colu[] = new String[]{"TP", "Branch", "Location"};
        DefaultTableModel model = new DefaultTableModel(data, colu) {
            //@Override
            public boolean isCellEditable(int x, int y) {

//                if (y == 7 || y == 8) {
//                    return false;
//                } else {
                return true;
//                }

            }
        };

        tblGrid.setModel(model);
        tblGrid.getTableHeader().setPreferredSize(new Dimension(tblGrid.getTableHeader().getPreferredSize().width, 35));
        JTableHeader head = tblGrid.getTableHeader();
        head.setFont(head.getFont().deriveFont(Font.BOLD));

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
//        tblGrid.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
//        tblGrid.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
//        tblGrid.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);

        tblGrid.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        branch_save_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrid = new javax.swing.JTable();
        csv_file_path = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Data Uploder");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/a8975e3784874a1fc27d614bf86aa187.jpg"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(102, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setText("Upload Customer Data");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 200, 30));

        branch_save_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        branch_save_btn.setText("Save");
        branch_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branch_save_btnActionPerformed(evt);
            }
        });
        jPanel1.add(branch_save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 710, 160, 40));

        tblGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TP", "Branch", "Location"
            }
        ));
        tblGrid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGrid);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 1240, 570));
        jPanel1.add(csv_file_path, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 770, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Load CSV File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1325, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void branch_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branch_save_btnActionPerformed
        try {
            int rows = tblGrid.getRowCount();

            for (int i = 0; i < rows; i++) {

                DefaultTableModel model = (DefaultTableModel) tblGrid.getModel();
                String customer_mobile = model.getValueAt(i, 0).toString().trim();
                 String branch_name = model.getValueAt(i, 1).toString().trim();
                  String location_name = model.getValueAt(i, 2).toString().trim();
                
                

//                int sub_no = Integer.parseInt(model.getValueAt(i, 0).toString().trim());
//                String customer_name = model.getValueAt(i, 1).toString().trim();
//                String customer_tp = model.getValueAt(i, 2).toString().trim();
//                String customer_email = model.getValueAt(i, 3).toString().trim();
//                String date = model.getValueAt(i, 4).toString().trim();
//                String branch = model.getValueAt(i, 5).toString().trim();
//                String block_no = model.getValueAt(i, 6).toString().trim();

//                customerData.SaveCustomer(customer_name, customer_tp, customer_email, date, branch, block_no);
              

                if (branchData.searchBranch(branch_name).getBranch_name() == null) {
                    System.out.println("new Branch");
                    branchData.SaveBranch(branch_name, "000");
                } else {
                    System.out.println("Old Branch");
                }
                
                
                if (locationData.searchLocation(location_name).getLocation_name()== null) {
                    System.out.println("new Block");
                    locationData.SaveLocation(location_name);
                } else {
                    System.out.println("Old Block");
                }
                
                  customerMobileData.SaveCustomerMobileData(customer_mobile,branch_name,0,location_name,0);

            }

            JOptionPane.showMessageDialog(null, " Save Succesfull ");

            ShowGrid();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error in save");

        }
    }//GEN-LAST:event_branch_save_btnActionPerformed

    private void tblGridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridMouseClicked

    }//GEN-LAST:event_tblGridMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ShowGrid();

        JFileChooser file_chooser = new JFileChooser();
        file_chooser.showOpenDialog(null);
        File f = file_chooser.getSelectedFile();
        String filename_path = f.getAbsolutePath();
        csv_file_path.setText(filename_path);
        DefaultTableModel model = (DefaultTableModel) tblGrid.getModel();
        String line = "";
        String splitBy = ",";
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(filename_path));
            int no_of_records = 0;
            while ((line = br.readLine()) != null) //returns a Boolean value
            {
                if (no_of_records == 0) {
                    no_of_records++;
                    continue;
                }
                try {
                    String[] mobile_data = line.split(splitBy);    // use comma as separator
                    
                    String mobile_no = mobile_data[0] == null | "".equals(mobile_data[0]) ? "0" : mobile_data[0];
                    String branch = mobile_data[1] == null | "".equals(mobile_data[1]) ? "" : mobile_data[1];
                    String location = mobile_data[2] == null | "".equals(mobile_data[2]) ? "" : mobile_data[2];

                

                    model.addRow(new Object[]{mobile_no, branch, location});
                    no_of_records++;
                } catch (Exception e) {
                                        e.printStackTrace();
                    continue;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton branch_save_btn;
    private javax.swing.JTextField csv_file_path;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGrid;
    // End of variables declaration//GEN-END:variables
}
