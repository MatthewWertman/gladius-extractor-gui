package com.budaslounge.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;

public class gui {

    /* Initialize Components */

    // Reusable
    private static JPanel panel;
    private static JSplitPane splitPane;
    private static JTextPane textPane;
    private static JLabel label;

    private static JComboBox cmbGameVersion;
    private static JButton btnSourceLoc;
    private static JButton btnOutputLoc;
    private static JButton btnRunTool;
    private static JRadioButton rbNgcisoTool;
    private static JRadioButton rbPsisoTool;
    private static JRadioButton rbBecTool;
    private static JRadioButton rbPakTool;
    private static JRadioButton rbTokTool;
    private static JRadioButton rbZlibTool;
    private static JRadioButton rbModeUnpack;
    private static JRadioButton rbModePack;
    private static JTextField txtSourceLocation;
    private static JTextField txtOutputLocation;

    // Button Groups
    private static final ButtonGroup isoSelectGrp = new ButtonGroup();
    private static final ButtonGroup archiveSelectGrp = new ButtonGroup();
    private static final ButtonGroup modeSelectGrp = new ButtonGroup();

    // Fonts
    private static final Font headerFont = new Font("SansSerif", Font.BOLD, 14);
    private static final Font subHeaderFont = new Font("SansSerif", Font.BOLD, 13);

    public static void addComponentsToPane(Container pane) {

        // Setting up the content pane
        pane.setLayout(new GridLayout());
        pane.setMinimumSize(new Dimension(500,500));
        pane.setPreferredSize(new Dimension(850,500));
        pane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                JPanel f = (JPanel) componentEvent.getComponent();
                JSplitPane splitPane = (JSplitPane) f.getComponents()[0];
                Dimension frameSize = componentEvent.getComponent().getBounds().getSize();
                splitPane.setDividerLocation(frameSize.width / 3);
            }
        });

        splitPane = new JSplitPane();
        splitPane.setDividerSize(5);
        pane.add(splitPane);

        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setText("Console output goes here..");
        splitPane.setRightComponent(textPane);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        splitPane.setLeftComponent(panel);
        GridBagConstraints gbc = new GridBagConstraints();

        // Top label
        label = new JLabel();
        label.setText("Select Game Version");
        label.setFont(headerFont);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0,0,0);
        panel.add(label, gbc);

        // Game version combo box
        cmbGameVersion = new JComboBox();
        cmbGameVersion.setPreferredSize(new Dimension(125, 27));
        final DefaultComboBoxModel cmbGameVersionModel = new DefaultComboBoxModel();
        cmbGameVersionModel.addElement("");
        cmbGameVersionModel.addElement("GameCube");
        cmbGameVersionModel.addElement("PlayStation");
        cmbGameVersion.setModel(cmbGameVersionModel);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(cmbGameVersion, gbc);

        // "Tools" label
        label = new JLabel();
        label.setText("Tools");
        label.setFont(headerFont);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 10, 0);
        panel.add(label, gbc);

        // "ISOs" label
        label = new JLabel();
        label.setText("    ISOs");
        label.setFont(subHeaderFont);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(5,0,5,0);
        panel.add(label, gbc);

        rbNgcisoTool = new JRadioButton("Ngciso");
        isoSelectGrp.add(rbNgcisoTool);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(0,0,0,0);
        panel.add(rbNgcisoTool, gbc);

        rbPsisoTool = new JRadioButton("Psiso");
        isoSelectGrp.add(rbPsisoTool);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(rbPsisoTool, gbc);

        // "Archives" label
        label = new JLabel();
        label.setText("    Archives");
        label.setFont(subHeaderFont);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(5, 0, 5, 0);
        panel.add(label, gbc);

        rbBecTool = new JRadioButton("Bec Tool");
        archiveSelectGrp.add(rbBecTool);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(rbBecTool, gbc);

        rbPakTool = new JRadioButton("Pak Tool");
        archiveSelectGrp.add(rbPakTool);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(rbPakTool, gbc);

        rbTokTool = new JRadioButton("Tok Tool");
        archiveSelectGrp.add(rbTokTool);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(rbTokTool, gbc);

        rbZlibTool = new JRadioButton("Zlib Tool");
        archiveSelectGrp.add(rbZlibTool);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(rbZlibTool, gbc);

        // "Mode" label
        label = new JLabel();
        label.setText("Select Mode");
        label.setFont(headerFont);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.insets = new Insets(20, 0, 10, 0);
        panel.add(label, gbc);

        rbModeUnpack = new JRadioButton("Unpack");
        modeSelectGrp.add(rbModeUnpack);
        rbModeUnpack.setSelected(true);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.insets = new Insets(0,0,0,0);   //reset
        panel.add(rbModeUnpack, gbc);

        rbModePack = new JRadioButton("Pack");
        modeSelectGrp.add(rbModePack);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 9;
        panel.add(rbModePack, gbc);

        txtSourceLocation = new JTextField();
        txtSourceLocation.setEditable(false);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.insets = new Insets(20, 0, 0, 0);
        panel.add(txtSourceLocation, gbc);

        btnSourceLoc = new JButton("Find file to be extracted");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.insets = new Insets(5, 0,0,0);
        panel.add(btnSourceLoc, gbc);

        btnSourceLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                if (rbModeUnpack.isSelected()) {
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fc.showOpenDialog(fc);
                    File file = fc.getSelectedFile();
                    txtSourceLocation.setText(file.getAbsolutePath());
                } else if (rbModePack.isSelected()) {
                    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    fc.showOpenDialog(fc);
                    File directory = fc.getSelectedFile();
                    txtSourceLocation.setText(directory.getAbsolutePath());
                }
            }
        });

        txtOutputLocation = new JTextField();
        txtOutputLocation.setEditable(false);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 12;
        //gbc.insets = new Insets(10, 20, 0 , 20);
        panel.add(txtOutputLocation, gbc);

        btnOutputLoc = new JButton("Choose output directory");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 13;
        panel.add(btnOutputLoc, gbc);

        btnOutputLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.showOpenDialog(fc);
                File directory = fc.getSelectedFile();
                txtOutputLocation.setText(directory.getAbsolutePath());
            }
        });

        // Bottom button
        btnRunTool = new JButton("Run tool");
        btnRunTool.setFont(subHeaderFont);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipady = 20;
        gbc.insets = new Insets(0,0,0,0);
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 14;
        panel.add(btnRunTool, gbc);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Gladius Extractor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));

        addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
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

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
