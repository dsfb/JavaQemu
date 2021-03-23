package net.sourceforge.javaqemu.view.defined;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class ComboBox<T> extends JComboBox<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComboBox() {
		super();
		this.setFont(Defaults.getFont());
	}

	public ComboBox(ComboBoxModel<T> aModel) {
		super(aModel);
		this.setFont(Defaults.getFont());
	}

	public ComboBox(T[] items) {
		super(items);
		this.setFont(Defaults.getFont());
	}

	public ComboBox(Vector<T> items) {
		super(items);
		this.setFont(Defaults.getFont());
	}

}
