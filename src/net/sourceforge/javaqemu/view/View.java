package net.sourceforge.javaqemu.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.sourceforge.javaqemu.model.Model;
import net.sourceforge.javaqemu.view.defined.Button;
import net.sourceforge.javaqemu.view.defined.TextArea;

public class View extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel jContentPane = null; // @jve:decl-index=0:visual-constraint="105,58"

    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenuItem configureCommand;
    private JMenuItem exitCommand;

    private JMenu emulationMenu;
    private JMenuItem startEmulation;
    private JMenuItem stopEmulation;

    private JMenu helpMenu;
    private JMenuItem aboutCommand;

    private GridLayout gridLayout;

    private JTabbedPane tabbedPane;

    private List<JPanelCreationView> myPanels;

    private Button createNewVMOption;

    private Button openExistingVMOption;

    private int activePanel;

    private ActionListener listener;

    private JPanel myUntitledJPanel;

    private Button useUtilities;

    private Font defaultFont = new Font("Arial", Font.PLAIN, 12);

    private static Font globalDefaultFont = new Font("Arial", Font.PLAIN, 12);

    public static Font getGlobalDefaultFont() {
        return globalDefaultFont;
    }

    public View() {
        super();

        this.menuBar = new JMenuBar();

        this.fileMenu = new JMenu("File");

        this.configureCommand = new JMenuItem("Configure");

        this.exitCommand = new JMenuItem("Quit");


        this.fileMenu.add(this.configureCommand);
        this.fileMenu.add(this.exitCommand);
        this.menuBar.add(this.fileMenu);

        this.emulationMenu = new JMenu("Emulation");

        this.startEmulation = new JMenuItem("Start emulation");

        this.stopEmulation = new JMenuItem("Stop emulation");

        this.emulationMenu.add(this.startEmulation);
        this.emulationMenu.add(this.stopEmulation);
        this.menuBar.add(this.emulationMenu);

        this.helpMenu = new JMenu("Help");

        this.aboutCommand = new JMenuItem("About JavaQemu");

        this.helpMenu.add(this.aboutCommand);
        this.menuBar.add(this.helpMenu);

        this.tabbedPane = new JTabbedPane();

        this.myPanels = new ArrayList<JPanelCreationView>();

        this.activePanel = 0;

        this.createNewVMOption = new Button("Create a new virtual machine");

        this.openExistingVMOption = new Button(
                "Open a existing virtual machine");

        this.useUtilities = new Button("Use the available utilities");

        JPanelCreationView untitledPanel = makeVMPanel("Untitled", "");
        myUntitledJPanel = untitledPanel;

        this.myPanels.add(this.myPanels.size(), untitledPanel);

        tabbedPane.addTab("Untitled", untitledPanel);

        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                processTabChange();
            }
        });

        Component[] components = {
            this.fileMenu, this.configureCommand,
            this.exitCommand, this.emulationMenu,
            this.startEmulation, this.stopEmulation,
            this.helpMenu, this.aboutCommand,
            this.tabbedPane, this.createNewVMOption,
            this.openExistingVMOption, this.useUtilities
        };

        for (Component component : components) {
            component.setFont(this.defaultFont);
        }

        this.gridLayout = new GridLayout(1, 1);

        this.initialize();

        this.initialize_window();

        this.rechecks();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initialize() {
        this.setContentPane(getJContentPane());
        this.setJMenuBar(menuBar);
        this.setTitle("JavaQemu " + Model.getApplicationVersionString());

        this.jContentPane.setLayout(this.gridLayout);

        this.pack();
        this.repaint();
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
        }
        return jContentPane;
    }

    public void configureStandardMode() {
        exitCommand.setActionCommand("ExitCommand");
        configureCommand.setActionCommand("ConfigureCommand");

        startEmulation.setActionCommand("StartEmulation");
        stopEmulation.setActionCommand("StopEmulation");

        aboutCommand.setActionCommand("AboutCommand");

        createNewVMOption.setActionCommand("CreateNewVM");

        openExistingVMOption.setActionCommand("OpenExistingVM");

        useUtilities.setActionCommand("useUtilities");
    }

    public void configureListener(ActionListener listener) {
        exitCommand.addActionListener(listener);
        configureCommand.addActionListener(listener);

        startEmulation.addActionListener(listener);
        stopEmulation.addActionListener(listener);

        aboutCommand.addActionListener(listener);

        createNewVMOption.addActionListener(listener);

        openExistingVMOption.addActionListener(listener);

        useUtilities.addActionListener(listener);

        this.listener = listener;
    }

    public void showMessage(String message) {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(500, 500));
        TextArea textArea = new TextArea(message);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setMargin(new Insets(5, 5, 5, 5));
        scrollPane.getViewport().setView(textArea);
        Object trueMessage = scrollPane;
        JOptionPane.showMessageDialog(null, trueMessage);
    }

    public String getInputMessage(String message) {
        JLabel label = new JLabel(message);
        label.setFont(this.defaultFont);
        return JOptionPane.showInputDialog(label);
    }

    private void initialize_window() {
        this.jContentPane.add(tabbedPane);
    }

    private void rechecks() {
        System.out.println("Repainting screen now...");
        this.pack();
        this.repaint();
    }

    public JPanelCreationView makeVMPanel(String machineName, String filePath) {
        JPanelCreationView panel = null;
        panel = new JPanelCreationView(machineName,
                this.createNewVMOption,
                this.openExistingVMOption,
                this.listener,
                this.useUtilities,
                filePath);
        return panel;
    }

    public void addCreationNewJPanel(JPanelCreationView jpanel, String title) {
        this.myPanels.add(this.myPanels.size(), jpanel);

        this.tabbedPane.addTab(title, jpanel);

        this.tabbedPane.setSelectedIndex(this.myPanels.size() - 1);

        this.activePanel = tabbedPane.getSelectedIndex();

        this.rechecks();
    }

    private void processTabChange() {
        this.activePanel = tabbedPane.getSelectedIndex();
    }

    public JPanelCreationView getSelectedPanel() {
        return this.myPanels.get(activePanel);
    }

    public JPanelCreationView getAnyPanel(int position) {
        if (position >= this.myPanels.size()) {
            this.showMessage("Illegal Event!View!getAnyPanel!\nSelect another position!");
            return null;
        } else {
            return this.myPanels.get(position);
        }
    }

    public int getActivePanel() {
        return activePanel;
    }

    public void removeCreationNewJPanel() {
        this.myPanels.remove(this.activePanel);

        this.tabbedPane.remove(this.activePanel);
    }

    public void removeAllJPanels() {
        for (int i = 0; i < this.myPanels.size(); i++) {
            this.myPanels.remove(i);

            this.tabbedPane.remove(i);
        }
    }

    public void showAboutContents() {
        this.showMessage(/*
                 */"JavaQemu: "
                + "JavaQemu is a graphical user interface for QEMU."
                + /*
                 */ "\nAuthor: " + "Daniel S. F. Bruno.\n"
                + /*
                 */ "JavaQemu License: "
                + "GNU GENERAL PUBLIC LICENSE, VERSION 2." + /*
                 */ "\n"
                + "Version: " + this.getTitle().substring(9) +/*
                 */ "\n");
    }

    public JPanel getMyUntitledJPanel() {
        return this.myUntitledJPanel;
    }

    public void changeNameJPanel(String name) {
        this.tabbedPane.setTitleAt(activePanel, name);
        this.getSelectedPanel().setTitle(name);
    }

    public String getActiveTitle() {
        return this.getSelectedPanel().getTitle();
    }

    public int getSizeOfJTabbedPane() {
        return this.myPanels.size();
    }
}
