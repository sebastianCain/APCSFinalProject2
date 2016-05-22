/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author winston
 */
public class CompressorGui extends javax.swing.JFrame {

    /**
     * Creates new form CompressorGui
     */
    public CompressorGui() {
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

        sixBit = new javax.swing.JPanel();
        sixBitText = new javax.swing.JLabel();
        sixBitCompress = new javax.swing.JButton();
        sixBitDecompress = new javax.swing.JButton();
        dictComp = new javax.swing.JPanel();
        dictText = new javax.swing.JLabel();
        dictCompress = new javax.swing.JButton();
        dictDecompress = new javax.swing.JButton();
        filePane = new javax.swing.JPanel();
        chooseFile = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        subFileOpen = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sixBit.setBackground(new java.awt.Color(153, 204, 255));
        sixBit.setForeground(new java.awt.Color(153, 204, 255));

        sixBitText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixBitText.setText("6 Bit Compression");

        sixBitCompress.setText("Compress");
        sixBitCompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixBitCompressActionPerformed(evt);
            }
        });

        sixBitDecompress.setText("Decompress");
        sixBitDecompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixBitDecompressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sixBitLayout = new javax.swing.GroupLayout(sixBit);
        sixBit.setLayout(sixBitLayout);
        sixBitLayout.setHorizontalGroup(
            sixBitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sixBitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sixBitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sixBitCompress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sixBitText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sixBitDecompress, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addContainerGap())
        );
        sixBitLayout.setVerticalGroup(
            sixBitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sixBitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sixBitText)
                .addGap(18, 18, 18)
                .addComponent(sixBitCompress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sixBitDecompress)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        dictComp.setBackground(new java.awt.Color(153, 204, 255));

        dictText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dictText.setText("Dictionary Compression");

        dictCompress.setText("Compress");

        dictDecompress.setText("Decompress");

        javax.swing.GroupLayout dictCompLayout = new javax.swing.GroupLayout(dictComp);
        dictComp.setLayout(dictCompLayout);
        dictCompLayout.setHorizontalGroup(
            dictCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dictCompLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dictCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dictDecompress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dictText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(dictCompress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dictCompLayout.setVerticalGroup(
            dictCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dictCompLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dictText)
                .addGap(18, 18, 18)
                .addComponent(dictCompress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dictDecompress)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        filePane.setBackground(new java.awt.Color(153, 204, 255));

        chooseFile.setText("Choose File");
        chooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filePaneLayout = new javax.swing.GroupLayout(filePane);
        filePane.setLayout(filePaneLayout);
        filePaneLayout.setHorizontalGroup(
            filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePaneLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filePaneLayout.setVerticalGroup(
            filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filePaneLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        menuFile.setText("File");

        subFileOpen.setText("Open");
        subFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subFileOpenActionPerformed(evt);
            }
        });
        menuFile.add(subFileOpen);

        menu.add(menuFile);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sixBit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(dictComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dictComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixBit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sixBitCompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixBitCompressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sixBitCompressActionPerformed

    private void subFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subFileOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subFileOpenActionPerformed

    private void sixBitDecompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixBitDecompressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sixBitDecompressActionPerformed

    private void chooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseFileActionPerformed

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
            java.util.logging.Logger.getLogger(CompressorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompressorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompressorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompressorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompressorGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFile;
    private javax.swing.JPanel dictComp;
    private javax.swing.JButton dictCompress;
    private javax.swing.JButton dictDecompress;
    private javax.swing.JLabel dictText;
    private javax.swing.JPanel filePane;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuFile;
    private javax.swing.JPanel sixBit;
    private javax.swing.JButton sixBitCompress;
    private javax.swing.JButton sixBitDecompress;
    private javax.swing.JLabel sixBitText;
    private javax.swing.JMenuItem subFileOpen;
    // End of variables declaration//GEN-END:variables
}
