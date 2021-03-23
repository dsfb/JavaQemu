package net.sourceforge.javaqemu.view.defined;

import java.awt.Font;

public class Defaults {
	private final static Font defaultFont = new Font("Arial", Font.PLAIN, 12);
	
	public static Font getFont() {
		return defaultFont;
	}
}
