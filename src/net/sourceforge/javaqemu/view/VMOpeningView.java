package net.sourceforge.javaqemu.view;

public class VMOpeningView {

    private View view;

    private JPanelCreationView mypanel;

    private String chosenMachineName;
    private String fullFilePath;

    public VMOpeningView(View view, String chosenMachineName, String filePath) {
        this.mypanel = null;
        this.view = view;
        this.chosenMachineName = chosenMachineName;
        this.fullFilePath = filePath;
    }

    public boolean starts(String diskImagePath, String secondDiskImagePath,
            String thirdDiskImagePath, String fourthDiskImagePath,
            String ramSize) {
        this.mypanel = (JPanelCreationView) this.view
                .makeVMPanel(chosenMachineName, this.fullFilePath);
        if (ramSize != null) {
            if (!ramSize.isEmpty()) {
                this.mypanel.setRamSize(ramSize);
            }
        } else {
            this.mypanel.setRamSize("128");
        }
        this.view.addCreationNewJPanel(mypanel, chosenMachineName);
        return true;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setChosenMachineName(String chosenMachineName) {
        this.chosenMachineName = chosenMachineName;
    }

	public String getFullFilePath() {
		return fullFilePath;
	}
}
