package net.sourceforge.javaqemu.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.sourceforge.javaqemu.view.defined.Button;
import net.sourceforge.javaqemu.view.defined.Label;
import net.sourceforge.javaqemu.view.defined.TextArea;
import net.sourceforge.javaqemu.view.defined.TextField;

public class VMCreationViewPart1 extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private Label chooseMachineNameLabel;

    private TextField choooseMachineNameField;

    private Button cancelButton;

    private Button nextButton;

    public VMCreationViewPart1() {
        super();

        windowContent = new JPanel();

        gridLayout = new GridLayout(2, 2);

        windowContent.setLayout(gridLayout);

        chooseMachineNameLabel = new Label("Choose the name of your new machine:");

        choooseMachineNameField = new TextField(0);

        windowContent.add(chooseMachineNameLabel);

        windowContent.add(choooseMachineNameField);

        cancelButton = new Button("Cancel");

        nextButton = new Button("Next >");

        windowContent.add(nextButton);

        windowContent.add(cancelButton);
    }

    public void initialize() {
        this.setContentPane(windowContent);
        this.setTitle("Create a new machine - Part 1");
        this.pack();
    }

    public void configureListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
        nextButton.addActionListener(listener);
    }

    public void configureStandardMode() {
        cancelButton.setActionCommand("Cancel1");
        nextButton.setActionCommand("Next1");
    }

    public JTextField getFieldChoooseMachineName() {
        return choooseMachineNameField;
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
}
