package net.sourceforge.javaqemu.view.defined;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

public class Spinner extends JSpinner {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Spinner() {
		super();
		this.setFont(Defaults.getFont());
	}

	public Spinner(SpinnerModel model) {
		super(model);
		this.setFont(Defaults.getFont());
	}

}
