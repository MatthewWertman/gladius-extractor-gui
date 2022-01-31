package com.budaslounge.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class gui {

    /* Initialize Components */

    // Reusable
    private static JPanel panel;
    private static JSplitPane splitPane;
    private static JScrollPane scrollPane;
    private static JTextPane console;
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

        // Set up content pane
        pane.setLayout(new GridLayout());       // Set layout to GridLayout
        pane.setMinimumSize(new Dimension(500,500));
        pane.setPreferredSize(new Dimension(850,500));
        // Add listener on component resize
        pane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                // Casting magic
                JPanel f = (JPanel) componentEvent.getComponent();
                JSplitPane splitPane = (JSplitPane) f.getComponents()[0];
                Dimension frameSize = componentEvent.getComponent().getBounds().getSize();      // Get the current frame size
                splitPane.setDividerLocation(frameSize.width / 3);      // Set SplitPane divider to 1/3 of frame size
            }
        });

        // Create SplitPane
        splitPane = new JSplitPane();
        splitPane.setDividerSize(5);
        pane.add(splitPane);

        // Create Console Pane
        console = new JTextPane();
        console.setEditable(false);
        console.setText("Console output goes here..");

        // Create Scrollable pane
        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setViewportView(console);

        splitPane.setRightComponent(scrollPane);

        /*
        *
        Below we create what is called the "ActionPanel". This houses all the selections and options on the left
        side of the Split Pane.
        *
        The ActionPanel uses the GridBagLayout layout manager. It is the more sophisticated cousin of the GridLayout.
        This allows components to span over multiple rows and/or columns while keeping a grid-like layout.
        *
        With the components defined below, this creates a 15 row, 2 column grid.
        */

        // Create ActionPanel
        panel = new JPanel();
        splitPane.setLeftComponent(panel);
        panel.setLayout(new GridBagLayout());   // Set layout to GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();      // Initialize GridBagConstraints


        // Create top label
        label = new JLabel();
        label.setText("Select Game Version");
        label.setFont(headerFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // take up both columns
        gbc.insets = new Insets(5, 0, 0, 0);    // set top padding to 5
        gbc.fill = GridBagConstraints.CENTER;       // Center text
        panel.add(label, gbc);

        // Game version combo box
        cmbGameVersion = new JComboBox();
        cmbGameVersion.setPreferredSize(new Dimension(125, 27));
        final DefaultComboBoxModel cmbGameVersionModel = new DefaultComboBoxModel();
        cmbGameVersionModel.addElement("GameCube");
        cmbGameVersionModel.addElement("PlayStation");
        cmbGameVersion.setModel(cmbGameVersionModel);
        gbc.gridx = 0;
        gbc.gridy = 1;  // new row
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(cmbGameVersion, gbc);

        // "Tools" label
        label = new JLabel();
        label.setText("Tools");
        label.setFont(headerFont);
        gbc.gridx = 0;
        gbc.gridy = 2;  // new row
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 10, 0);      // top padding: 20, bottom padding: 10
        panel.add(label, gbc);

        // "ISOs" label
        label = new JLabel();
        label.setText("    ISOs");
        label.setFont(subHeaderFont);
        gbc.gridx = 0;
        gbc.gridy = 3;  // new row
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5,0,5,0);       // top padding: 5, bottom padding: 5
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(label, gbc);

        rbNgcisoTool = new JRadioButton("GC iso");
        isoSelectGrp.add(rbNgcisoTool);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;  // only take up one column
        gbc.weightx = 0.5;  // take extra column space
        gbc.insets = new Insets(0,0,0,0);       // reset padding
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(rbNgcisoTool, gbc);

        rbPsisoTool = new JRadioButton("PS iso");
        isoSelectGrp.add(rbPsisoTool);
        rbPsisoTool.setEnabled(false);
        gbc.gridx = 1;  // place on second column
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(rbPsisoTool, gbc);

        // "Archives" label
        label = new JLabel();
        label.setText("    Archives");
        label.setFont(subHeaderFont);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(label, gbc);

        rbBecTool = new JRadioButton("Bec Tool");
        archiveSelectGrp.add(rbBecTool);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(rbBecTool, gbc);

        rbPakTool = new JRadioButton("Pak Tool");
        archiveSelectGrp.add(rbPakTool);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(rbPakTool, gbc);

        rbTokTool = new JRadioButton("Tok Tool");
        archiveSelectGrp.add(rbTokTool);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(rbTokTool, gbc);

        rbZlibTool = new JRadioButton("Zlib Tool");
        archiveSelectGrp.add(rbZlibTool);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(rbZlibTool, gbc);

        // "Mode" label
        label = new JLabel();
        label.setText("Select Mode");
        label.setFont(headerFont);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 10, 0);
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(label, gbc);

        rbModeUnpack = new JRadioButton("Unpack");
        modeSelectGrp.add(rbModeUnpack);
        rbModeUnpack.setSelected(true);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(0,0,0,0);   // reset padding
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(rbModeUnpack, gbc);

        rbModePack = new JRadioButton("Pack");
        modeSelectGrp.add(rbModePack);
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(rbModePack, gbc);

        txtSourceLocation = new JTextField();
        txtSourceLocation.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtSourceLocation, gbc);

        btnSourceLoc = new JButton("Find file to be extracted");
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 0,0,0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
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
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtOutputLocation, gbc);

        btnOutputLoc = new JButton("Choose output directory");
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
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
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;  // take any extra column space
        gbc.weighty = 1.0;  // take any extra row space
        gbc.ipady = 20;     // give some extra height
        gbc.insets = new Insets(0,0,0,0);   // reset padding
        gbc.anchor = GridBagConstraints.LAST_LINE_START;    // anchor component to bottom left corner
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnRunTool, gbc);

        btnRunTool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbModeUnpack.isSelected() && rbBecTool.isSelected()) {
                    unpackBec(txtSourceLocation.getText(), txtOutputLocation.getText());
                }
            }
        });
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

        javax.swing.SwingUtilities.invokeLater(gui::createAndShowGUI);
    }

    public static void unpackBec(String src, String out) {
        try{
            String location = gui.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            int lastSlash = location.lastIndexOf("/");
            if(System.getProperty("os.name").contains("Windows")){
                location = location.substring(1, lastSlash+1);
                src = src.replaceAll("/", "\\\\");
                out = out.replaceAll("/", "\\\\");
                location = location.replaceAll("/", "\\\\");
            } else {
                location = location.substring(0, lastSlash+1);
            }
            System.out.println(location);
            String[] cmdArray = new String[7];
            cmdArray[0] = "python";
            cmdArray[1] = location + "bec-tool.py";
            cmdArray[2] = "-unpack";
            cmdArray[3] = src;
            cmdArray[4] = out;
            cmdArray[5] = "gladius_bec_FileList.txt";
            boolean GC = cmbGameVersion.getSelectedItem().equals("GameCube");
            if (GC) {
                cmdArray[6] = "--gc";
            } else {
                cmdArray = Arrays.copyOf(cmdArray, 6);
            }
            Process process = Runtime.getRuntime().exec(cmdArray);
            outputToConsole(process);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void outputToConsole(Process p) {
        try {
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String output = "";
            String s;
            while ((s = stdInput.readLine()) != null) {
                output = output.concat(s).concat("\n");
            }
            console.setText(output);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
