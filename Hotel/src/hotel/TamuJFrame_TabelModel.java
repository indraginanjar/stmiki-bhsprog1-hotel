/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TamuJFrame_Ok.java
 *
 * Created on Jul 9, 2011, 8:46:47 AM
 */
package hotel;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Indra Ginanjar
 */
public class TamuJFrame_TabelModel extends javax.swing.JFrame {

    java.sql.Statement stmt;
    java.sql.ResultSet tamuResultSet;
    String columnNames[] = new String[]{"NO. ID", "TAMU", "KAMAR"};
    //
    private DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    /** Creates new form TamuJFrame_Ok */
    public TamuJFrame_TabelModel() {
        initComponents();
        try {
            java.sql.Connection conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/dbhotel", "root", "root");
            this.stmt = conn.createStatement(
                    java.sql.ResultSet.TYPE_SCROLL_SENSITIVE,
                    java.sql.ResultSet.CONCUR_UPDATABLE);


        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        refreshResultSet();
        refreshTable();
        tamuTableMouseClicked(null);

        idTextField.setEditable(false);
        tamuTextField.setEditable(false);
        kamarTextField.setEditable(false);

        tamuTable.setModel(model);

    }

    private void refreshResultSet() {
        try {
            this.tamuResultSet = this.stmt.executeQuery(
                    "SELECT idtamu, namatamu, kamar FROM tamu");

        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void refreshTable() {
        String data[] = new String[3];
        try {
            tamuResultSet.beforeFirst();
            if (tamuResultSet != null) {
                model = new DefaultTableModel(columnNames, 0);  
                while (tamuResultSet.next()) {
                    data[0] = tamuResultSet.getString(1);
                    data[1] = tamuResultSet.getString(2);
                    data[2] = tamuResultSet.getString(3);
                    model.addRow(data);
                }
            }
            tamuTable.setModel(model);
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tamuScrollPane = new javax.swing.JScrollPane();
        tamuTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        tamuTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        kamarTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tamuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tamuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tamuTableMouseClicked(evt);
            }
        });
        tamuScrollPane.setViewportView(tamuTable);

        jLabel1.setText("No. ID");

        jLabel2.setText("Tamu");

        jLabel3.setText("Kamar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idTextField)
                    .addComponent(kamarTextField)
                    .addComponent(tamuTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tamuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(kamarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Batal");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        insertButton.setText("Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Indra Ginanjar 101100180");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(insertButton)
                        .addGap(18, 18, 18)
                        .addComponent(editButton)
                        .addGap(47, 47, 47)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tamuScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(cancelButton)
                    .addComponent(insertButton)
                    .addComponent(deleteButton))
                .addGap(18, 18, 18)
                .addComponent(tamuScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tamuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tamuTableMouseClicked
        int rowNum = this.tamuTable.getSelectedRow();
        if (rowNum != -1) {
            // Mas yang ini saya ganti jadi gak pake Tabel model lagi, datanya langsung aja 
            //diambil dari tabel
            this.idTextField.setText((String) tamuTable.getValueAt(rowNum, 0));
            this.tamuTextField.setText((String) tamuTable.getValueAt(rowNum, 1));
            this.kamarTextField.setText((String) tamuTable.getValueAt(rowNum, 2));
            try {
                this.tamuResultSet.absolute(rowNum + 1);
            } catch (java.sql.SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }//GEN-LAST:event_tamuTableMouseClicked

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        if (this.insertButton.getText().equals("Insert")) {
            this.insertButton.setText("Simpan");
            this.editButton.setEnabled(false);
            this.cancelButton.setEnabled(true);
            this.idTextField.setEditable(true);
            this.tamuTextField.setEditable(true);
            this.kamarTextField.setEditable(true);

            this.idTextField.setText(null);
            this.tamuTextField.setText(null);
            this.kamarTextField.setText(null);
            try {
                this.tamuResultSet.moveToInsertRow();
            } catch (java.sql.SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                this.tamuResultSet.updateString(
                        1, this.idTextField.getText());
                this.tamuResultSet.updateString(
                        2, this.tamuTextField.getText());
                this.tamuResultSet.updateString(
                        3, this.kamarTextField.getText());
                this.tamuResultSet.insertRow();
            } catch (java.sql.SQLException e) {
                System.out.println(e.getMessage());
            }
            this.insertButton.setText("Insert");
            this.editButton.setEnabled(true);
            this.cancelButton.setEnabled(false);
            this.idTextField.setEditable(false);
            this.tamuTextField.setEditable(false);
            this.kamarTextField.setEditable(false);
            this.refreshTable();
        }

    }//GEN-LAST:event_insertButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (this.editButton.getText().equals("Edit")) {
            this.editButton.setText("Simpan");
            this.insertButton.setEnabled(false);
            this.cancelButton.setEnabled(true);
            this.idTextField.setEditable(true);
            this.tamuTextField.setEditable(true);
            this.kamarTextField.setEditable(true);

        } else {
            try {
                this.tamuResultSet.updateString(
                        1, this.idTextField.getText());
                this.tamuResultSet.updateString(
                        2, this.tamuTextField.getText());
                this.tamuResultSet.updateString(
                        3, this.kamarTextField.getText());
                this.tamuResultSet.updateRow();
            } catch (java.sql.SQLException e) {
                System.out.println(e.getMessage());
            }
            this.editButton.setText("Edit");
            this.insertButton.setEnabled(true);
            this.cancelButton.setEnabled(false);
            this.idTextField.setEditable(false);
            this.tamuTextField.setEditable(false);
            this.kamarTextField.setEditable(false);
            this.refreshTable();
        }

    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            this.tamuResultSet.deleteRow();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        this.refreshTable();

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TamuJFrame_TabelModel().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField kamarTextField;
    private javax.swing.JScrollPane tamuScrollPane;
    private javax.swing.JTable tamuTable;
    private javax.swing.JTextField tamuTextField;
    // End of variables declaration//GEN-END:variables
}
