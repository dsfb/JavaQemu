package net.sourceforge.javaqemu.main;

import net.sourceforge.javaqemu.control.Control;
import net.sourceforge.javaqemu.view.View;

import javax.swing.UIManager;

public class JavaQemu {

    public static void main(String[] args) {
    	try {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	} catch (Exception e) {
    		
    	}

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                View view = new View();
                Control control = new Control(view);

                control.starts();
            }
        });
    }
}
