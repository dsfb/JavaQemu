package net.sourceforge.javaqemu.view.defined;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Label extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Label() {
		super();
		this.setFont(Defaults.getFont());
	}

	public Label(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		this.setFont(Defaults.getFont());
	}

	public Label(Icon image) {
		super(image);
		this.setFont(Defaults.getFont());
	}

	public Label(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		this.setFont(Defaults.getFont());
	}

	public Label(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		this.setFont(Defaults.getFont());
	}

	public Label(String text) {
		super(text);
		this.setFont(Defaults.getFont());
	}

}
