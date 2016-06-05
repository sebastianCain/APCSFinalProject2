package main;

import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.*;
import java.awt.*;
import java.nio.file.Files;
import java.util.*;


public class CompressorGui extends javax.swing.JFrame {
    
    private String _data;
    private File _file;
    private byte[] _output;
    private String _oPath;
    private boolean firstRun;

    public CompressorGui() {
        initComponents();
        firstRun = true;
        initFileDrop();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        diagDialog = new javax.swing.JDialog();
        diagClose = new javax.swing.JButton();
        diagText = new javax.swing.JLabel();
        errorDialog = new javax.swing.JDialog();
        errorClose = new javax.swing.JButton();
        errorText = new javax.swing.JLabel();
        sixBit = new javax.swing.JPanel();
        sixBitText = new javax.swing.JLabel();
        sixBitCompress = new javax.swing.JButton();
        sixBitDecompress = new javax.swing.JButton();
        dictComp = new javax.swing.JPanel();
        dictText = new javax.swing.JLabel();
        dictCompress = new javax.swing.JButton();
        dictDecompress = new javax.swing.JButton();
        filePane = new javax.swing.JPanel();
        barFile = new javax.swing.JProgressBar();
        pathViewer = new javax.swing.JScrollPane();
        currPath = new javax.swing.JTextArea();
        controlPanel = new javax.swing.JPanel();
        compBarLabel = new javax.swing.JLabel();
        decompBarLabel = new javax.swing.JLabel();
        compBar = new javax.swing.JProgressBar();
        decompBar = new javax.swing.JProgressBar();
        jSeparator1 = new javax.swing.JSeparator();
        dropPane = new javax.swing.JPanel();
        chooseFile = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        subFileOpen = new javax.swing.JMenuItem();
        subFileQuit = new javax.swing.JMenuItem();

        fileChooser.setDialogTitle("Choose A File");
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        diagDialog.setMinimumSize(new java.awt.Dimension(500, 250));

        diagClose.setText("Close");
        diagClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagCloseActionPerformed(evt);
            }
        });

        diagText.setBackground(new java.awt.Color(204, 255, 255));
        diagText.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        diagText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagText.setText("Message");

        javax.swing.GroupLayout diagDialogLayout = new javax.swing.GroupLayout(diagDialog.getContentPane());
        diagDialog.getContentPane().setLayout(diagDialogLayout);
        diagDialogLayout.setHorizontalGroup(
            diagDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagDialogLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(diagClose, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(diagDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(diagDialogLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(diagText, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        diagDialogLayout.setVerticalGroup(
            diagDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diagDialogLayout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(diagClose)
                .addGap(21, 21, 21))
            .addGroup(diagDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(diagDialogLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(diagText, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addGap(61, 61, 61)))
        );

        errorDialog.setMinimumSize(new java.awt.Dimension(500, 250));

        errorClose.setText("Close");
        errorClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorCloseActionPerformed(evt);
            }
        });

        errorText.setBackground(new java.awt.Color(204, 255, 255));
        errorText.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        errorText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorText.setText("Error");

        javax.swing.GroupLayout errorDialogLayout = new javax.swing.GroupLayout(errorDialog.getContentPane());
        errorDialog.getContentPane().setLayout(errorDialogLayout);
        errorDialogLayout.setHorizontalGroup(
            errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorDialogLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(errorClose, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(errorDialogLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(errorText, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        errorDialogLayout.setVerticalGroup(
            errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorDialogLayout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(errorClose)
                .addGap(29, 29, 29))
            .addGroup(errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(errorDialogLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(errorText, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addGap(61, 61, 61)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sixBit.setBackground(new java.awt.Color(153, 204, 255));
        sixBit.setForeground(new java.awt.Color(153, 204, 255));

        sixBitText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixBitText.setText("6 Bit Compression");

        sixBitCompress.setText("Compress");
        sixBitCompress.setFocusable(false);
        sixBitCompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixBitCompressActionPerformed(evt);
            }
        });

        sixBitDecompress.setText("Decompress");
        sixBitDecompress.setFocusable(false);
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
        dictCompress.setFocusable(false);
        dictCompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dictCompressActionPerformed(evt);
            }
        });

        dictDecompress.setText("Decompress");
        dictDecompress.setFocusable(false);
        dictDecompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dictDecompressActionPerformed(evt);
            }
        });

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

        barFile.setBackground(new java.awt.Color(153, 204, 255));
        barFile.setForeground(new java.awt.Color(0, 102, 0));
        barFile.setToolTipText("");
        barFile.setFocusable(false);
        barFile.setName("Selected File"); // NOI18N
        barFile.setRequestFocusEnabled(false);
        barFile.setString("Selected File");
        barFile.setStringPainted(true);

        pathViewer.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pathViewer.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        currPath.setEditable(false);
        currPath.setBackground(new java.awt.Color(148, 188, 228));
        currPath.setColumns(20);
        currPath.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
        currPath.setRows(1);
        currPath.setText(" None");
        currPath.setToolTipText("Shows the currently selected file");
        currPath.setBorder(null);
        currPath.setFocusTraversalKeysEnabled(false);
        currPath.setFocusable(false);
        currPath.setName(""); // NOI18N
        pathViewer.setViewportView(currPath);

        compBarLabel.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        compBarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        compBarLabel.setText("Compress");

        decompBarLabel.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        decompBarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        decompBarLabel.setText("Decompress");

        compBar.setBackground(new java.awt.Color(255, 255, 255));
        compBar.setForeground(new java.awt.Color(0, 102, 0));
        compBar.setFocusable(false);

        decompBar.setBackground(new java.awt.Color(255, 255, 255));
        decompBar.setForeground(new java.awt.Color(0, 102, 0));
        decompBar.setFocusable(false);

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(decompBarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(compBarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(compBar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(decompBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(compBarLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(compBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decompBarLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decompBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dropPane.setBackground(new java.awt.Color(153, 204, 255));
        dropPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        chooseFile.setText("Choose or Drop File");
        chooseFile.setFocusable(false);
        chooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dropPaneLayout = new javax.swing.GroupLayout(dropPane);
        dropPane.setLayout(dropPaneLayout);
        dropPaneLayout.setHorizontalGroup(
            dropPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropPaneLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        dropPaneLayout.setVerticalGroup(
            dropPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dropPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout filePaneLayout = new javax.swing.GroupLayout(filePane);
        filePane.setLayout(filePaneLayout);
        filePaneLayout.setHorizontalGroup(
            filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filePaneLayout.createSequentialGroup()
                        .addGroup(filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pathViewer, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barFile, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filePaneLayout.createSequentialGroup()
                        .addComponent(dropPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filePaneLayout.setVerticalGroup(
            filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(filePaneLayout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(filePaneLayout.createSequentialGroup()
                        .addComponent(dropPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pathViewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        menuFile.setText("File");

        subFileOpen.setText("Open");
        subFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subFileOpenActionPerformed(evt);
            }
        });
        menuFile.add(subFileOpen);

        subFileQuit.setText("Quit");
        subFileQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subFileQuitActionPerformed(evt);
            }
        });
        menuFile.add(subFileQuit);

        menu.add(menuFile);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filePane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sixBit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dictComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dictComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixBit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void initFileDrop(){
        try {
            new FileDrop(dropPane, javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN), new FileDrop.Listener()
                {   public void filesDropped(java.io.File[] files)
                    {   
                        _file = files[0];
                        try {
                            FileReader fileReader = new FileReader(_file);

                            currPath.setText(" " + _file.toPath().toString());
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            StringBuffer stringBuffer = new StringBuffer();
                            String line;
                            while ((line = bufferedReader.readLine()) != null) {
                                    stringBuffer.append(line);
                                    stringBuffer.append("\n");
                            }
                            fileReader.close();

                            _data = stringBuffer.toString();
                            statusBarReset();
                            barFile.setValue(100);
                            barFile.setForeground(new Color(0,102,0));//green
                        } catch (IOException e) {
                            currPath.setText(" File read error!");
                            statusBarReset();
                            barFile.setValue(100);
                            barFile.setForeground(new Color(153,0,0));//red
                        } 
                    }   // end filesDropped
                }); // end FileDrop.Listener
            
        }
        catch(Exception e){
            if (firstRun = false){
                currPath.setText(" File read error!");
                statusBarReset();
                barFile.setValue(100);
                barFile.setForeground(new Color(153,0,0));//red
            }
        }
        firstRun = false;
    }
    
    private void statusBarReset(){
        
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        compBar.setForeground(new Color(153,0,0));//red
        compBar.setForeground(new Color(0,102,0));//green
        decompBar.setForeground(new Color(153,0,0));
        decompBar.setForeground(new Color(0,102,0));
        barFile.setForeground(new Color(153,0,0));
        barFile.setForeground(new Color(0,102,0));
        barFile.setValue(0);
        decompBar.setValue(0);
        compBar.setValue(0);

    }
    
    
    private void sixBitCompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixBitCompressActionPerformed
        String oldPath = "";
        if (_file != null){
            oldPath = _file.toPath().toString();
        }
        if (_file == null){
            statusBarReset();
            compBar.setValue(100);
                
            compBar.setForeground(new Color(153,0,0));//red
            currPath.setText(" No file selected!");
        }
        
        /*
        else if (!(oldPath.substring(oldPath.length() - 4).equals(".txt"))){
            statusBarReset();
            //_file == null;
            compBar.setValue(100);
                
            compBar.setForeground(new Color(153,0,0));//red
            currPath.setText(" Incorrect file type selected!");
        }
        */
            
        else{
            try {
                _output = SixEncrypt.encrypt(_data);

                fileChooser.setSelectedFile(new File("archive.zip"));
                fileChooser.showSaveDialog(this);
                File newFile = fileChooser.getSelectedFile();
                String path = newFile.toPath().toString();
                FileOutputStream fileOutputStream = new FileOutputStream(path); 

                fileOutputStream.write(_output);
                fileOutputStream.close();

                statusBarReset();
                compBar.setValue(100);
                compBar.setForeground(new Color(0,102,0));//green
                _file = null;
                currPath.setText(" None");   
            }
        
            catch(Exception e){
                statusBarReset();
                compBar.setValue(100);
                compBar.setForeground(new Color(153,0,0));//red

                currPath.setText(" Compression Error!");
            }
        }
    }//GEN-LAST:event_sixBitCompressActionPerformed

    private void subFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subFileOpenActionPerformed

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File input = fileChooser.getSelectedFile();
            _file = input;
            try {
			FileReader fileReader = new FileReader(input);
                        
                        currPath.setText(" " + input.toPath().toString());
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
                        
                        _data = stringBuffer.toString();
			statusBarReset();
                        barFile.setValue(100);
                        barFile.setForeground(new Color(0,102,0));//green
		} catch (IOException e) {
                    currPath.setText(" File read error!");
                    statusBarReset();
                    barFile.setValue(100);
                    barFile.setForeground(new Color(153,0,0));//red
		}      
        }
    }//GEN-LAST:event_subFileOpenActionPerformed

    private void sixBitDecompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixBitDecompressActionPerformed
        if (_file == null){
            statusBarReset();
            decompBar.setValue(100);
                
            decompBar.setForeground(new Color(153,0,0));//red
            currPath.setText(" No file selected!");
        }
            
        else{
            try {

                fileChooser.setSelectedFile(new File(""));
                fileChooser.showSaveDialog(this);
                File newFile = fileChooser.getSelectedFile();
                String path = newFile.toPath().toString();

                FileInputStream fileInputStream = new FileInputStream(_file);
                fileInputStream.read(_output);
                _data = SixEncrypt.decrypt(_output);
                fileInputStream.close();
                currPath.setText(" " + _file.toPath().toString());

                BufferedWriter bufferedWriter = null;

            try {
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                Writer writer = new FileWriter(newFile);
                bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(_data);
            } catch (IOException e) {
                statusBarReset();
                decompBar.setValue(100);
                decompBar.setForeground(new Color(153,0,0));//red
                currPath.setText(" Decompression Error!");
            } finally{
                try{
                    if(bufferedWriter != null) bufferedWriter.close();
                } catch(Exception ex){
                    statusBarReset();
                    decompBar.setValue(100);

                    decompBar.setForeground(new Color(153,0,0));//red
                    currPath.setText(" Decompression Error!");
                }
            }
                statusBarReset();
                decompBar.setValue(100);
                decompBar.setForeground(new Color(0,102,0));//green
                _file = null;
                currPath.setText(" None");


            }catch(Exception e){
                statusBarReset();
                decompBar.setValue(100);
                decompBar.setForeground(new Color(153,0,0));//red
                currPath.setText(" Decompression Error!");
            }
        }
    }//GEN-LAST:event_sixBitDecompressActionPerformed

    private void chooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileActionPerformed
        subFileOpenActionPerformed(evt);
    }//GEN-LAST:event_chooseFileActionPerformed

    private void subFileQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subFileQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_subFileQuitActionPerformed

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileChooserActionPerformed

    private void diagCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagCloseActionPerformed
        diagDialog.dispose();
    }//GEN-LAST:event_diagCloseActionPerformed

    private void errorCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorCloseActionPerformed
        errorDialog.dispose();
    }//GEN-LAST:event_errorCloseActionPerformed

    private void dictCompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dictCompressActionPerformed
        String oldPath = "";
        if (_file != null){
            oldPath = _file.toPath().toString();
        }
        if (_file == null){
            statusBarReset();
            compBar.setValue(100);
                
            compBar.setForeground(new Color(153,0,0));//red
            currPath.setText(" No file selected!");
        }
        
        /*
        else if (!(oldPath.substring(oldPath.length() - 4).equals(".txt"))){
            statusBarReset();
            //_file == null;
            compBar.setValue(100);
                
            compBar.setForeground(new Color(153,0,0));//red
            currPath.setText(" Incorrect file type selected!");
        }
        */
            
        else{
            try {
                _output = DictCompress.encrypt(_data);
                System.out.println("Before parse:" + Arrays.toString(_output));
                /*
                byte[] nArray = new byte[_output.length - 1];
                for (int i = 0; i < _output.length - 2; i++){
                    nArray[i] = _output[i];
                }
                nArray[nArray.length - 1] = _output[_output.length - 1];
                _output = nArray;
                */

                fileChooser.setSelectedFile(new File("archive.zip"));
                fileChooser.showSaveDialog(this);
                File newFile = fileChooser.getSelectedFile();
                String path = newFile.toPath().toString();
                FileOutputStream fileOutputStream = new FileOutputStream(newFile); 

                fileOutputStream.write(_output);
                System.out.println("To File:" + Arrays.toString(_output));
                fileOutputStream.close();

                statusBarReset();
                compBar.setValue(100);
                compBar.setForeground(new Color(0,102,0));//green
                _file = null;
                currPath.setText(" None");   
            }
        
            catch(Exception e){
                statusBarReset();
                compBar.setValue(100);
                compBar.setForeground(new Color(153,0,0));//red

                currPath.setText(" Compression Error!");
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_dictCompressActionPerformed

    private void dictDecompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dictDecompressActionPerformed
        if (_file == null){
            statusBarReset();
            decompBar.setValue(100);
                
            decompBar.setForeground(new Color(153,0,0));//red
            currPath.setText(" No file selected!");
        }
            
        else{
            try {

                fileChooser.setSelectedFile(new File(""));
                fileChooser.showSaveDialog(this);
        
                File newFile = fileChooser.getSelectedFile();
                String path = newFile.toPath().toString();
                /*
                FileInputStream fileInputStream = new FileInputStream(_file.toPath().toString());
                System.out.println(fileInputStream);
                System.out.println(_output);
                _output = null;
                fileInputStream.read(_output);
                System.out.println(Arrays.toString(_output));
                System.out.println("success4");
                _data = DictCompress.decrypt(_output);
                System.out.println("success5");
                fileInputStream.close();
                */
                _output = Files.readAllBytes(_file.toPath());
                System.out.println("From File:" + Arrays.toString(_output));
                _data = DictCompress.decrypt(_output);
                currPath.setText(" " + _file.toPath().toString());
                

                BufferedWriter bufferedWriter = null;

            try {
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                Writer writer = new FileWriter(newFile);
                bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(_data);
            } catch (IOException e) {
                statusBarReset();
                decompBar.setValue(100);
                decompBar.setForeground(new Color(153,0,0));//red
                currPath.setText(" Decompression Error 1!");
            } finally{
                try{
                    if(bufferedWriter != null) bufferedWriter.close();
                } catch(Exception ex){
                    statusBarReset();
                    decompBar.setValue(100);

                    decompBar.setForeground(new Color(153,0,0));//red
                    currPath.setText(" Decompression Error 2!");
                }
            }
                statusBarReset();
                decompBar.setValue(100);
                decompBar.setForeground(new Color(0,102,0));//green
                _file = null;
                currPath.setText(" None");


            }catch(Exception e){
                statusBarReset();
                decompBar.setValue(100);
                decompBar.setForeground(new Color(153,0,0));//red
                currPath.setText(" Decompression Error 3!");
                System.out.println(e);
                System.out.println(e.getMessage());
                
            }
        }
    }//GEN-LAST:event_dictDecompressActionPerformed

    public static void main(String args[]) {
    
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompressorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompressorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompressorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompressorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompressorGui().setVisible(true);
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barFile;
    private javax.swing.JButton chooseFile;
    private javax.swing.JProgressBar compBar;
    private javax.swing.JLabel compBarLabel;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JTextArea currPath;
    private javax.swing.JProgressBar decompBar;
    private javax.swing.JLabel decompBarLabel;
    private javax.swing.JButton diagClose;
    private javax.swing.JDialog diagDialog;
    private javax.swing.JLabel diagText;
    private javax.swing.JPanel dictComp;
    private javax.swing.JButton dictCompress;
    private javax.swing.JButton dictDecompress;
    private javax.swing.JLabel dictText;
    private javax.swing.JPanel dropPane;
    private javax.swing.JButton errorClose;
    private javax.swing.JDialog errorDialog;
    private javax.swing.JLabel errorText;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JPanel filePane;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuFile;
    private javax.swing.JScrollPane pathViewer;
    private javax.swing.JPanel sixBit;
    private javax.swing.JButton sixBitCompress;
    private javax.swing.JButton sixBitDecompress;
    private javax.swing.JLabel sixBitText;
    private javax.swing.JMenuItem subFileOpen;
    private javax.swing.JMenuItem subFileQuit;
    // End of variables declaration//GEN-END:variables
}
