package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.view.VMConfigurationView;
import net.sourceforge.javaqemu.view.View;

public class VMConfigurationControl implements ActionListener {

    private VMConfigurationView myview;
    private RAMControl myram;
    private OptionsDisplayControl mydisplay;
    private HardDiskControl myhd;
    private AdvancedOptionsControl myadvancedoptions;
    private MachineControl mymachine;
    private CPUControl mycpu;
    private CDROMControl mycdrom;
    private FloppyControl myfloppy;
    private BootControl myboot;
    private KeyboardControl mykeyboard;
    private SoundHardwareControl mysoundhardware;
    private SMPControl mysmp;
    private NUMAControl mynuma;
    private MemoryControl mymemory;
    private NetworkManagerControl mynetwork;
    private TimeControl mytime;
    private ImageControl myimage;
    private MonitorControl mymonitor;
    private USBControl myusb;
    private SpecificBootControl myspecificboot;
    private NameControl myName;
    private CustomOptionsControl myCustomOptions;

    public NameControl getMyName() {
        return myName;
    }

    public VMConfigurationControl(EmulationControl myemulation, View view,
            FileControl myfile) {
        myram = new RAMControl(myemulation, myfile);
        System.out.println("myram is ok...");
        myview = new VMConfigurationView(view,
                this.myram.getOption());
        System.out.println("myview is ok...");
        mydisplay = new OptionsDisplayControl(myemulation, myfile);
        System.out.println("mydisplay is ok...");
        myhd = new HardDiskControl(myemulation, myfile);
        System.out.println("myhd is ok...");
        myadvancedoptions = new AdvancedOptionsControl(myemulation, myfile, view);
        System.out.println("myadvancedoptions is ok...");
        mymachine = new MachineControl(myemulation, myfile);
        System.out.println("mymachine is ok...");
        mycpu = new CPUControl(myemulation, myfile);
        System.out.println("mycpu is ok...");
        mycdrom = new CDROMControl(myemulation, myfile);
        System.out.println("mycdrom is ok...");
        myfloppy = new FloppyControl(myemulation, myfile);
        System.out.println("myfloppy is ok...");
        myboot = new BootControl(myemulation, myfile);
        System.out.println("myboot is ok...");
        mykeyboard = new KeyboardControl(myemulation, myfile);
        System.out.println("mykeyboard is ok...");
        mysoundhardware = new SoundHardwareControl(myemulation, myfile);
        System.out.println("mysoundhw is ok...");
        mysmp = new SMPControl(myemulation, myfile);
        System.out.println("mysmp is ok...");
        mynuma = new NUMAControl(myemulation, myfile);
        System.out.println("mynuma is ok...");
        mymemory = new MemoryControl(myemulation, myfile);
        System.out.println("mymem is ok...");
        mynetwork = new NetworkManagerControl(myemulation, myfile);
        System.out.println("mynet is ok...");
        mytime = new TimeControl(myemulation, myfile);
        System.out.println("mytime is ok...");
        myimage = new ImageControl(myemulation, myfile);
        System.out.println("myimg is ok...");
        mymonitor = new MonitorControl(myemulation, myfile);
        System.out.println("mymon is ok...");
        myusb = new USBControl(myemulation, myfile);
        System.out.println("myusb is ok...");
        myspecificboot = new SpecificBootControl(myemulation, myfile);
        System.out.println("myspecboots is ok...");
        myName = new NameControl(myemulation, myfile, view);
        System.out.println("myname is ok...");
        myCustomOptions = new CustomOptionsControl(myemulation, myfile);
        System.out.println("mycustomopts is ok...");
    }

    public void starts() {
        this.myview.setVisible(false);
        this.myview.configureStandardMode();
        this.myview.configureListener(this);
        this.myhd.starts();
        this.mymachine.starts();
        this.mycpu.starts();
        this.mycdrom.starts();
        this.myfloppy.starts();
        this.myboot.starts();
        this.mysmp.starts();
        this.mynuma.starts();
        this.mymemory.starts();
        this.mytime.starts();
        this.myimage.starts();
    }

    public void restarts() {
        this.myview.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("okButton")) {
            this.myram.setOption(this.myview.getEditor().getTextField()
                    .getText().replace(",", "."));

            this.myview.setRamSize(this.myram.getOption());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("resetRamSizeButton")) {
            this.myram.setOption("128.000");
            this.myview.getEditor().getTextField().setText("128,000");
            this.myview.setRamSize(this.myram.getOption());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("showDisplayOptions")) {
            mydisplay.change_my_visibility(true);
        } else if (e.getActionCommand().equals("changeDiskOptionsPaths")) {
            this.myhd.setVisible(true);
        } else if (e.getActionCommand().equals("showAdvancedOptions")) {
            this.myadvancedoptions.change_my_visibility(true);
        } else if (e.getActionCommand().equals("showMachineOptions")) {
            this.mymachine.change_the_visibility_of_type_view(true);
        } else if (e.getActionCommand().equals("showCPUOptions")) {
            this.mycpu.change_the_visibility_of_model_view(true);
        } else if (e.getActionCommand().equals("showCDROMOptions")) {
            this.mycdrom.change_my_visibility(true);
        } else if (e.getActionCommand().equals("showFloppyOptions")) {
            this.myfloppy.change_my_visibility(true);
        } else if (e.getActionCommand().equals("showBootOptions")) {
            this.myboot.change_my_visibility(true);
        } else if (e.getActionCommand().equals("showKeyboardOptions")) {
            this.mykeyboard.change_my_visibility(true);
        } else if (e.getActionCommand().equals("showSoundHardwareOptions")) {
            this.mysoundhardware.change_my_visibility(true);
        } else if (e.getActionCommand().equals("showSMPOptions")) {
            this.mysmp.change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("showNUMAOptions")) {
            this.mynuma.change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("showOtherMemoryOptions")) {
            this.mymemory.change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("showNetworkOptions")) {
            this.mynetwork.change_my_visibility(true);
        } else if (e.getActionCommand().equals("showRtcOptions")) {
            this.mytime.change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("showImageOptions")) {
            this.myimage.change_my_visibility(true);
        } else if (e.getActionCommand().equals("showMonitorOptions")) {
            this.mymonitor.change_my_visibility(true);
        } else if (e.getActionCommand().equals("showUSBOptions")) {
            this.myusb.change_my_visibility(true);
        } else if (e.getActionCommand().equals("showSpecificBootOptions")) {
            this.myspecificboot.change_my_visibility(true);
        } else if (e.getActionCommand().equals("showCustomOptions")) {
            this.myCustomOptions.change_my_visibility(true);
        }
    }
}
