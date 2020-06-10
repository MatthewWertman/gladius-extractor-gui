
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.console;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbuda
 */
public class gui extends javax.swing.JFrame {

    String SourceLoc = "";
    String OutputLoc = "";
    /**
     * Creates new form gui
     */
    public gui() {
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

        jfcSourceFile = new javax.swing.JFileChooser();
        jfcOutput = new javax.swing.JFileChooser();
        btnGrpTools = new javax.swing.ButtonGroup();
        btnGrpMode = new javax.swing.ButtonGroup();
        txtSourceLoc = new javax.swing.JTextField();
        btnSourceLoc = new javax.swing.JButton();
        txtOutputLoc = new javax.swing.JTextField();
        btnOutputLoc = new javax.swing.JButton();
        jrbBec = new javax.swing.JRadioButton();
        jrbPak = new javax.swing.JRadioButton();
        jrbTok = new javax.swing.JRadioButton();
        jrbZlib = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btnRunTool = new javax.swing.JButton();
        jrbUnpack = new javax.swing.JRadioButton();
        jrbPack = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtSourceLoc.setText("Source file location here");
        txtSourceLoc.setEnabled(false);

        btnSourceLoc.setText("Find file to be extracted");
        btnSourceLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSourceLocActionPerformed(evt);
            }
        });

        txtOutputLoc.setText("Output folder here");
        txtOutputLoc.setEnabled(false);
        txtOutputLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOutputLocActionPerformed(evt);
            }
        });

        btnOutputLoc.setText("Choose output folder");
        btnOutputLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutputLocActionPerformed(evt);
            }
        });

        btnGrpTools.add(jrbBec);
        jrbBec.setSelected(true);
        jrbBec.setText("bec-tool");

        btnGrpTools.add(jrbPak);
        jrbPak.setText("pak-tool");
        jrbPak.setEnabled(false);

        btnGrpTools.add(jrbTok);
        jrbTok.setText("tok-tool");
        jrbTok.setEnabled(false);

        btnGrpTools.add(jrbZlib);
        jrbZlib.setText("zlib-tool");
        jrbZlib.setEnabled(false);

        jLabel1.setText("Select a tool below:");

        btnRunTool.setText("Run tool");
        btnRunTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunToolActionPerformed(evt);
            }
        });

        btnGrpMode.add(jrbUnpack);
        jrbUnpack.setSelected(true);
        jrbUnpack.setText("Unpack Mode");
        jrbUnpack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbUnpackActionPerformed(evt);
            }
        });

        btnGrpMode.add(jrbPack);
        jrbPack.setText("Pack Mode");
        jrbPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPackActionPerformed(evt);
            }
        });

        jLabel2.setText("Select a mode below:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jrbBec)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrbPak))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jrbTok)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrbZlib))
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jrbPack)
                                    .addComponent(jrbUnpack)))
                            .addComponent(btnRunTool, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(138, 138, 138))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSourceLoc)
                            .addComponent(btnSourceLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOutputLoc)
                            .addComponent(btnOutputLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSourceLoc, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSourceLoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtOutputLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOutputLoc)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbBec)
                    .addComponent(jrbPak)
                    .addComponent(jrbUnpack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbTok)
                    .addComponent(jrbZlib)
                    .addComponent(jrbPack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRunTool, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOutputLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOutputLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOutputLocActionPerformed

   
    private void btnSourceLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSourceLocActionPerformed
        if(jrbUnpack.isSelected() == true){
            jfcSourceFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int returnVal = jfcSourceFile.showOpenDialog(this);
            File file = jfcSourceFile.getSelectedFile();
            txtSourceLoc.setText(file.getAbsolutePath());
            SourceLoc = file.getAbsolutePath();
        } else if(jrbPack.isSelected() == true){
            jfcSourceFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = jfcSourceFile.showOpenDialog(this);
            File directory = jfcSourceFile.getSelectedFile();
            txtSourceLoc.setText(directory.getAbsolutePath());
            SourceLoc = directory.getAbsolutePath()+"/";
        }
    }//GEN-LAST:event_btnSourceLocActionPerformed

    private void btnOutputLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutputLocActionPerformed
        jfcOutput.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = jfcOutput.showOpenDialog(this);
        File directory = jfcOutput.getSelectedFile();
        txtOutputLoc.setText(directory.getAbsolutePath());
        OutputLoc = directory.getAbsolutePath()+"/";
    }//GEN-LAST:event_btnOutputLocActionPerformed

    private void btnRunToolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunToolActionPerformed
        if(jrbUnpack.isSelected() == true){
            unpackBec(SourceLoc, OutputLoc);
        }else if(jrbPack.isSelected() == true){
            packBec(SourceLoc, OutputLoc);
        }else{
            
        }
    }//GEN-LAST:event_btnRunToolActionPerformed

    private void jrbPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPackActionPerformed
        btnOutputLoc.setText("Choose bec output folder");
        btnSourceLoc.setText("Find unpacked bec folder");
    }//GEN-LAST:event_jrbPackActionPerformed

    private void jrbUnpackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbUnpackActionPerformed
        btnSourceLoc.setText("Find file to be extracted");
        btnOutputLoc.setText("Choose output folder");
    }//GEN-LAST:event_jrbUnpackActionPerformed

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
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }
    
    public void unpackBec(String SourceLoc, String OutputLoc){
       try{
        String location = gui.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(location);
        String[] cmdArray = new String[6];
        cmdArray[0] = "python";
        cmdArray[1] = location + "bec-tool.py";
        cmdArray[2] = "-unpack";
        cmdArray[3] = SourceLoc;
        cmdArray[4] = OutputLoc;
        cmdArray[5] = "gladius_bec_FileList.txt";
        Process process = Runtime.getRuntime().exec(cmdArray);
        BufferedReader stdInput = new BufferedReader(new 
         InputStreamReader(process.getInputStream()));

         BufferedReader stdError = new BufferedReader(new 
              InputStreamReader(process.getErrorStream()));

         // Read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

        // Read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void packBec(String SourceLoc, String OutputLoc){
               try{
        String location = gui.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(location);
        String[] cmdArray = new String[6];
        cmdArray[0] = "python";
        cmdArray[1] = location + "bec-tool.py";
        cmdArray[2] = "-pack";
        cmdArray[3] = SourceLoc;
        cmdArray[4] = OutputLoc+"/DATA.BEC";
        cmdArray[5] = SourceLoc+"gladius_bec_FileList.txt";
        Process process = Runtime.getRuntime().exec(cmdArray);
        BufferedReader stdInput = new BufferedReader(new 
         InputStreamReader(process.getInputStream()));

         BufferedReader stdError = new BufferedReader(new 
              InputStreamReader(process.getErrorStream()));

         // Read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

        // Read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrpMode;
    private javax.swing.ButtonGroup btnGrpTools;
    private javax.swing.JButton btnOutputLoc;
    private javax.swing.JButton btnRunTool;
    private javax.swing.JButton btnSourceLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFileChooser jfcOutput;
    private javax.swing.JFileChooser jfcSourceFile;
    private javax.swing.JRadioButton jrbBec;
    private javax.swing.JRadioButton jrbPack;
    private javax.swing.JRadioButton jrbPak;
    private javax.swing.JRadioButton jrbTok;
    private javax.swing.JRadioButton jrbUnpack;
    private javax.swing.JRadioButton jrbZlib;
    private javax.swing.JTextField txtOutputLoc;
    private javax.swing.JTextField txtSourceLoc;
    // End of variables declaration//GEN-END:variables
}
