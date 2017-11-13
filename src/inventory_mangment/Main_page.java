/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_mangment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hamza Imtiaz
 */
public class Main_page extends javax.swing.JFrame {

    /**
     * Creates new form Main_page
     */
    public Main_page() throws SQLException {
        initComponents();
        populate_sales(); //Code to Populate Sales Tab
        populate_purchase();//Code to Populate Purchase
        populate_inventory();//Code to Populate Purchase
        
    }
    
    public void populate_sales() throws SQLException
    {
       ResultSet rs1=null;
           PreparedStatement pst = null;
        
            /*if(check.equals("Date"))
            {
            pst = login.conn.prepareStatement("Select Date,Tyre_name ,Tyre_size,Quantity,Price_per_tyre,total_price,invoice_no,Detail,invoice_detail,companies_list.payment_due from stock join companies_list on stock.company_name=companies_list.Company_name where check_date=? and stock.company_name=?");
             pst.setString(1,  Date);
              pst.setString(2,  company_name);
            }
            else if(check.equals("Between Two Dates"))
            {
                String Date1=Date.substring(0, 10);
                String Date2=Date.substring(11, 21);
                
                System.out.println(Date1);
                System.out.println(Date2);
                pst = login.conn.prepareStatement("Select Date,Tyre_name ,Tyre_size,Quantity,Price_per_tyre,total_price,invoice_no,Detail,invoice_detail,companies_list.payment_due from stock join companies_list on stock.company_name=companies_list.Company_name where check_date between ? and ? and stock.company_name=?");
             pst.setString(1,  Date1);
              pst.setString(2,  Date2);
              pst.setString(3,  company_name);
             
            }
            else
            {*/
                
                 pst = login.conn.prepareStatement("Select ID , Quantity ,Categroy, Amount from sales ");
            
            
       
      
        try {
           
             rs1 = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(sales_table.getRowCount() > 0) 
        {
            ((DefaultTableModel) sales_table.getModel()).removeRow(0);
        }
       int columns=0;
        try {
            columns = rs1.getMetaData().getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs1.next())
            {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {
                    row[i - 1] = rs1.getObject(i);
                }
                ((DefaultTableModel) sales_table.getModel()).insertRow(rs1.getRow()-1,row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs1.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
     
         
    }
    
    public void populate_purchase() throws SQLException
    {
        {
       ResultSet rs1=null;
           PreparedStatement pst = null;
        
            /*if(check.equals("Date"))
            {
            pst = login.conn.prepareStatement("Select Date,Tyre_name ,Tyre_size,Quantity,Price_per_tyre,total_price,invoice_no,Detail,invoice_detail,companies_list.payment_due from stock join companies_list on stock.company_name=companies_list.Company_name where check_date=? and stock.company_name=?");
             pst.setString(1,  Date);
              pst.setString(2,  company_name);
            }
            else if(check.equals("Between Two Dates"))
            {
                String Date1=Date.substring(0, 10);
                String Date2=Date.substring(11, 21);
                
                System.out.println(Date1);
                System.out.println(Date2);
                pst = login.conn.prepareStatement("Select Date,Tyre_name ,Tyre_size,Quantity,Price_per_tyre,total_price,invoice_no,Detail,invoice_detail,companies_list.payment_due from stock join companies_list on stock.company_name=companies_list.Company_name where check_date between ? and ? and stock.company_name=?");
             pst.setString(1,  Date1);
              pst.setString(2,  Date2);
              pst.setString(3,  company_name);
             
            }
            else
            {*/
                
                 pst = login.conn.prepareStatement("Select ID ,Categroy, Quantity , Amount from purchases ");
            
            
       
      
        try {
           
             rs1 = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(purchase_table.getRowCount() > 0) 
        {
            ((DefaultTableModel) purchase_table.getModel()).removeRow(0);
        }
       int columns=0;
        try {
            columns = rs1.getMetaData().getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs1.next())
            {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {
                    row[i - 1] = rs1.getObject(i);
                }
                ((DefaultTableModel) purchase_table.getModel()).insertRow(rs1.getRow()-1,row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs1.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
     
         
    }
    }
    
    public void populate_inventory() throws SQLException
    {
        {
        {
       ResultSet rs1=null;
           PreparedStatement pst = null;
        
            /*if(check.equals("Date"))
            {
            pst = login.conn.prepareStatement("Select Date,Tyre_name ,Tyre_size,Quantity,Price_per_tyre,total_price,invoice_no,Detail,invoice_detail,companies_list.payment_due from stock join companies_list on stock.company_name=companies_list.Company_name where check_date=? and stock.company_name=?");
             pst.setString(1,  Date);
              pst.setString(2,  company_name);
            }
            else if(check.equals("Between Two Dates"))
            {
                String Date1=Date.substring(0, 10);
                String Date2=Date.substring(11, 21);
                
                System.out.println(Date1);
                System.out.println(Date2);
                pst = login.conn.prepareStatement("Select Date,Tyre_name ,Tyre_size,Quantity,Price_per_tyre,total_price,invoice_no,Detail,invoice_detail,companies_list.payment_due from stock join companies_list on stock.company_name=companies_list.Company_name where check_date between ? and ? and stock.company_name=?");
             pst.setString(1,  Date1);
              pst.setString(2,  Date2);
              pst.setString(3,  company_name);
             
            }
            else
            {*/
                
                 pst = login.conn.prepareStatement("select Item,Categroy,stock\n" +
"from purchases\n" +
"WHERE ID= \n" +
"(\n" +
"    select max(ID)\n" +
"from purchases\n" +
"group by Item,Categroy\n" +
")\n" +
"group by Item,Categroy ");
            
            
       
      
        try {
           
             rs1 = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(inventory_table.getRowCount() > 0) 
        {
            ((DefaultTableModel) inventory_table.getModel()).removeRow(0);
        }
       int columns=0;
        try {
            columns = rs1.getMetaData().getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs1.next())
            {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {
                    row[i - 1] = rs1.getObject(i);
                }
                ((DefaultTableModel) inventory_table.getModel()).insertRow(rs1.getRow()-1,row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs1.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
     
         
    }
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

        Sales_tab = new javax.swing.JTabbedPane();
        sales_tab = new javax.swing.JScrollPane();
        sales_table = new javax.swing.JTable();
        Purchase_tab = new javax.swing.JScrollPane();
        purchase_table = new javax.swing.JTable();
        Inventory = new javax.swing.JScrollPane();
        inventory_table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sales_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Quantity", "Category", "Amount"
            }
        ));
        sales_tab.setViewportView(sales_table);

        Sales_tab.addTab("Sales", sales_tab);

        purchase_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Category", "Quantity", "Amount"
            }
        ));
        Purchase_tab.setViewportView(purchase_table);

        Sales_tab.addTab("Purchase", Purchase_tab);

        inventory_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Category", "Item", "Stock"
            }
        ));
        Inventory.setViewportView(inventory_table);

        Sales_tab.addTab("Inventory", Inventory);

        jLabel1.setText("<html> <u>Add Category</u> </html>");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("<html> <u>Add Item</u> </html>");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jLabel3.setText("<html> <u>Add Purchase</u> </html>");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setText("<html> <u>Add Sale</u> </html>");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Sales_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(Sales_tab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        add_category obj=null;
        try {
            obj = new add_category();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.setVisible(true);
      //  this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        
        add_item obj=null;
         try {
            obj = new add_item();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
         add_purchase obj=null;
         
        
        try {
            obj= new add_purchase();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
          obj.setVisible(true);
      //  this.setVisible(false);
        
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
         add_sale obj=null;
         
        
        try {
            obj= new add_sale();
        } catch (SQLException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
          obj.setVisible(true);
       // this.setVisible(false);
        
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main_page().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Inventory;
    private javax.swing.JScrollPane Purchase_tab;
    private javax.swing.JTabbedPane Sales_tab;
    private javax.swing.JTable inventory_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable purchase_table;
    private javax.swing.JScrollPane sales_tab;
    private javax.swing.JTable sales_table;
    // End of variables declaration//GEN-END:variables
}
