package gui;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

	}

}
