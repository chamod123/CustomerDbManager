/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setup;

import MasterClass.BlockData;
import MasterClass.BranchData;
import MasterClass.Catagary1Data;
import MasterClass.CustomerData;
import MasterClass.CustomerMobileData;
import MasterClass.LocationData;
import java.awt.Component;
import popups.CustomerDataUpdate;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Cell;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author chamod
 */
public class CustomerMobileDataSearch extends javax.swing.JInternalFrame {

    CustomerData customerData = new CustomerData();
    BranchData branchData = new BranchData();
    BlockData blockData = new BlockData();
    LocationData locationData = new LocationData();
    CustomerMobileData customerMobileData = new CustomerMobileData();
    Catagary1Data catagary1Data = new Catagary1Data();

    /**
     * Creates new form Branch
     */
    public CustomerMobileDataSearch() {
        initComponents();
        load_branch();
        load_location();
        load_catagary_1();
        ShowGrid();
    }

    //data load to catagary 01
    private void load_catagary_1() {
        try {
            ResultSet set = catagary1Data.GetCatagary1();
            set.last();
            set.beforeFirst();
            while (set.next()) {
                String catagary_name = set.getString("catagary_name");
                catogary_select.addItem(catagary_name);
            }
            set.close();
            set = null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Catagary 01 Loading not complete ");
        }
    }

    private void load_branch() {
        try {
            ResultSet set = branchData.getBranch();
            set.last();
            set.beforeFirst();
            while (set.next()) {
                String branch_name = set.getString("branch_name");
                branch_select.addItem(branch_name);
            }
            set.close();
            set = null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Branch Loading not complete ");
        }
    }

    private void load_location() {
        try {
            ResultSet set = locationData.getLocation();
            set.last();
            set.beforeFirst();
            DefaultListModel dlmA = new DefaultListModel(); // For list A
            while (set.next()) {
                String block_no = set.getString("location_name");
//                location_select.addItem(block_no);

                dlmA.addElement(block_no);

//                location_m_select.addE;
            }
            location_m_select.setModel(dlmA);
            set.close();
            set = null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Block Loading not complete " + e);
        }
    }

    private void ShowGrid() {
        String data[][] = null;
        String colu[] = new String[]{"TP", "Branch", "Location", "Status", "Cuctomer mobile id", "Catogary"};
        DefaultTableModel model = new DefaultTableModel(data, colu) {
            //@Override
            public boolean isCellEditable(int x, int y) {

//                if (y == 7 || y == 8) {
                return false;
//                } else {
//                return true;
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

        TableColumn coloumn4 = tblGrid.getColumnModel().getColumn(4);
        coloumn4.setMinWidth(0);
        coloumn4.setPreferredWidth(0);
        coloumn4.setMaxWidth(0);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrid = new javax.swing.JTable();
        branch_save_btn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        customer_tp_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        branch_select = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        branch_save_btn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        location_m_select = new javax.swing.JList<>();
        catogary_select = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        status_select = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Mobile Data Filter");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/a8975e3784874a1fc27d614bf86aa187.jpg"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(102, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setText("Customer Data Filter");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 200, 30));

        tblGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TP", "Branch", "Location", "Status"
            }
        ));
        tblGrid.getTableHeader().setReorderingAllowed(false);
        tblGrid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGrid);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 1240, 480));

        branch_save_btn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        branch_save_btn1.setText("Export to CSV File");
        branch_save_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branch_save_btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(branch_save_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 710, 170, 40));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        customer_tp_txt.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel2.setText("Branch");

        branch_select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel4.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel4.setText("Locations");

        branch_save_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        branch_save_btn.setText("Search");
        branch_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branch_save_btnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel7.setText("Customer TP");

        jScrollPane2.setViewportView(location_m_select);

        catogary_select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel5.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel5.setText("category");

        jLabel8.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel8.setText("status");

        status_select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Numbers", "Active Only", "Deactivated Only" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(branch_select, 0, 363, Short.MAX_VALUE)
                            .addComponent(customer_tp_txt))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(status_select, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(catogary_select, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(branch_save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(branch_save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customer_tp_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(branch_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(catogary_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(status_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1240, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void branch_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branch_save_btnActionPerformed
        if (!"".equals(customer_tp_txt.getText().trim()) || branch_select.getSelectedIndex() != 0 || !location_m_select.isSelectionEmpty() || catogary_select.getSelectedIndex() != 0) {
            search_data();
        } else {
            JOptionPane.showMessageDialog(null, "Enter What do you want to search ");
        }

    }//GEN-LAST:event_branch_save_btnActionPerformed

    public void search_data() {
        ShowGrid();

        String customer_tp = customer_tp_txt.getText();
        String branch_name = branch_select.getSelectedItem().toString();
        String catogary_name = catogary_select.getSelectedItem().toString();
         int status_of_the_number = status_select.getSelectedIndex();
//        String location_name = location_select.getSelectedItem().toString();
//        boolean is_active = is_only_active.isSelected();

        List<String> location_names = location_m_select.getSelectedValuesList();
        System.out.println("location_names " + location_names);

        DefaultTableModel model = (DefaultTableModel) tblGrid.getModel();

        try {
            ResultSet set = customerMobileData.searchCustomerMobile(customer_tp, branch_name, location_names, catogary_name, status_of_the_number);
            set.last();
            set.beforeFirst();
            int x = 1;
            while (set.next()) {
//                String catagary_name = set.getString("catagary_name");

                model.addRow(new Object[]{set.getString("customer_mobile"), set.getString("branch_name"), set.getString("location_name"), set.getBoolean("status") ? "Active" : "Deactive", set.getString("id"), set.getString("catagary_name")});
            }
            set.close();
            set = null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mobile Data Loading not complete " + e);
        }
    }
    private void tblGridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridMouseClicked
        if (evt.getClickCount() == 2) {

            if ("Active".equals(tblGrid.getValueAt(tblGrid.getSelectedRow(), 3).toString())) {
                int result = JOptionPane.showConfirmDialog((Component) null, "Do you need to Block This number",
                        "alert", JOptionPane.OK_CANCEL_OPTION);

                if (result == 0) {
                    int val = customerMobileData.updateMobileStatus(tblGrid.getValueAt(tblGrid.getSelectedRow(), 4).toString(), 0);
                    if (val != 0) {
                        JOptionPane.showMessageDialog(null, "Number Blocked");
                    } else {
                        JOptionPane.showMessageDialog(null, "Number Blocked Not Complete");
                    }
                }

            } else {
                int result = JOptionPane.showConfirmDialog((Component) null, "Do you need to Activate This number",
                        "alert", JOptionPane.OK_CANCEL_OPTION);
                if (result == 0) {
                    int val = customerMobileData.updateMobileStatus(tblGrid.getValueAt(tblGrid.getSelectedRow(), 4).toString(), 1);
                    if (val != 0) {
                        JOptionPane.showMessageDialog(null, "Number Activated");
                    } else {
                        JOptionPane.showMessageDialog(null, "Number Activated Not Complete");
                    }
                }

            }

//            System.out.println("popup page came  >>>>>");
//            CustomerDataUpdate MAS = new CustomerDataUpdate(null, true, 1, tblGrid.getValueAt(tblGrid.getSelectedRow(), 7).toString().trim()) {
//                @Override
//                public void getSelectedValue(String Para1, String para2, String para3, String para4, String para5) {
//
//                }
//            };
//            MAS.setVisible(true);
//            MAS = null;
            search_data();
        }
    }//GEN-LAST:event_tblGridMouseClicked

    private void branch_save_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branch_save_btn1ActionPerformed

        try {
            String file_path = "";
            JFileChooser chose_file = new JFileChooser();
            chose_file.setMultiSelectionEnabled(true);
            chose_file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chose_file.setFileHidingEnabled(false);
            if (chose_file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                java.io.File f = chose_file.getSelectedFile();
                file_path = f.getPath();
                System.err.println(f.getPath());
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));

            HSSFWorkbook fWorkbook = new HSSFWorkbook();
            HSSFSheet fSheet = fWorkbook.createSheet("new Sheet");
            HSSFFont sheetTitleFont = fWorkbook.createFont();
            System.out.println(file_path + "\\contact_data_" + dtf.format(now) + ".xls");
            File file = new File(file_path + "\\contact_data_" + dtf.format(now) + ".xls");
            HSSFCellStyle cellStyle = fWorkbook.createCellStyle();

//            sheetTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            //sheetTitleFont.setColor();
            TableModel model = tblGrid.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {
                HSSFRow fRow = fSheet.createRow((short) i);
//                if ("Active".equals(model.getValueAt(i, 3).toString())) {
                for (int j = 0; j < 3; j++) {
                    HSSFCell cell = fRow.createCell((short) j);
                    cell.setCellValue(model.getValueAt(i, j).toString());
                    cell.setCellStyle(cellStyle);

                }
//                }
            }
            FileOutputStream fileOutputStream;
            fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
            fWorkbook.write(bos);
            bos.close();
            fileOutputStream.close();

            for (int i = 0; i < 3; i++) {
                HSSFRow fRow = fSheet.createRow((short) i);
//                if ("Active".equals(model.getValueAt(i, 3).toString())) {
                for (int j = 0; j < 3; j++) {
                    HSSFCell cell = fRow.createCell((short) j);
                    cell.setCellValue(model.getValueAt(i, j).toString());

                    System.out.println(model.getColumnName(j));
                }
//                }
            }
            JOptionPane.showMessageDialog(null, "Export completed to     " + file_path + "\\contact_data_" + dtf.format(now) + ".xls   ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Export not completed");
        }

    }//GEN-LAST:event_branch_save_btn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton branch_save_btn;
    private javax.swing.JButton branch_save_btn1;
    private javax.swing.JComboBox<String> branch_select;
    private javax.swing.JComboBox<String> catogary_select;
    private javax.swing.JTextField customer_tp_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> location_m_select;
    private javax.swing.JComboBox<String> status_select;
    private javax.swing.JTable tblGrid;
    // End of variables declaration//GEN-END:variables
}
