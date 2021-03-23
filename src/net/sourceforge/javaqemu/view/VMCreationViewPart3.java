package net.sourceforge.javaqemu.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import net.sourceforge.javaqemu.view.defined.Button;
import net.sourceforge.javaqemu.view.defined.CheckBox;
import net.sourceforge.javaqemu.view.defined.ComboBox;
import net.sourceforge.javaqemu.view.defined.Label;
import net.sourceforge.javaqemu.view.defined.RadioButton;
import net.sourceforge.javaqemu.view.defined.Spinner;
import net.sourceforge.javaqemu.view.defined.TextField;

public class VMCreationViewPart3 extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridBagLayout gridBagLayout;

    private GridBagConstraints gridBagConstraints;

    private Label windowDescription;

    private Label diskImageSizeDescription;

    private Spinner diskImageSize;

    private SpinnerModel spinnerModel;

    private JSpinner.NumberEditor editor;

    private DecimalFormat format;

    private Label measureUnity;

    private Button cancelButton;

    private Button backButton;

    private Button finishButton;

    private Label diskNameDescription;

    private TextField diskName;

    private Label diskExtensionDescription;

    private ComboBox<String> diskExtension;

    private String oldDiskExtension;

    private boolean suboptions;

    private CheckBox encryption_box;

    private CheckBox preallocation_metadata_box;

    private CheckBox cluster_size_box;

    private ComboBox<String> cluster_size_options;

    private RadioButton static_vdi_box;

    private CheckBox compat6_vmdk_box;

    private CheckBox subformat_vmdk_box;

    private ComboBox<String> subformat_vmdk_combo;

    private RadioButton subformat_vpc_box;

    private ComboBox<String> subformat_vpc_combo;

    public VMCreationViewPart3() {
        super();

        windowContent = new JPanel();

        gridBagLayout = new GridBagLayout();
        this.gridBagConstraints = new GridBagConstraints();

        windowContent.setLayout(gridBagLayout);

        windowDescription = new Label("Specify disk image details:");

        diskImageSizeDescription = new Label("Disk image size:");

        this.spinnerModel = new SpinnerNumberModel(0.0, // initial value
                0.0, // min
                4096.0, // max
                1); // step

        this.diskImageSize = new Spinner(spinnerModel);

        editor = (JSpinner.NumberEditor) this.diskImageSize
                .getEditor();
        format = editor.getFormat();
        format.setMinimumFractionDigits(3);
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);

        this.measureUnity = new Label("GB");

        cancelButton = new Button("Cancel");

        backButton = new Button("< Back");

        finishButton = new Button("Finish");

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;

        windowContent.add(windowDescription, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridwidth = 1;

        windowContent.add(diskImageSizeDescription, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;

        windowContent.add(diskImageSize, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;

        windowContent.add(measureUnity, gridBagConstraints);

        diskNameDescription = new Label("Type the name of the disk image file:");

        diskName = new TextField("");

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;

        windowContent.add(diskNameDescription, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;

        windowContent.add(diskName, gridBagConstraints);

        diskExtensionDescription = new Label("Choose the format of the disk image file:");

        String[] formats = {".img", ".qcow2", ".qcow", ".cow", ".vdi", ".vmdk", ".vpc"};

        diskExtension = new ComboBox<String>(formats);
        diskExtension.setSelectedIndex(0);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        windowContent.add(diskExtensionDescription, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;

        windowContent.add(diskExtension, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;

        windowContent.add(backButton, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;

        windowContent.add(finishButton, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;

        windowContent.add(cancelButton, gridBagConstraints);

        suboptions = false;

        oldDiskExtension = (String) diskExtension.getSelectedItem();

        encryption_box = new CheckBox("Encryption mode: on");

        preallocation_metadata_box = new CheckBox("Preallocation mode: metadata");

        cluster_size_box = new CheckBox("Cluster_size:");

        String[] sizes = {"512k", "1M", "2M"};

        cluster_size_options = new ComboBox<String>(sizes);
        cluster_size_options.setSelectedIndex(0);

        static_vdi_box = new RadioButton("Static option: on");

        compat6_vmdk_box = new CheckBox("Compat6 option: on");

        subformat_vmdk_box = new CheckBox("VMDK subformat option:");

        String[] subformats_vmdk = {"monolithicSparse", "monolithicFlat", "twoGbMaxExtentSparse",
            "twoGbMaxExtentFlat", "streamOptimized"};

        subformat_vmdk_combo = new ComboBox<String>(subformats_vmdk);
        subformat_vmdk_combo.setSelectedIndex(0);

        subformat_vpc_box = new RadioButton("VPC subformat option:");

        String[] subformats_vpc = {"dynamic", "fixed"};

        subformat_vpc_combo = new ComboBox<String>(subformats_vpc);

    }

    public void initialize() {
        this.setContentPane(windowContent);
        this.setTitle("Create a new machine - Part 3");
        this.pack();
    }

    public void configureListener(ActionListener listener) {
        backButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
        finishButton.addActionListener(listener);
        diskExtension.addActionListener(listener);
    }

    public void configureStandardMode() {
        backButton.setActionCommand("Back2");
        cancelButton.setActionCommand("Cancel3");
        finishButton.setActionCommand("Finish");
        diskExtension.setActionCommand("DiskExtension");
    }

    public JSpinner.NumberEditor getEditor() {
        return editor;
    }

    public JTextField getDiskName() {
        return diskName;
    }

    public JComboBox<String> getDiskExtension() {
        return diskExtension;
    }

    public void addsComponent(String diskExtension) {
        if (suboptions) {
            this.removesComponent(oldDiskExtension);
            suboptions = false;
            this.addsComponent(diskExtension);
        } else if (diskExtension.equals(".img")) {
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;

            windowContent.add(cancelButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 4;

            windowContent.add(backButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 4;

            windowContent.add(finishButton, gridBagConstraints);
            oldDiskExtension = ".img";
        } else if (diskExtension.equals(".cow")) {
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;

            windowContent.add(cancelButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 4;

            windowContent.add(backButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 4;

            windowContent.add(finishButton, gridBagConstraints);
            oldDiskExtension = ".cow";
        } else if (diskExtension.equals(".qcow")) {
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;
            windowContent.add(encryption_box, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 5;

            windowContent.add(cancelButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 5;

            windowContent.add(backButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 5;

            windowContent.add(finishButton, gridBagConstraints);
            oldDiskExtension = ".qcow";
            suboptions = true;
        } else if (diskExtension.equals(".qcow2")) {
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;
            windowContent.add(encryption_box, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 4;
            windowContent.add(preallocation_metadata_box, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 5;
            windowContent.add(cluster_size_box, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 5;
            windowContent.add(cluster_size_options, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 6;

            windowContent.add(cancelButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 6;

            windowContent.add(backButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 6;

            windowContent.add(finishButton, gridBagConstraints);
            oldDiskExtension = ".qcow2";
            suboptions = true;
        } else if (diskExtension.equals(".vdi")) {
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;

            windowContent.add(static_vdi_box, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 5;

            windowContent.add(cancelButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 5;

            windowContent.add(backButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 5;

            windowContent.add(finishButton, gridBagConstraints);
            oldDiskExtension = ".vdi";
            suboptions = true;
        } else if (diskExtension.equals(".vmdk")) {
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;

            windowContent.add(compat6_vmdk_box, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 5;

            windowContent.add(subformat_vmdk_box, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 5;

            windowContent.add(subformat_vmdk_combo, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 6;

            windowContent.add(cancelButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 6;

            windowContent.add(backButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 6;

            windowContent.add(finishButton, gridBagConstraints);
            oldDiskExtension = ".vmdk";
            suboptions = true;
        } else if (diskExtension.equals(".vpc")) {
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;

            windowContent.add(subformat_vpc_box, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 4;

            windowContent.add(subformat_vpc_combo, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 5;

            windowContent.add(cancelButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 5;

            windowContent.add(backButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 5;

            windowContent.add(finishButton, gridBagConstraints);
            oldDiskExtension = ".vpc";
            suboptions = true;
        }
        this.pack();
        this.repaint();
    }

    public void removesComponent(String diskExtension) {
        if (diskExtension.equals(".qcow")) {
            windowContent.remove(encryption_box);
        } else if (diskExtension.equals(".qcow2")) {
            windowContent.remove(encryption_box);
            windowContent.remove(preallocation_metadata_box);
            windowContent.remove(cluster_size_box);
            windowContent.remove(cluster_size_options);
        } else if (diskExtension.equals(".vdi")) {
            windowContent.remove(static_vdi_box);
        } else if (diskExtension.equals(".vmdk")) {
            windowContent.remove(compat6_vmdk_box);
            windowContent.remove(subformat_vmdk_box);
            windowContent.remove(subformat_vmdk_combo);
        } else if (diskExtension.equals(".vpc")) {
            windowContent.remove(subformat_vpc_box);
            windowContent.remove(subformat_vpc_combo);
        }
        windowContent.remove(cancelButton);
        windowContent.remove(backButton);
        windowContent.remove(finishButton);
    }

    public JCheckBox getEncryption_box() {
        return encryption_box;
    }

    public JCheckBox getPreallocation_metadata_box() {
        return preallocation_metadata_box;
    }

    public JCheckBox getCluster_size_box() {
        return cluster_size_box;
    }

    public JComboBox<String> getCluster_size_options() {
        return cluster_size_options;
    }

    public JRadioButton getStatic_vdi_box() {
        return static_vdi_box;
    }

    public JCheckBox getCompat6_vmdk_box() {
        return compat6_vmdk_box;
    }

    public JCheckBox getSubformat_vmdk_box() {
        return subformat_vmdk_box;
    }

    public JComboBox<String> getSubformat_vmdk_combo() {
        return subformat_vmdk_combo;
    }

    public JRadioButton getSubformat_vpc_box() {
        return subformat_vpc_box;
    }

    public JComboBox<String> getSubformat_vpc_combo() {
        return subformat_vpc_combo;
    }
}
