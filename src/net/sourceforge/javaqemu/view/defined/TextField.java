package net.sourceforge.javaqemu.view.defined;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class TextField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextField() {
		super();
		this.setFont(Defaults.getFont());
	}

	public TextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		this.setFont(Defaults.getFont());
	}

	public TextField(int columns) {
		super(columns);
		this.setFont(Defaults.getFont());
	}

	public TextField(String text, int columns) {
		super(text, columns);
		this.setFont(Defaults.getFont());
	}

	public TextField(String text) {
		super(text);
		this.setFont(Defaults.getFont());
	}

}
