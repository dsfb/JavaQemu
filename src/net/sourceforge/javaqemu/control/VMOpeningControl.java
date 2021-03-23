package net.sourceforge.javaqemu.control;

import net.sourceforge.javaqemu.model.VMOpeningModel;
import net.sourceforge.javaqemu.view.VMOpeningView;
import net.sourceforge.javaqemu.view.View;

public class VMOpeningControl {

    private VMOpeningModel mymodel;
    private VMOpeningView myview;

    public VMOpeningControl(View view, EmulationControl myemulation, FileControl myfile) {
        this.mymodel = new VMOpeningModel(myemulation, myfile);
        System.out.println("Building VMOpeningView...");
        this.myview = new VMOpeningView(view, this.mymodel.getMyfile().getMymodel().getMachineName(),
        	myfile.getMyview().getChoice());
        System.out.println("Built VMOpeningView...");
    }

    public boolean starts(FileControl myfile) {
    	System.out.println("Starting VMOpeningModel...");
        this.mymodel.starts();        
        this.myview.setChosenMachineName(myfile.getMymodel().getMachineName());
        System.out.println("Starting VMOpeningView...");
        this.myview.starts(this.mymodel.getDiskImagePath(),
                myfile.getMymodel().getSecondHardDiskOption(),
                myfile.getMymodel().getThirdHardDiskOption(),
                myfile.getMymodel().getFourthHardDiskOption(),
                myfile.getMymodel().getRamSize());
        System.out.println("Started VMOpeningView...");
        return true;
    }

    public void setView(View view) {
        this.myview.setView(view);
    }

    public void setMyemulation(EmulationControl myemulation) {
        this.mymodel.setMyemulation(myemulation);
    }

    public void setMyfile(FileControl myfile) {
        this.mymodel.setMyfile(myfile);
    }
}
