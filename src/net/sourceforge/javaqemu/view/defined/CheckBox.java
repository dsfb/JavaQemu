package net.sourceforge.javaqemu.view.defined;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;

public class CheckBox extends JCheckBox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CheckBox() {
		super();
		this.setFont(Defaults.getFont());
	}

	public CheckBox(Action a) {
		super(a);
		this.setFont(Defaults.getFont());
	}

	public CheckBox(Icon icon, boolean selected) {
		super(icon, selected);
		this.setFont(Defaults.getFont());
	}

	public CheckBox(Icon icon) {
		super(icon);
		this.setFont(Defaults.getFont());
	}

	public CheckBox(String text, boolean selected) {
		super(text, selected);
		this.setFont(Defaults.getFont());
	}

	public CheckBox(String text, Icon icon, boolean selected) {
		super(text, icon, selected);
		this.setFont(Defaults.getFont());
	}

	public CheckBox(String text, Icon icon) {
		super(text, icon);
		this.setFont(Defaults.getFont());
	}

	public CheckBox(String text) {
		super(text);
		this.setFont(Defaults.getFont());
	}

}
