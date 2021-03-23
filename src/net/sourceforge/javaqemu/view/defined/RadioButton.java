package net.sourceforge.javaqemu.view.defined;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButton;

public class RadioButton extends JRadioButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RadioButton() {
		this.setFont(Defaults.getFont());
	}

	public RadioButton(Icon icon) {
		super(icon);
		this.setFont(Defaults.getFont());
	}

	public RadioButton(Action a) {
		super(a);
		this.setFont(Defaults.getFont());
	}

	public RadioButton(String text) {
		super(text);
		this.setFont(Defaults.getFont());
	}

	public RadioButton(Icon icon, boolean selected) {
		super(icon, selected);
		this.setFont(Defaults.getFont());
	}

	public RadioButton(String text, boolean selected) {
		super(text, selected);
		this.setFont(Defaults.getFont());
	}

	public RadioButton(String text, Icon icon) {
		super(text, icon);
		this.setFont(Defaults.getFont());
	}

	public RadioButton(String text, Icon icon, boolean selected) {
		super(text, icon, selected);
		this.setFont(Defaults.getFont());
	}

}
