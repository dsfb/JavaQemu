package net.sourceforge.javaqemu.view.defined;

import javax.swing.JTextArea;
import javax.swing.text.Document;

public class TextArea extends JTextArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextArea() {
		super();
		this.setFont(Defaults.getFont());
	}

	public TextArea(Document doc, String text, int rows, int columns) {
		super(doc, text, rows, columns);
		this.setFont(Defaults.getFont());
	}

	public TextArea(Document doc) {
		super(doc);
		this.setFont(Defaults.getFont());
	}

	public TextArea(int rows, int columns) {
		super(rows, columns);
		this.setFont(Defaults.getFont());
	}

	public TextArea(String text, int rows, int columns) {
		super(text, rows, columns);
		this.setFont(Defaults.getFont());
	}

	public TextArea(String text) {
		super(text);
		this.setFont(Defaults.getFont());
	}
}
