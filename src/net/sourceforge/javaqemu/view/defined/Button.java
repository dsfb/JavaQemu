package net.sourceforge.javaqemu.view.defined;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class Button extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Button() {
		super();
		this.setFont(Defaults.getFont());
	}

	public Button(Action a) {
		super(a);
		this.setFont(Defaults.getFont());
	}

	public Button(Icon icon) {
		super(icon);
		this.setFont(Defaults.getFont());
	}

	public Button(String text, Icon icon) {
		super(text, icon);
		this.setFont(Defaults.getFont());
	}

	public Button(String text) {
		super(text);
		this.setFont(Defaults.getFont());
	}
}
