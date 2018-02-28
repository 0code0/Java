/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookgui;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.InboxResponseList;
import facebook4j.Message;
import facebook4j.conf.ConfigurationBuilder;

/**
 *
 * @author jaswinder
 */
public class Messages extends javax.swing.JFrame {

    /**
     * Creates new form Messages
     */
    public Messages() {
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
        BackButton = new javax.swing.JButton();
        GetMessageButton = new javax.swing.JButton();
        GetMessageTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        GetMessageTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Messages");

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        GetMessageButton.setText("Get Message");
        GetMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetMessageButtonActionPerformed(evt);
            }
        });

        GetMessageTextField.setText("User Id");

        GetMessageTextArea.setColumns(20);
        GetMessageTextArea.setRows(5);
        jScrollPane1.setViewportView(GetMessageTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                        .addComponent(BackButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(GetMessageButton)
                        .addGap(53, 53, 53)
                        .addComponent(GetMessageTextField)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BackButton)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GetMessageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GetMessageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        AllObjects allobject  = new AllObjects();
        allobject.setVisible(true);
        allobject.setLocationRelativeTo(null);
        
        this.setVisible(false);
        this.dispose();
        
    }//GEN-LAST:event_BackButtonActionPerformed

    private void GetMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetMessageButtonActionPerformed
        // TODO add your handling code here:
        ConfigurationBuilder cb = new ConfigurationBuilder();
     cb.setDebugEnabled(true)
    .setOAuthAppId(Home.AppId)
    .setOAuthAppSecret(Home.AppSecret)
    .setOAuthAccessToken(Home.AccessToken);
    
    FacebookFactory ff = new FacebookFactory(cb.build());
    Facebook facebook = ff.getInstance();
        
        
        try {
            if(GetMessageTextField.getText() == " "){
                
                InboxResponseList<Message> messages = facebook.getInbox();
                    
                for(Message message : messages){
                
                    GetMessageTextArea.append(message.getMessage() + "\n");
                }
            
            }else {
            
                InboxResponseList<Message> messages = facebook.getInbox(GetMessageTextField.getText());
            
                for (Message message : messages) {
                    
                    GetMessageTextArea.append(message.getMessage());
                }
            }
            
        } catch (Exception e) {
            
            GetMessageTextArea.append(e.getMessage());
        }
    
    
    }//GEN-LAST:event_GetMessageButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Messages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Messages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Messages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Messages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Messages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton GetMessageButton;
    private javax.swing.JTextArea GetMessageTextArea;
    private javax.swing.JTextField GetMessageTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}