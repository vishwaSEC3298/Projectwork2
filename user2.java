
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author siva
 */
public class user2 extends javax.swing.JFrame {

    /**
     * Creates new form user
     */
    public user2() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        cb2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("user 2");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 10, 80, 20);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 60, 550, 96);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "reliance", "tata", "cts", "litl" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(30, 180, 250, 30);

        jButton1.setText("buy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 230, 80, 30);

        jButton2.setText("sell");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 230, 110, 30);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(510, 190, 120, 30);

        jButton3.setText("message");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(520, 240, 110, 30);

        cb2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "high", "medium", "low" }));
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });
        getContentPane().add(cb2);
        cb2.setBounds(320, 190, 140, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 660, 290);

        setSize(new java.awt.Dimension(679, 338));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        sell();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        buy();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        fbsend();
        fbssend();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb2ActionPerformed
Socket s;
     public void fbsend()
    {
        int alll =0 ;
        String ipad="";
        try
        {
            String s1 = cb2.getSelectedItem().toString();
            if(s1.equals("high"))
            {
                ipad = "";//System IP
                alll=6005;
            }
            
            if(s1.equals("medium"))
            {ipad = "";//System IP
                alll=6006;
            }
            if(s1.equals("low"))
            {ipad = "";//System IP
                alll=6007;
            }
            
             s=new Socket(ipad,alll);
            System.out.println("connect");
       
          
       ObjectOutputStream out=new ObjectOutputStream(s.getOutputStream());
          Vector a = new Vector() ;
       a.add(0,jTextField1.getText());
     
       
       out.writeObject(a);
       
        ObjectInputStream inn=new ObjectInputStream(s.getInputStream());
                        String b =(String) inn.readObject();
                        System.out.println(b);
    
	out.flush();
	out.close();
	s.close();
        
        
                
        
        }
        catch( Exception exe)
        {
            System.out.println(exe+"fbex");
        }
    }
     
     
    
 
     public void fbssend()
    {
        try
        {
            String ipad="";
            ipad = "192.168.105.143";
             s=new Socket(ipad,6001);
            System.out.println("connect");
       
          
       ObjectOutputStream out=new ObjectOutputStream(s.getOutputStream());
          Vector a = new Vector() ;
       a.add(0,jTextField1.getText());
     
       
       out.writeObject(a);
       
       
       
       
        ObjectInputStream inn=new ObjectInputStream(s.getInputStream());
                        String b =(String) inn.readObject();
                        System.out.println(b);
    
	out.flush();
	out.close();
	s.close();
        
        
                
        
        }
        catch( Exception exe)
        {
            System.out.println(exe+"fbex");
        }
    }
     
     
    
    
    
    
    public void buy()
    
    {
try
{
           String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
           Class.forName("com.mysql.jdbc.Driver");
           String DB_URL = "jdbc:mysql://localhost:3306/soft_smart_home?autoReconnect=true";
           Connection conn = DriverManager.getConnection(DB_URL,"root","system");
           
             PreparedStatement ps;
            String sql;
            sql="insert into share values(?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"user2");
            ps.setString(2,(jComboBox1.getSelectedItem()+""));
            ps.setString(3,jTextField1.getText());
            ps.setString(4,"0");     
            ps.executeUpdate();
            
    
}
catch(Exception ex)
{
System.out.println(ex);
}
}
    
    
    
    /////////////////////////////////////
    
     public void sell()
    
    {
try
{
      String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
           Class.forName("com.mysql.jdbc.Driver");
           String DB_URL = "jdbc:mysql://localhost:3306/soft_smart_home?autoReconnect=true";
           Connection conn = DriverManager.getConnection(DB_URL,"root","system");
           
             PreparedStatement ps;
            String sql;
            sql="insert into share values(?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"user2");
            ps.setString(2,(jComboBox1.getSelectedItem()+""));
            ps.setString(3,"0");
            ps.setString(4,jTextField1.getText());     
            ps.executeUpdate();
    
}
catch(Exception ex)
{
System.out.println(ex);
}
}
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
